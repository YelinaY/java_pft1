package ru.stqa.pft1.addressbook1.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.GroupData;
import ru.stqa.pft1.addressbook1.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {
@BeforeMethod
public void ensurePreconditions(){
  app.groupsContacts().groupPage();
  if (!app.groupsContacts().isThereAGroup()) {
    app.groupsContacts().createGroup(new GroupData().withName("test2"));
  }
}

  @Test
  public void testGroupModification() {
    Groups before = app.groupsContacts().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().
            withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.groupsContacts().modifyGroupBuId(group);
   Groups after = app.groupsContacts().all();
    assertEquals(after.size(), before.size());

    assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
  }


}
