package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.GroupData;
import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {
@BeforeMethod
public void ensurePreconditions(){
  app.getGroupContactHelper().gotoGroupPage();
  if (!app.getGroupContactHelper().isThereAGroup()) {
    app.getGroupContactHelper().createGroup(new GroupData("Test1", null, null));
  }
}

  @Test
  public void testGroupModification() {
    List<GroupData> before = app.getGroupContactHelper().getGroupList();
    int index = before.size() - 1;
    GroupData group = new GroupData(before.get(index).getId(), "Test1", "Test2", "Test3");
    app.getGroupContactHelper().modifyGroup(index, group);
    List<GroupData> after = app.getGroupContactHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after); //сравниваем списки
  }


}
