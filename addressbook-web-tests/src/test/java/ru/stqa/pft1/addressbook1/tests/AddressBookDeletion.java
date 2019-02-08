package ru.stqa.pft1.addressbook1.tests;

import org.testng.annotations.Test;

public class AddressBookDeletion extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoHomePage();
    app.getGroupHelper().selectAddressBook();
    app.getGroupHelper().deleteSelectedAddressBook();
    app.getGroupHelper().confirmDeletion();

  }
}
