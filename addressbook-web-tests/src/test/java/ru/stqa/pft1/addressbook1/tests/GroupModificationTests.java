package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.GroupData;

import java.util.List;

public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification() {
    app.getGroupContactHelper().gotoGroupPage();
    if (! app.getGroupContactHelper().isThereAGroup()){
      app.getGroupContactHelper().createGroup(new GroupData("Test1", null, "Test3"));
    }
    app.getGroupContactHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupContactHelper().getGroupList();
       // int before = app.getGroupContactHelper().getGroupCount();
    app.getGroupContactHelper().selectGroup(before.size() -1); //выбрать последнюю группу
    app.getGroupContactHelper().initGroupModification();
    app.getGroupContactHelper().fillGroupForm(new GroupData("Test1", "Test2", "Test3"));
    app.getGroupContactHelper().submitGroupModification();
    app.getGroupContactHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupContactHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() );
   // int after  = app.getGroupContactHelper().getGroupCount();
   // Assert.assertEquals(after, before); // сравнение количества групп до и после модификации
    Assert.assertEquals(before,after); //сравниваем списки


  }
}
