package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class AddressBookModification extends TestBase {
  @Test
  public void testAddressBookModification() {
    app.getGroupContactHelper().gotoHomePage();
    if (!app.getGroupContactHelper().isThereAddressBook()) {
      app.getGroupContactHelper().createContact(new ContactData("Eлена", "Yel", "Yelina", "Lina", "TCWD",
              "Paris, Royal sq.", "+1111111111", "+222222222", "+33333333",
              "+44444444", "mail@mail.com", "mail1@mail.com", "mail3@mail.com", "URL",
              "Minsk", "+5555555555", "Notes"));
    }
    app.getGroupContactHelper().gotoHomePage();
    List<ContactData> before = app.getGroupContactHelper().getContactList();
    //int before = app.getGroupContactHelper().getContactCount();
    ContactData contact = null;
    app.getGroupContactHelper().editAddressBook(contact.getId());
    contact = new ContactData("Eлена", "Yel", "Yelina", "Lina", "TCWD",
            "Paris, Royal sq.", "+1111111111", "+222222222", "+33333333",
            "+44444444", "mail@mail.com", "mail1@mail.com", "mail3@mail.com", "URL",
            "Minsk", "+5555555555", "Notes");
    app.getGroupContactHelper().fillAddressBookForm(contact);
    app.getGroupContactHelper().updateAddressBook();
    List<ContactData> after = app.getGroupContactHelper().getContactList();
    // int after = app.getGroupContactHelper().getContactCount();
    Assert.assertEquals(after.size(), before.size());
    // Assert.assertEquals(after, before); //сравнение количества контактов до и после модиффикации
    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after)); //сравниваем списки

  }
}

