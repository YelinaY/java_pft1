package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;
import java.util.List;

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
    List<ContactData> before = app.groupsContacts().contactList();
    int index = before.size() - 1;
    app.groupsContacts().deleteContact(index);
    List<ContactData> after = app.groupsContacts().contactList();
    Assert.assertEquals(after.size(), index);
    before.remove(index);//удаляем лишний элемент перед сравнением списков
    Assert.assertEquals(before, after); //сравниваем списки
  }


}
