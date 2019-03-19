package ru.stqa.pft1.addressbook1.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;
import ru.stqa.pft1.addressbook1.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddressBookModification extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.groupsContacts().gotoHomePage();
      app.groupsContacts().createContact(new ContactData().withUserfirstname("Yelena").withUserlastname("Yelin"));
    }
  }
  @Test
  public void testAddressBookModification() {
    app.groupsContacts().gotoHomePage();
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().
            withId(modifiedContact.getId()).withUserfirstname("Eлена").withUserlastname("Yelina").
            withUsermiddlename("Yel").withUsernickname("Lina").withtUsercompany("TCWD").
            withUseraddress("Paris, Royal sq.").withUserhomephone("+1111111111").
            withUsermobilephone("+33333333").withUseremail("mail@mail.com").
            withUseremail2("mail1@mail.com").withUseremail3("mail3@mail.com").withUserhomepage("URL").
            withUseraddress("Minsk").withUserworkphone("+5555555555").withUsernotes("Notes");

    app.groupsContacts().modifyContact(contact);
    assertThat(app.groupsContacts().contactCount(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withOutc(modifiedContact).withAddedc(contact)));

  }
}
/*

  @Test
  public void testContactEdit() throws Exception {
    app.goTo().homePage();
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("test1").withLastname("test2").withAddress("test3").withHomePhone("test4").withMobilePhone("test5").withEmail1("test6");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInUi();
  }

}

 */
