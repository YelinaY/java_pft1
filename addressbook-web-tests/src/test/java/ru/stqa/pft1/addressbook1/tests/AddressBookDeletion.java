package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;

public class AddressBookDeletion extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoHomePage();

    if (! app.getGroupHelper().isThereAddressBook()){
      app.getNavigationHelper().initAddressBookCreation();
      app.getGroupHelper().fillAddressBookForm(new ContactData("Eлена", "Yel", "Yelina", "Lina", "TCWD",
              "Paris, Royal sq.", "+1111111111", "+222222222", "+33333333",
              "+44444444", "mail@mail.com", "mail1@mail.com", "mail3@mail.com", "URL",
              "Minsk", "+5555555555", "Notes", "Test1"), true);
      app.getNavigationHelper().submitNewAddressBook();
      }
    int before = app.getGroupHelper().getAddressCount();
    app.getGroupHelper().selectAddressBook(before -1); // удалить последнюю группу
    app.getGroupHelper().deleteSelectedAddressBook();
    app.getGroupHelper().confirmDeletion();
    int after = app.getGroupHelper().getAddressCount();
    Assert.assertEquals(after, before - 1);
  }
}
