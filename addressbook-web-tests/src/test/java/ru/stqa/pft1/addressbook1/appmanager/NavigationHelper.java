package ru.stqa.pft1.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft1.addressbook1.model.ContactData;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void initAddressBookCreation() {
    click(By.linkText("add new"));
  }

 /*public void fillAddressBookForm(ContactData contactData) {

      }
*/
  public void submitNewAddressBook() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }
  }
