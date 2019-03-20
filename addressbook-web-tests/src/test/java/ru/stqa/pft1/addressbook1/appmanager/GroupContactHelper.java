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
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getEmail1());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());

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
    fillAddressBookForm(new ContactData().withFirstname("Eлена").withLastname("Yelina").
            withAddress("Paris, Royal sq.").withHomePhone("+1111111111").
            withMobilePhone("+33333333").withEmail1("mail@mail.com").
            withEmail2("mail1@mail.com").withEmail3("mail3@mail.com").withAddress("Minsk").
            withWorkPhone("+5555555555"));
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
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
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
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
      String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
      String address = element.findElement(By.xpath(".//td[4]")).getText();
      contactCache.add(new ContactData().withId(id).withFirstname(firstname).
              withLastname(lastname).withAllPhones(allPhones)
              .withAllEmails(allEmails).withAddress(address));
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
  /*
  public void modify(ContactData contact) {
    initContactEditById(contact.getId());
    fillContactForm(contact, false);
    submitContactEdit();
    waitForSuccessMessage();
    contactCache = null;
    returnToHomePage();
  }
*/



  private void editAddressBookById(int id) {
    click(By.cssSelector("a[href='edit.php?id=" + id + "']"));
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
            withId(contact.getId()).withFirstname(firstname).withLastname(lastname).
            withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
  }

  public ContactData infoFromAddressForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().
            withId(contact.getId()).withAddress(address);
  }

  public ContactData infoFromEmail(ContactData contact) {
    initContactModificationById(contact.getId());
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().
            withId(contact.getId()).withEmail1(email).withEmail2(email2).withEmail3(email3);
  }
}



