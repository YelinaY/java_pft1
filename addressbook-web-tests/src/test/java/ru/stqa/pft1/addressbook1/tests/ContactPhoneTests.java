package ru.stqa.pft1.addressbook1.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactPhoneTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.groupsContacts().gotoHomePage();
    if (!app.groupsContacts().isThereAddressBook()) {
      app.groupsContacts().createContact(new ContactData().withUserfirstname("Yelena").withUserlastname("Yelin"));
    }
  }

  @Test //(enabled = false)
  public void testContactPhones() {
    app.groupsContacts().gotoHomePage();
    ContactData contact = app.groupsContacts().allc().iterator().next();
    ContactData contactInfoFromEditForm = app.groupsContacts().infoFromEditForm(contact);
    assertThat(contact.getUserhomephone(), equalTo(cleaned(contactInfoFromEditForm.getUserhomephone())));
    assertThat(contact.getUsermobilephone(), equalTo(cleaned(contactInfoFromEditForm.getUsermobilephone())));
    assertThat(contact.getUserworkphone(), equalTo(cleaned(contactInfoFromEditForm.getUserworkphone())));
      }
      public String cleaned (String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");// функция удаляет ненужные символы при сравнении
  //    "\\s"  заменить пробел на пустую строку (удалить при проверке)
  }
}