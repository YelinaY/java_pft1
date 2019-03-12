package ru.stqa.pft1.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft1.addressbook1.model.ContactData;
import ru.stqa.pft1.addressbook1.model.Contacts;
import ru.stqa.pft1.addressbook1.model.GroupData;
import ru.stqa.pft1.addressbook1.model.Groups;

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

  public void fillAddressBookForm(ContactData contactData) {
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
    wd.findElements(By.xpath(".//td/input")).get(index).click();
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
    groupCache = null;
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public boolean isThereAddressBook() {
    return isElementPresent(By.name("selected[]"));
  }

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void editAddressBook(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
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

  public void updateAddressBook() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public int groupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void createContact(ContactData contactData) {
    gotoHomePage();
    initAddressBookCreation();
    fillAddressBookForm(new ContactData().withUserfirstname("Eлена").withUserlastname("Yelina").
            withUsermiddlename("Yel").withUsernickname("Lina").withtUsercompany("TCWD").
            withUseraddress("Paris, Royal sq.").withUserhomephone("+1111111111").withUserfax("+222222222").
            withUsermobilephone("+33333333").withUserphone2("+44444444").withUseremail("mail@mail.com").
            withUseremail2("mail1@mail.com").withUseremail3("mail3@mail.com").withUserhomepage("URL").
            withUseraddress("Minsk").withUserworkphone("+5555555555").withUsernotes("Notes"));
    contactCache = null;
    submitNewAddressBook();
  }

  public int contactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> groupList() {  // метод создает коллекцию элементов
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groups.add(new GroupData().withId(id).withName(name));
    }
    return groups;
  }

  private Groups groupCache = null;

  public Groups all() {
    if (groupCache != null) {
      return new Groups(groupCache);
    }

    groupCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCache.add(new GroupData().withId(id).withName(name));
    }
    return new Groups(groupCache);
  }

  public List<ContactData> contactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String userfirstname = element.findElement(By.xpath(".//td[3]")).getText();
      String userlastname = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withUserfirstname(userfirstname).withUserlastname(userlastname));
    }
    return contacts;
  }

  private Contacts contactCache = null;

  public Contacts allc() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String userlastname = element.findElement(By.xpath(".//td[2]")).getText();
      String userfirstname = element.findElement(By.xpath(".//td[3]")).getText();
      String[] phones = element.findElement(By.xpath(".//td[6]")).getText().split("\n");
      String [] email = element.findElement(By.xpath(".//td[5]")).getText().split("\n");
      String address = element.findElement(By.xpath(".//td[4]")).getText();
      contactCache.add(new ContactData().withId(id).withUserfirstname(userfirstname).
              withUserlastname(userlastname).withUserhomephone(phones[0]).
              withUsermobilephone(phones[1]).withUserworkphone(phones[2]).withUseremail(email[0]).
              withUseremail2(email[1]).withUseremail3(email[2]).withUseraddress(address));
    }
    return new Contacts(contactCache);
  }


  public void modifyGroupBuId(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    groupCache = null;
    returnToGroupPage();
  }

  public void modifyContact(ContactData contact) {
    editAddressBookById(contact.getId());
    fillAddressBookForm(contact);
    contactCache = null;
    updateAddressBook();
  }

  private void editAddressBookById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
  }


  public void deleteContact(int index) {
    selectAddressBook(index);
    deleteSelectedAddressBook();
    confirmDeletion();
  }

  public void deleteContact(ContactData contact) {
    selectAddressBookById(contact.getId());
    deleteSelectedAddressBook();
    contactCache = null;
    confirmDeletion();
  }

  public void selectAddressBookById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void deleteGroup(int index) {
    selectGroup(index);
    deleteSelectedGrpoup();
    returnToGroupPage();
  }

  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void deleteGroup(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGrpoup();
    groupCache = null;
    returnToGroupPage();
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().
            withId(contact.getId()).withUserfirstname(firstname).withUserlastname(lastname).
            withUserhomephone(home).withUsermobilephone(mobile).withUserworkphone(work);
  }

  public ContactData infoFromAddressForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().
            withId(contact.getId()).withUseraddress(address);
  }

  public ContactData infoFromEmail(ContactData contact) {
    initContactModificationById(contact.getId());
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().
            withId(contact.getId()).withUseremail(email).withUseremail2(email2).withUseremail3(email3);
  }
  }



