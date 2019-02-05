package ru.stqa.pft1.addressbook1.tests;


import org.testng.annotations.Test;

public class NewAddressBookCreationTests extends TestBase{

  @Test
  public void testNewAddressBookCreation() throws Exception {
    goToGroupPage();
    initAddressBookCreation();
    fillAddressBookForm("Eлена", "Y/Y", "Yelina", "Lina", "TCWD", "Paris, Royal sq.", "+1111111111", "+222222222", "+33333333", "+44444444", "mail@mail.com", "mail1@mail.com", "mail3@mail.com", "URL", "Minsk", "+5555555555", "Notes");
    submitNewAddressBook();
  }


}