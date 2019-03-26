package ru.stqa.pft1.addressbook2.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook2.model.ContactData;
import ru.stqa.pft1.addressbook2.model.Contacts;
import ru.stqa.pft1.addressbook2.model.GroupData;
import ru.stqa.pft1.addressbook2.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
      return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
    }
  }

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
    }
  }

  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    app.goTo().homePage();
    Groups groups = app.db().groups();
    Contacts before = app.db().contacts();
    File photo = new File("src/test/resources/stesting.png");
    app.contact().create(contact.inGroup(groups.iterator().next()));
    Contacts after = app.db().contacts();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    verifyContactListInUi();
  }


  @Test(enabled = false)
  public void testBadContactCreation() throws Exception {
    app.goTo().homePage();
    Contacts before = app.db().contacts();
    ContactData contact = new ContactData()
               .withFirstname("Yelena").withLastname("Korsakova").withAddress("Minsk").
            withHomePhone("1111111111").withMobilePhone("22222222222").withWorkPhone("33333333333").withEmail1("email@email.com");

    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before));
  }
}