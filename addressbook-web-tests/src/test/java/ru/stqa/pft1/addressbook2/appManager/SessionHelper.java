package ru.stqa.pft1.addressbook2.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

  public SessionHelper(WebDriver wd) {

    super(wd);
  }

  public void login(String username, String password) {
    type(By.name("user"), username);
    type(By.name("pass"), password);
    click(By.xpath("//input[@value='Login']"));

  }
  public void logout() {
    click(By.linkText("Logout"));
  }

}
