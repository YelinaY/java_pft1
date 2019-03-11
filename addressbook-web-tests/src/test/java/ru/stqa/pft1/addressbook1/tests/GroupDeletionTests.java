package ru.stqa.pft1.addressbook1.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.GroupData;
import ru.stqa.pft1.addressbook1.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.groupsContacts().groupPage();
    if (!app.groupsContacts().isThereAGroup()) {
      app.groupsContacts().createGroup(new GroupData().withName("test2"));
    }
  }


  @Test
  public void testGroupDeletion() {
    Groups before = app.groupsContacts().all();
    GroupData deletedGroup = before.iterator().next();
    app.groupsContacts().deleteGroup(deletedGroup);
    assertThat(app.groupsContacts().groupCount(), equalTo(before.size() - 1));
    Groups after = app.groupsContacts().all();
    assertThat(after, equalTo(before.withOut(deletedGroup)));
  }


}
