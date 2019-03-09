package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;
import java.util.List;
import java.util.Set;

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
    Set<ContactData> before = app.groupsContacts().allc();
    ContactData deletedContact = before.iterator().next();
    app.groupsContacts().deleteContact(deletedContact);
    Set<ContactData> after = app.groupsContacts().allc();
    Assert.assertEquals(after.size(),before.size() -1);
    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }


}
