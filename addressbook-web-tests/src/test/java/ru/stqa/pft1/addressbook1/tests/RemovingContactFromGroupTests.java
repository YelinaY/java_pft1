package ru.stqa.pft1.addressbook1.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;
import ru.stqa.pft1.addressbook1.model.Contacts;
import ru.stqa.pft1.addressbook1.model.GroupData;
import ru.stqa.pft1.addressbook1.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemovingContactFromGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size()==0){
      app.groupsContacts().groupPage();
      app.groupsContacts().createGroup(new GroupData().withName("test2"));
      } if (app.db().contacts().size() == 0) {
      app.groupsContacts().gotoHomePage();
      Groups before = app.db().groups();
      File photo = new File("src/test/resources/png.png");
      ContactData newContact = new ContactData().withFirstname("Yelena").withLastname("Yelina").
              withPhoto(photo).inGroup(before.iterator().next());
      app.groupsContacts().createContact(new ContactData().withFirstname("Yelena").withLastname("Yelina"));
      }
    }

  @Test
  public void testAddressBookModification() {
    app.groupsContacts().gotoHomePage();
  Contacts before = app.db().contacts();
    Groups groupBefore = app.db().groups();
    GroupData fromGroup = groupBefore.iterator().next();
    app.groupsContacts().gotoHomePage();
    ContactData deletedContact = before.iterator().next();
    app.groupsContacts().deleteContact(deletedContact);
    assertThat(app.groupsContacts().contactCount(), equalTo(before.size() - 1));
   Contacts after = app.db().contacts();
    app.groupsContacts().goToGroup();
    verifyContactListUI();

  }
}

