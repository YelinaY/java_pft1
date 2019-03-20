package ru.stqa.pft1.addressbook1.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;
import ru.stqa.pft1.addressbook1.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressBookDeletion extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.groupsContacts().gotoHomePage();
        app.groupsContacts().createContact(new ContactData().withUserfirstname("Yelena").withUserlastname("Yelin"));
      }
    }
  @Test
  public void testGroupDeletion() {
    app.groupsContacts().gotoHomePage();
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.groupsContacts().deleteContact(deletedContact);
    assertThat(app.groupsContacts().contactCount(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withOutc(deletedContact)));
    verifyContactListUI();

  }
}
