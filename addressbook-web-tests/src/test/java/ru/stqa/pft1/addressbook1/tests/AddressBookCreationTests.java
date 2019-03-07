package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class AddressBookCreationTests extends TestBase {
  @Test
  public void testNewAddressBookCreation() {
    app.groupsContacts().gotoHomePage();
    List<ContactData> before = app.groupsContacts().contactList();
    ContactData contact = new ContactData().withUserfirstname("Eлена").withUserlastname("Yelina");
    app.groupsContacts().createContact(contact);
    app.groupsContacts().gotoHomePage();
    List<ContactData> after = app.groupsContacts().contactList();
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after); //сравниваем списки
     }
}
