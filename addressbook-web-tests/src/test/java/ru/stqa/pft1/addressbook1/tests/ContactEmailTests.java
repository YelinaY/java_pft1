package ru.stqa.pft1.addressbook1.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;

public class ContactEmailTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
      app.groupsContacts().gotoHomePage();
      if (!app.groupsContacts().isThereAddressBook()) {
        app.groupsContacts().createContact(new ContactData().withUserfirstname("Yelena").withUserlastname("Yelin"));
      }
    }

    @Test //(enabled = false)
    public void testContacttEmail() {
      app.groupsContacts().gotoHomePage();
      ContactData contact = app.groupsContacts().allc().iterator().next();
      ContactData contactInfoFromEmail = app.groupsContacts().infoFromEmail(contact);
    }
  }

