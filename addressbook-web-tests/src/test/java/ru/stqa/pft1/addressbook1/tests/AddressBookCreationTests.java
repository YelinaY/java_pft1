package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class AddressBookCreationTests extends TestBase {

  @Test
  public void testNewAddressBookCreation() {
    app.getGroupContactHelper().gotoHomePage();
   List<ContactData> before = app.getGroupContactHelper().getContactList();
    //int before = app.getGroupContactHelper().getContactCount();
    ContactData contact = new ContactData("Eлена", null, "Yelina",
            null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    app.getGroupContactHelper().createContact(contact);
    app.getGroupContactHelper().gotoHomePage();
  List<ContactData> after = app.getGroupContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() +1);

    after.remove(after.size()-1); //удаляем лишний элемент перед сравнением списков
    Assert.assertEquals(before,after); //сравниваем списки
    before.add(contact);
    int max = 0;
    for (ContactData c : after) {
      if (c.getId() > max){
    }
    }
    before.add(contact);
    contact.setId(max);
    Assert.assertEquals( new HashSet<Object>(before), new HashSet<Object>(after)); //сравниваем списки

    //  Assert.assertEquals(after.size(), before.size() +1);
    //int after = app.getGroupContactHelper().getContactCount();
    //Assert.assertEquals(after, before +1); //сравнение количества контактов до и после создания

  }

}
