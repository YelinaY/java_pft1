package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreaton() {
    app.groupsContacts().groupPage();
    Set<GroupData> before = app.groupsContacts().all();
    GroupData group = new GroupData().withName("test2");
    app.groupsContacts().createGroup(group);
    Set<GroupData> after = app.groupsContacts().all();
    Assert.assertEquals(after.size(), before.size() + 1);
    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()); //функция которая преобразует индификатор в число
    before.add(group);

    Assert.assertEquals(before, after); //сравниваем списки
  }
}

