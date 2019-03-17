package ru.stqa.pft1.addressbook1.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;
import ru.stqa.pft1.addressbook1.model.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
    return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

  }

  @Test(dataProvider = "validContacts")
  public void testNewAddressBookCreations(ContactData contact) {
    app.groupsContacts().gotoHomePage();
    app.groupsContacts().initAddressBookCreation();
    File photo = new File("src/test/resources/png.png");
    app.groupsContacts().fillAddressBookForm(new ContactData().
            withUserfirstname("Eлена").withUserlastname("Yelina").withPhoto(photo));
    app.groupsContacts().submitNewAddressBook();
    app.groupsContacts().gotoHomePage();
  }
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

