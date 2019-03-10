package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.GroupData;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupModificationTests extends TestBase {
@BeforeMethod
public void ensurePreconditions(){
  app.groupsContacts().groupPage();
  if (!app.groupsContacts().isThereAGroup()) {
    app.groupsContacts().createGroup(new GroupData().withName("test2"));
  }
}

  @Test
  public void testGroupModification() {
    Set<GroupData> before = app.groupsContacts().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().
            withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.groupsContacts().modifyGroupBuId(group);
    Set<GroupData> after = app.groupsContacts().all();
    Assert.assertEquals(after.size(), before.size());
    before.remove(modifiedGroup);
    before.add(group);
    Assert.assertEquals(before, after);
  }


}
