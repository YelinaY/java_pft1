package ru.stqa.pft1.addressbook1.tests;

import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.GroupData;
import ru.stqa.pft1.addressbook1.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreaton() {
    app.groupsContacts().groupPage();
    Groups before = app.groupsContacts().all();
    GroupData group = new GroupData().withName("test2");
    app.groupsContacts().createGroup(group);
    assertThat(app.groupsContacts().groupCount(), equalTo(before.size() + 1));
    Groups after = app.groupsContacts().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test // тест проверки что нельзя создать группу с именем содержащем '
  public void testBadGroupCreaton() {
    app.groupsContacts().groupPage();
    Groups before = app.groupsContacts().all();
    GroupData group = new GroupData().withName("test'");
    app.groupsContacts().createGroup(group);
    assertThat(app.groupsContacts().groupCount(), equalTo(before.size()));
    Groups after = app.groupsContacts().all();
    assertThat(after, equalTo(before));
  }
}

