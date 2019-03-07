package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;
import java.util.Comparator;
import java.util.List;

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
    List<ContactData> before = app.groupsContacts().contactList();
    int index = before.size() - 1;
    ContactData contact = new ContactData().withId(before.get(index).getId()). withUserfirstname("Eлена").withUserlastname("Yelina").
            withUsermiddlename("Yel").withUsernickname("Lina").withtUsercompany("TCWD").
            withUseraddress("Paris, Royal sq.").withUserhomephone("+1111111111").withUserfax("+222222222").
            withUsermobilephone("+33333333").withUserphone2("+44444444").withUseremail("mail@mail.com").
            withUseremail2("mail1@mail.com").withUseremail3("mail3@mail.com").withUserhomepage("URL").
            withUseraddress("Minsk").withUserworkphone("+5555555555").withUsernotes("Notes");

    app.groupsContacts().modifyContact(index, contact);
    List<ContactData> after = app.groupsContacts().contactList();
    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after); //сравниваем списки

  }


}

