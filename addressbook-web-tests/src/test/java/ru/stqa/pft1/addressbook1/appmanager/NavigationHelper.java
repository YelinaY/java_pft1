package ru.stqa.pft1.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
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

  public void editAddrassBook() {
    click(By.cssSelector("img[alt=\"Edit\"]"));
  }

  public void updateAddressBook() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }
}
