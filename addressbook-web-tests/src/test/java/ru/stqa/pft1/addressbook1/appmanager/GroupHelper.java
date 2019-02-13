package ru.stqa.pft1.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft1.addressbook1.model.ContactData;
import ru.stqa.pft1.addressbook1.model.GroupData;

import java.util.NoSuchElementException;

public class GroupHelper extends HelperBase {
  public GroupHelper(WebDriver wd) {
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
    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    }else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
   // new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
     }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGrpoup() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void selectAddressBook() {
    click(By.name("selected[]"));
  }

  public void deleteSelectedAddressBook() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void confirmDeletion() {
    wd.switchTo().alert().accept();
  }
}
