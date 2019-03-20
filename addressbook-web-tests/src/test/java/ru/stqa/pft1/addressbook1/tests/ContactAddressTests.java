package ru.stqa.pft1.addressbook1.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

  @Test //(enabled = false)
  public void testContacttAddress() {
    app.groupsContacts().gotoHomePage();
    ContactData contact = app.groupsContacts().allc().iterator().next();
    ContactData contactInfoFromAddress = app.groupsContacts().infoFromAddressForm(contact);
    assertThat(contact.getAddress(), equalTo(cleaned(contactInfoFromAddress.getAddress())));

  }
  public String cleaned(String address) {
    return address.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}


