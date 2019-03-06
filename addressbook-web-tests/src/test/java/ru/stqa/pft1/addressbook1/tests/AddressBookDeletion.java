package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;
import java.util.List;

public class AddressBookDeletion extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.contacstGroups().gotoHomePage();
    if (!app.contacstGroups().isThereAddressBook()) {
      app.contacstGroups().createContact(new ContactData("Eлена", "Yel", "Yelina", "Lina", "TCWD",
              "Paris, Royal sq.", "+1111111111", "+222222222", "+33333333",
              "+44444444", "mail@mail.com", "mail1@mail.com", "mail3@mail.com", "URL",
              "Minsk", "+5555555555", "Notes"));
    }
  }


  @Test
  public void testGroupDeletion() {
    app.contacstGroups().gotoHomePage();
    List<ContactData> before = app.contacstGroups().contactList();
    int index = before.size() - 1;
    app.contacstGroups().deleteContact(index);
    List<ContactData> after = app.contacstGroups().contactList();
    Assert.assertEquals(after.size(), index);
    before.remove(index);//удаляем лишний элемент перед сравнением списков
    Assert.assertEquals(before, after); //сравниваем списки
  }


}
