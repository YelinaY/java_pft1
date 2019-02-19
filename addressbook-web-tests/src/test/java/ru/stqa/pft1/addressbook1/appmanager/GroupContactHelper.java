package ru.stqa.pft1.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft1.addressbook1.model.ContactData;
import ru.stqa.pft1.addressbook1.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupContactHelper extends HelperBase {
  public GroupContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void fillAddressBookForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getUserfirstname());
    type(By.name("middlename"), contactData.getUsermiddlename());
    type(By.name("lastname"), contactData.getUserlastname());
    type(By.name("nickname"), contactData.getUsernickname());
    type(By.name("company"), contactData.getUsercompany());
    type(By.name("address"), contactData.getUseraddress());
    type(By.name("home"), contactData.getUserhomephone());
    type(By.name("mobile"), contactData.getUsermobilephone());
    type(By.name("work"), contactData.getUserworkphone());
    type(By.name("fax"), contactData.getUserfax());
    type(By.name("email"), contactData.getUseremail());
    type(By.name("email2"), contactData.getUseremail2());
    type(By.name("email3"), contactData.getUseremail3());
    type(By.name("homepage"), contactData.getUserhomepage());
    type(By.name("address2"), contactData.getUseraddress2());
    type(By.name("phone2"), contactData.getUserphone2());
    type(By.name("notes"), contactData.getUsernotes());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initGroupCreation() {
    click(By.cssSelector("input[name=\"new\"]"));
  }

  public void deleteSelectedGrpoup() {
    click(By.name("delete"));
  }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void selectAddressBook(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedAddressBook() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void confirmDeletion() {
    wd.switchTo().alert().accept();
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public boolean isThereAddressBook() {
    return isElementPresent(By.name("selected[]"));
  }

  public void gotoGroupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void initAddressBookCreation() {
    click(By.linkText("add new"));
  }

  public void submitNewAddressBook() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void gotoHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void editAddressBook() {
    click(By.cssSelector("img[alt=\"Edit\"]"));
  }

  public void updateAddressBook() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }


  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }


  public void createContact(ContactData contactData, boolean b) {
    gotoHomePage();
    initAddressBookCreation();
    fillAddressBookForm(new ContactData("Eлена", "Yel", "Yelina", "Lina", "TCWD",
            "Paris, Royal sq.", "+1111111111", "+222222222", "+33333333",
            "+44444444", "mail@mail.com", "mail1@mail.com", "mail3@mail.com", "URL",
            "Minsk", "+5555555555", "Notes", "Test1"), true);
    submitNewAddressBook();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> getGroupList() {  // метод создает коллекцию элементов
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      GroupData group = new GroupData(name, null, null);
      groups.add(group);
    }
    return groups;
  }
 }


