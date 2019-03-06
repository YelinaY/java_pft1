package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.contacstGroups().groupPage();
    if (!app.contacstGroups().isThereAGroup()) {
      app.contacstGroups().createGroup(new GroupData("Test1", null, null));
    }
  }


  @Test
  public void testGroupDeletion() {
    List<GroupData> before = app.contacstGroups().groupList();
    int index = before.size() - 1;
    app.contacstGroups().deleteGroup(index);
    List<GroupData> after = app.contacstGroups().groupList();
    Assert.assertEquals(after.size(), index); // старый список содержит на 1 объект меньше

    before.remove(index);//удаляем лишний элемент перед сравнением списков
    Assert.assertEquals(before, after); //сравниваем списки
      }


}
