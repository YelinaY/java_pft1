package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;
import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class AddressBookModification extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.groupsContacts().gotoHomePage();
    if (!app.groupsContacts().isThereAddressBook()) {
      app.groupsContacts().createContact(new ContactData().withUserfirstname("Eлена").withUserlastname("Yelina").
              withUsermiddlename("Yel").withUsernickname("Lina").withtUsercompany("TCWD").
              withUseraddress("Paris, Royal sq.").withUserhomephone("+1111111111").withUserfax("+222222222").
              withUsermobilephone("+33333333").withUserphone2("+44444444").withUseremail("mail@mail.com").
              withUseremail2("mail1@mail.com").withUseremail3("mail3@mail.com").withUserhomepage("URL").
              withUseraddress("Minsk").withUserworkphone("+5555555555").withUsernotes("Notes"));
    }
  }

  @Test
  public void testAddressBookModification() {
    app.groupsContacts().gotoHomePage();
    Set<ContactData> before = app.groupsContacts().allc();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().
            withId(modifiedContact.getId()). withUserfirstname("Eлена").withUserlastname("Yelina").
            withUsermiddlename("Yel").withUsernickname("Lina").withtUsercompany("TCWD").
            withUseraddress("Paris, Royal sq.").withUserhomephone("+1111111111").withUserfax("+222222222").
            withUsermobilephone("+33333333").withUserphone2("+44444444").withUseremail("mail@mail.com").
            withUseremail2("mail1@mail.com").withUseremail3("mail3@mail.com").withUserhomepage("URL").
            withUseraddress("Minsk").withUserworkphone("+5555555555").withUsernotes("Notes");

    app.groupsContacts().modifyContact(contact);
    Set<ContactData> after = app.groupsContacts().allc();

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);

  }


}

