package ru.stqa.pft1.addressbook1.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;
import ru.stqa.pft1.addressbook1.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddressBookModification extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.groupsContacts().gotoHomePage();
      app.groupsContacts().createContact(new ContactData(). withFirstname("Yelena").withLastname("Yelina"));
    }
  }
  @Test
  public void testAddressBookModification() {
    app.groupsContacts().gotoHomePage();
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("test1").withLastname("test2").withAddress("test3").withHomePhone("test4").withMobilePhone("test5").withEmail1("test6");
    app.groupsContacts().modifyContact(contact);
    assertThat(app.groupsContacts().contactCount(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withOutc(modifiedContact).withAddedc(contact)));
    verifyContactListUI();
  }

}
/* app.goTo().homePage();
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("test1").withLastname("test2").withAddress("test3").withHomePhone("test4").withMobilePhone("test5").withEmail1("test6");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUi();

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

 */
