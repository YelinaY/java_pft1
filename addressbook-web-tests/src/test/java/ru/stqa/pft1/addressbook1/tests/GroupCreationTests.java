package ru.stqa.pft1.addressbook1.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreaton() {
    // сравнить количество групп до добавления и после
    app.getGroupContactHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupContactHelper().getGroupList();// создавать метод для создания списка (коллекцию)
    //а затем брать данные из этой коллекции. Переменная before будет содержать список (коллекцию) элементов - объектов типа GroupData
   // int before = app.getGroupContactHelper().getGroupCount();
    GroupData group = new GroupData("Test1", "Test2", "Test3");
    app.getGroupContactHelper().createGroup(group);
    List<GroupData> after = app.getGroupContactHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() +1);

    before.add(group);
    int max = 0;
    for (GroupData g : after){
      if (g.getId() > max){
        max = g.getId();
      }
    }
    group.setId (max);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after)); //сравниваем списки

    //int after  = app.getGroupContactHelper().getGroupCount();
    //Assert.assertEquals(after, before +1); //сравнение количества групп до и после создания
    //after.remove(after.size()-1); //удаляем лишний элемент перед сравнением списков
    //Assert.assertEquals(before,after); //сравниваем списки

  }
}
