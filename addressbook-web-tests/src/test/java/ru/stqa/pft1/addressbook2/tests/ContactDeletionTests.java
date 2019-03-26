package ru.stqa.pft1.addressbook2.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook2.model.ContactData;
import ru.stqa.pft1.addressbook2.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

  public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
      if (app.db().contacts().size() == 0) {
        app.goTo().homePage();
        app.contact().create(new ContactData()
                .withFirstname("Yelena").withLastname("Korsakova").withAddress("Minsk").
                        withHomePhone("1111111111").withMobilePhone("22222222222").withWorkPhone("33333333333").withEmail1("email@email.com"));
      }
    }

    @Test
    public void testContactDeletionFromHomePage() throws Exception {
      app.goTo().homePage();
      Contacts before = app.db().contacts();
      ContactData deletedContact = before.iterator().next();
      app.contact().delete(deletedContact);
      assertThat(app.contact().count(), equalTo(before.size() - 1));
      Contacts after = app.db().contacts();
      assertThat(after, equalTo(before.without(deletedContact)));
      verifyContactListInUi();
    }

    @Test
    public void testContactDeletionFromEditPage() throws Exception {
      app.goTo().homePage();
      Contacts before = app.db().contacts();
      ContactData deletedContact = before.iterator().next();
      app.contact().deleteViaEdit(deletedContact);
      assertThat(app.contact().count(), equalTo(before.size() - 1));
      Contacts after = app.db().contacts();
      assertThat(after, equalTo(before.without(deletedContact)));
      verifyContactListInUi();
    }

  }

