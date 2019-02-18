package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getGroupContactHelper().gotoGroupPage();
    if (! app.getGroupContactHelper().isThereAGroup()){
      app.getGroupContactHelper().createGroup(new GroupData("Test1", null, "Test3"));
    }
    app.getGroupContactHelper().gotoGroupPage();
    int before = app.getGroupContactHelper().getGroupCount();
    app.getGroupContactHelper().selectGroup(0);// выбор первой группы из списка
    app.getGroupContactHelper().deleteSelectedGrpoup();
    app.getGroupContactHelper().returnToGroupPage();
    int after  = app.getGroupContactHelper().getGroupCount();
    Assert.assertEquals(after, before -1);
  }
}