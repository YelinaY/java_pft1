package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class AddressBookCreationTests extends TestBase {
  @Test
  public void testNewAddressBookCreation() {
    app.groupsContacts().gotoHomePage();
    Set<ContactData> before = app.groupsContacts().allc();
    ContactData contact = new ContactData().withUserfirstname("Eлена").withUserlastname("Yelina");
    app.groupsContacts().createContact(contact);
    app.groupsContacts().gotoHomePage();
    Set<ContactData> after = app.groupsContacts().allc();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after); //сравниваем списки
     }
}
