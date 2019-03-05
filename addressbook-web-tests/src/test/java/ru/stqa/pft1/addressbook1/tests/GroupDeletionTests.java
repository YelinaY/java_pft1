package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.getGroupContactHelper().gotoGroupPage();
    if (!app.getGroupContactHelper().isThereAGroup()) {
      app.getGroupContactHelper().createGroup(new GroupData("Test1", null, null));
    }
  }


  @Test
  public void testGroupDeletion() {
    List<GroupData> before = app.getGroupContactHelper().getGroupList();
    int index = before.size() - 1;
    app.getGroupContactHelper().selectGroup(index);
    app.getGroupContactHelper().deleteSelectedGrpoup();
    app.getGroupContactHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupContactHelper().getGroupList();
    Assert.assertEquals(after.size(), index); // старый список содержит на 1 объект меньше

    before.remove(index);//удаляем лишний элемент перед сравнением списков
    Assert.assertEquals(before, after); //сравниваем списки
      }
}
