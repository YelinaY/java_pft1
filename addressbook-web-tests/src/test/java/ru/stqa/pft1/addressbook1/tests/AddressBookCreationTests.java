package ru.stqa.pft1.addressbook1.tests;

import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;
import ru.stqa.pft1.addressbook1.model.Contacts;
import java.io.File;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressBookCreationTests extends TestBase {
/*
  @Test
  public void testNewAddressBookCreation() {
    app.groupsContacts().gotoHomePage();
    Contacts before = app.groupsContacts().allc();
    ContactData contact = new ContactData().withUserfirstname("Eлена").withUserlastname("Yelina");
    app.groupsContacts().createContact(contact);
    app.groupsContacts().gotoHomePage();
    assertThat(app.groupsContacts().contactCount(), equalTo(before.size() + 1));
    Contacts after = app.groupsContacts().allc();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
   before.withAddedc(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
*/

  @Test
  public void testNewAddressBookCreations() {
    app.groupsContacts().gotoHomePage();
    app.groupsContacts().initAddressBookCreation();
    File photo = new File("src/test/resources/png.png");
    app.groupsContacts().fillAddressBookForm(new ContactData().
            withUserfirstname("Eлена").withUserlastname("Yelina").withPhoto(photo));
    app.groupsContacts().submitNewAddressBook();
    app.groupsContacts().gotoHomePage();
  }

/*
  @Test
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/png.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
*/
}
