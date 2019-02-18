package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.GroupData;

public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification() {
    app.getGroupContactHelper().gotoGroupPage();
    if (! app.getGroupContactHelper().isThereAGroup()){
      app.getGroupContactHelper().createGroup(new GroupData("Test1", null, "Test3"));
    }
    app.getGroupContactHelper().gotoGroupPage();
    int before = app.getGroupContactHelper().getGroupCount();
    app.getGroupContactHelper().selectGroup();
    app.getGroupContactHelper().initGroupModification();
    app.getGroupContactHelper().fillGroupForm(new GroupData("Test1", "Test2", "Test3"));
    app.getGroupContactHelper().submitGroupModification();
    app.getGroupContactHelper().returnToGroupPage();
    int after  = app.getGroupContactHelper().getGroupCount();
    Assert.assertEquals(after, before);

  }
}
