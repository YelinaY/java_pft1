package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;

public class AddressBookDeletion extends TestBase {

/*if (! app.getGroupContactHelper().isThereAGroup()){
      app.getGroupContactHelper().createGroup(new GroupData("Test1", null, "Test3"));
    }
 */
  @Test
  public void testGroupDeletion() {
    app.getGroupContactHelper().gotoHomePage();
    if (! app.getGroupContactHelper().isThereAddressBook()){
      app.getGroupContactHelper().createContact(new ContactData("Eлена", "Yel", "Yelina", "Lina", "TCWD",
              "Paris, Royal sq.", "+1111111111", "+222222222", "+33333333",
              "+44444444", "mail@mail.com", "mail1@mail.com", "mail3@mail.com", "URL",
              "Minsk", "+5555555555", "Notes", "Test1"),true);
      }
    app.getGroupContactHelper().gotoHomePage();
    int before = app.getGroupContactHelper().getContactCount();
      app.getGroupContactHelper().selectAddressBook((before -1));
     app.getGroupContactHelper().deleteSelectedAddressBook();
    app.getGroupContactHelper().confirmDeletion();
    int after = app.getGroupContactHelper().getContactCount();
    Assert.assertEquals(after, before -1); //сравнение количества контактов до и после удаления
  }
}
