package ru.stqa.pft1.addressbook2.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook2.model.ContactData;
import ru.stqa.pft1.addressbook2.model.Contacts;
import ru.stqa.pft1.addressbook2.model.GroupData;
import ru.stqa.pft1.addressbook2.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddingContactToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withFirstname("Yelena").withLastname("Korsakova").withAddress("Minsk").
                      withHomePhone("1111111111").withMobilePhone("22222222222").withWorkPhone("33333333333").withEmail1("email@email.com"));
    }
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
    }
    if (app.db().contacts().iterator().next().getGroups().size() == app.db().groups().size()) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
    }
  }

  @Test
  public void testAddingContactToGroup() {
    app.goTo().homePage();
    Contacts contactsBefore = app.db().contacts();
    Groups groupList = app.db().groups();
    ContactData selectedContact = contactsBefore.iterator().next();
    GroupData toGroup = groupList.iterator().next();
    app.contact().addContactToGroup(selectedContact, toGroup);
    Contacts contactsAfter = app.db().contacts();
    assertThat(contactsAfter.iterator().next().getGroups(), equalTo(contactsBefore.iterator().next().getGroups().withAdded(toGroup)));
    verifyContactListInUi();
  }

}