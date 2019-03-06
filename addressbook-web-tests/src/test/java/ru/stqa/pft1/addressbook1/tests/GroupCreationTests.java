package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreaton() {
    app.contacstGroups().groupPage();
    List<GroupData> before = app.contacstGroups().groupList();
    GroupData group = new GroupData("Test2", null, null);
    app.contacstGroups().createGroup(group);
    List<GroupData> after = app.contacstGroups().groupList();
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after); //сравниваем списки
  }
}

