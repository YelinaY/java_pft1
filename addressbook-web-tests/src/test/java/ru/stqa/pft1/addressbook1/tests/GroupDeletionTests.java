package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getGroupContactHelper().gotoGroupPage();
    if (! app.getGroupContactHelper().isThereAGroup()){
      app.getGroupContactHelper().createGroup(new GroupData("Test1", null, "Test3"));
    }
    app.getGroupContactHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupContactHelper().getGroupList();
    //int before = app.getGroupContactHelper().getGroupCount();
    app.getGroupContactHelper().selectGroup(before.size() - 1);
    app.getGroupContactHelper().deleteSelectedGrpoup();
    app.getGroupContactHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupContactHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() -1);
    //int after  = app.getGroupContactHelper().getGroupCount();
    //Assert.assertEquals(after, before -1); // сравнение количества групп до и после удаления

    //before.remove(before.size()-1); //  удаляю лишний элемент
    //Assert.assertEquals(before, after);
    }
  }
