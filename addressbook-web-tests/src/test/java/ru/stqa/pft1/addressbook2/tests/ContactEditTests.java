package ru.stqa.pft1.addressbook2.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook2.model.ContactData;
import ru.stqa.pft1.addressbook2.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEditTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withFirstname("Yelena").withLastname("Korsakova").withAddress("Minsk").
                      withHomePhone("1111111111").withMobilePhone("22222222222").withWorkPhone("33333333333").withEmail1("email@email.com"));
    }
  }

  @Test
  public void testContactEdit() throws Exception {
    app.goTo().homePage();
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("test1").withLastname("test2").withAddress("test3").withHomePhone("test4").withMobilePhone("test5").withEmail1("test6");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUi();
  }

}