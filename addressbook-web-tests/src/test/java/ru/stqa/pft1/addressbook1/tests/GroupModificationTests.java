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
  app.groupsContacts().groupPage();
  if (!app.groupsContacts().isThereAGroup()) {
    app.groupsContacts().createGroup(new GroupData().withName("test2"));
  }
}

  @Test
  public void testGroupModification() {
    List<GroupData> before = app.groupsContacts().groupList();
    int index = before.size() - 1;
    GroupData group = new GroupData().withId(before.get(index).getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.groupsContacts().modifyGroup(index, group);
    List<GroupData> after = app.groupsContacts().groupList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after); //сравниваем списки
  }


}
