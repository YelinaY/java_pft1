package ru.stqa.pft1.addressbook1.tests;

import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getGroupHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("Test1", null, "Test3"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGrpoup();
    app.getGroupHelper().returnToGroupPage();
  }
}