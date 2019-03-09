package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.GroupData;

import java.util.List;
import java.util.Set;

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
    Set<GroupData> before = app.groupsContacts().all();
    GroupData deletedGroup = before.iterator().next();
   app.groupsContacts().deleteGroup(deletedGroup);
   Set<GroupData> after = app.groupsContacts().all();
    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(deletedGroup);
    Assert.assertEquals(before, after); //сравниваем списки
      }


}
