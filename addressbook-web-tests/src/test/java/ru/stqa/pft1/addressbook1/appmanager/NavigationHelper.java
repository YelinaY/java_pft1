package ru.stqa.pft1.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft1.addressbook1.model.ContactData;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }
/* если на странице присутствуют 3 элемента: tag h1 с текстом Groups и элемент с именем "new". Если выполняются эти 3 условия
  то продолжается действие*/

public void gotoGroupPage() {
  if (!isElementPresent(By.tagName("h1"))){
    return;
  }
  click(By.linkText("groups"));
  }

  public void initAddressBookCreation() {
    if (!isElementPresent(By.tagName("h1"))){
      return;
    }
    click(By.linkText("add new"));
  }

  /*public void fillAddressBookForm(ContactData contactData) {

       }
 */
  public void submitNewAddressBook() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }
  /* если на странице присутствуют элемент(By.id("maintable" то продолжается действие*/
  public void gotoHomePage() {
    if (isElementPresent(By.id("maintable"))){
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
