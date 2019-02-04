package ru.stqa.pft1.addressbook1.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.gotoGroupPage();
    app.selectGroup();
    app.deleteSelectedGrpoup();
    app.returnToGroupPage();
    }

}