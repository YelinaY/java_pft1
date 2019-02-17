package ru.stqa.pft1.addressbook1.tests;

import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;

public class AddressBookModification extends TestBase {
  @Test
  public void testAddressBookModification() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getGroupHelper().isThereAddressBook()){
      app.getNavigationHelper().initAddressBookCreation();
      app.getGroupHelper().fillAddressBookForm(new ContactData("Eлена", "Yel", "Yelina", "Lina", "TCWD",
              "Paris, Royal sq.", "+1111111111", "+222222222", "+33333333",
              "+44444444", "mail@mail.com", "mail1@mail.com", "mail3@mail.com", "URL",
              "Minsk", "+5555555555", "Notes", "Test1"), true);
      app.getNavigationHelper().submitNewAddressBook();
    }
    app.getNavigationHelper().editAddrassBook();
    app.getGroupHelper().fillAddressBookForm(new ContactData("Yuliya", null, "Yelina",
            "Lina", "TCWD", "Paris, Royal sq.", "+1111111111", "+222222222",
            "+33333333", "+44444444", "mail@mail.com", "mail1@mail.com", "mail3@mail.com",
            "URL", "Minsk", "+5555555555", "Notes", null),false);
    app.getNavigationHelper().updateAddressBook();
<<<<<<< HEAD
    app.getNavigationHelper().gotoHomePage();
    int after = app.getGroupHelper().getAddressCount();
<<<<<<< HEAD
<<<<<<< HEAD
    Assert.assertEquals(after, before);
=======

>>>>>>> parent of 86bc4e3... созданы тесты для сравнения количества групп и контактов до и после создания/удаления/модиффикации
=======
    Assert.assertEquals(after, before); // ошибка выдается если мы
>>>>>>> parent of 88ea6fe... Добавлены методы выбора контакта из списка для удаления
=======
    Assert.assertEquals(after, before); // ошибка выдается если мы
>>>>>>> parent of 88ea6fe... Добавлены методы выбора контакта из списка для удаления
  }
}

