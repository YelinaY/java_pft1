package ru.stqa.pft1.addressbook1.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;
import ru.stqa.pft1.addressbook1.model.Contacts;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class AddressBookDeletion extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.groupsContacts().gotoHomePage();
    if (!app.groupsContacts().isThereAddressBook()) {
      app.groupsContacts().createContact(new ContactData().withUserfirstname("Yelena").withUserlastname("Yelin"));
    }
  }


  @Test
  public void testGroupDeletion() {
    app.groupsContacts().gotoHomePage();
    Contacts before = app.groupsContacts().allc();
    ContactData deletedContact = before.iterator().next();
    app.groupsContacts().deleteContact(deletedContact);
    Contacts after = app.groupsContacts().allc();
    assertEquals(after.size(),before.size() -1);

    assertThat(after, equalTo(before.withOutc(deletedContact)));
  }


}
