package ru.stqa.pft1.addressbook1.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.GroupData;
import ru.stqa.pft1.addressbook1.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {


  @DataProvider
  public Iterator <Object[]> validGroups () throws IOException {
   BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
   String xml = "";
   String line = reader.readLine();
   while (line != null){
     xml+= line;
     line = reader.readLine();
   }
    XStream xStream = new XStream();
   xStream.processAnnotations(GroupData.class);
    List<GroupData> groups = (List<GroupData>)xStream.fromXML(xml);
    return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
      }

  @Test (dataProvider = "validGroups")
  public void testGroupCreaton(GroupData group) {
      app.groupsContacts().groupPage();
      Groups before = app.groupsContacts().all();
      app.groupsContacts().createGroup(group);
      assertThat(app.groupsContacts().groupCount(), equalTo(before.size() + 1));
      Groups after = app.groupsContacts().all();
      assertThat(after.size(), equalTo(before.size() + 1));

      assertThat(after, equalTo(
              before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

/*
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
*/
}

