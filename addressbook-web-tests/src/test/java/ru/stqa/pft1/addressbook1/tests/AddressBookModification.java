package ru.stqa.pft1.addressbook1.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;

public class AddressBookModification extends TestBase {
  @Test
  public void testAddressBookModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getNavigationHelper().editAddrassBook();
    app.getGroupHelper().fillAddressBookForm(new ContactData("Yuliya", "Y/Y", "Yelina", "Lina", "TCWD", "Paris, Royal sq.", "+1111111111", "+222222222", "+33333333", "+44444444", "mail@mail.com", "mail1@mail.com", "mail3@mail.com", "URL", "Minsk", "+5555555555", "Notes"));
    app.getNavigationHelper().updateAddressBook();

  }
}

