package ru.stqa.pft1.addressbook1.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.GroupData;
import ru.stqa.pft1.addressbook1.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
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
   Groups after = app.groupsContacts().all();
    assertEquals(after.size(), before.size()-1);

    assertThat(after, equalTo(before.withOut(deletedGroup)));
      }


}
