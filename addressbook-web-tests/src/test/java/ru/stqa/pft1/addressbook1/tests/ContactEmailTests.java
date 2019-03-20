package ru.stqa.pft1.addressbook1.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

  @Test //(enabled = false)
  public void testContacttEmail() {
    app.groupsContacts().gotoHomePage();
    ContactData contact = app.groupsContacts().allc().iterator().next();
    ContactData contactInfoFromEmail = app.groupsContacts().infoFromEmail(contact);
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEmail)));

  }
  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3()).
            stream().filter((s) -> !s.equals("")).map(ContactEmailTests::cleaned).
            collect(Collectors.joining("\n"));
  }

  public static String cleaned(String email) {
    return email.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}

