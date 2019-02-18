package ru.stqa.pft1.addressbook1.tests;

import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.GroupData;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreaton() {
    // сравнить количество групп до добавления и после
    app.getGroupContactHelper().gotoGroupPage();
    app.getGroupContactHelper().createGroup(new GroupData("Test1", "Test2", "Test3"));

  }

}
