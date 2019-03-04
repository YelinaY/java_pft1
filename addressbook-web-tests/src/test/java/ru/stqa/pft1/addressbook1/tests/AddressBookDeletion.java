package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddressBookDeletion extends TestBase {
  @Test
  public void testGroupDeletion() {
    app.getGroupContactHelper().gotoHomePage();
    if (!app.getGroupContactHelper().isThereAddressBook()) {
      app.getGroupContactHelper().createContact(new ContactData("Eлена", "Yel", "Yelina", "Lina", "TCWD",
              "Paris, Royal sq.", "+1111111111", "+222222222", "+33333333",
              "+44444444", "mail@mail.com", "mail1@mail.com", "mail3@mail.com", "URL",
              "Minsk", "+5555555555", "Notes"));
    }
    app.getGroupContactHelper().gotoHomePage();
    List<ContactData> before = app.getGroupContactHelper().getContactList();
    // int before = app.getGroupContactHelper().getContactCount();
    app.getGroupContactHelper().selectAddressBook(before.size() - 2);
    // app.getGroupContactHelper().selectAddressBook(before -1); // удаление первого контакта в списке
    app.getGroupContactHelper().deleteSelectedAddressBook();
    app.getGroupContactHelper().confirmDeletion();
    List<ContactData> after = app.getGroupContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
    //int after = app.getGroupContactHelper().getContactCount();
    //Assert.assertEquals(after, before -1); //сравнение количества контактов до и после удаления
    // before.remove(before.size()-1); //  удаляю лишний элемент
    //Assert.assertEquals(before, after);
    before.remove(before.size() - 1);//удаляем лишний элемент перед сравнением списков
    Assert.assertEquals(before, after); //сравниваем списки
  }
}
