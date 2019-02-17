package ru.stqa.pft1.addressbook1.tests;

import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;

public class AddressBookModification extends TestBase {
  @Test
  public void testAddressBookModification() {
    app.getGroupHelper().gotoHomePage();
    if (! app.getGroupHelper().isThereAddressBook()){
      app.getGroupHelper().initAddressBookCreation();
      app.getGroupHelper().fillAddressBookForm(new ContactData("Eлена", "Yel", "Yelina", "Lina", "TCWD",
              "Paris, Royal sq.", "+1111111111", "+222222222", "+33333333",
              "+44444444", "mail@mail.com", "mail1@mail.com", "mail3@mail.com", "URL",
              "Minsk", "+5555555555", "Notes", "Test1"));
      app.getGroupHelper().submitNewAddressBook();
    }
    app.getGroupHelper().gotoHomePage();
    app.getGroupHelper().editAddressBook();
    app.getGroupHelper().fillAddressBookForm(new ContactData("Eлена", "Yel", "Yelina", "Lina", "TCWD",
            "Paris, Royal sq.", "+1111111111", "+222222222", "+33333333",
            "+44444444", "mail@mail.com", "mail1@mail.com", "mail3@mail.com", "URL",
            "Minsk", "+5555555555", "Notes", "Test1"));
    app.getGroupHelper().updateAddressBook();
  }
}

