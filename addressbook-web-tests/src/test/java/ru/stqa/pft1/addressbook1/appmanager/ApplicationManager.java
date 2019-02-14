package ru.stqa.pft1.addressbook1.appmanager;
<<<<<<< HEAD
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
=======

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

>>>>>>> parent of d29ea2c... Запуск тестов в разных браузерах
import java.util.concurrent.TimeUnit;
public class ApplicationManager {
  FirefoxDriver wd;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
<<<<<<< HEAD
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }
=======


>>>>>>> parent of d29ea2c... Запуск тестов в разных браузерах
  public void init() {
<<<<<<< HEAD
    wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
=======
     if (browser == BrowserType.FIREFOX){
      wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    }else if (browser == BrowserType.CHROME){
      wd = new ChromeDriver();
    } else if (browser == BrowserType.IE){
      wd = new InternetExplorerDriver();
    }
   // wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
>>>>>>> parent of 2f86ad6... Добавлен класс Equality для сравнения объектов
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }
  public void stop() {
    wd.quit();
  }
  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
