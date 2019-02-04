package ru.stqa.pft1.addressbook1.tests;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
<<<<<<< HEAD:addressbook-web-tests/src/test/java/ru/stqa/pft1/addressbook1/tests/NewAddressBookCreationTests.java
import ru.stqa.pft1.addressbook1.model.GroupDatan;
<<<<<<< HEAD
=======
=======
>>>>>>> parent of 526e766... Задание №5: Реализовать двухуровневую архитектуру тестового набора
import org.openqa.selenium.support.ui.Select;
>>>>>>> parent of 7cb18ea... Задание №4: Сделать тесты для создания групп и контактов в адресной книге+ рефакторинг:addressbook-web-tests/src/test/java/ru/stqa/pft1/addressbook1/NewAddressBookCreationTests.java


public class NewAddressBookCreationTests {
  FirefoxDriver wd;

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  @Test
<<<<<<< HEAD
  public void testNewAddressBook(){
=======
  public void testNewAddressBook() throws Exception {
<<<<<<< HEAD:addressbook-web-tests/src/test/java/ru/stqa/pft1/addressbook1/tests/NewAddressBookCreationTests.java
    openAddressBook();
    addNewAddressBook();
    userFirstName("Eлена");
    new FillForm().invoke(new GroupDatan("Y/Y", "Yelina", "Lina", "TCWD", "Paris, Royal sq.", "+1111111111", "+222222222", "+33333333", "+44444444", "mail@mail.com", "mail1@mail.com", "mail3@mail.com", "URL", "Minsk", "+5555555555", "Notes"));
    submitNewAddressBook();

  }

  private void userFirstName(String userfirstname) {
=======
>>>>>>> parent of 526e766... Задание №5: Реализовать двухуровневую архитектуру тестового набора
    wd.get("http://localhost/addressbook/group.php");
    wd.findElement(By.linkText("add new")).click();
>>>>>>> parent of 7cb18ea... Задание №4: Сделать тесты для создания групп и контактов в адресной книге+ рефакторинг:addressbook-web-tests/src/test/java/ru/stqa/pft1/addressbook1/NewAddressBookCreationTests.java
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys("Eлена");
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys("Y/Y");
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys("Yelena");
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys("Yelina");
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys("Lina");
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys("TCWD");
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys("Paris, Royal sq.");
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys("+1111111111");
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys("+222222222");
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys("+33333333");
    wd.findElement(By.name("fax")).click();
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys("+44444444");
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys("mail@mail.com");
    wd.findElement(By.name("email2")).click();
    wd.findElement(By.name("email2")).clear();
    wd.findElement(By.name("email2")).sendKeys("mail1@mail.com");
    wd.findElement(By.name("email3")).click();
    wd.findElement(By.name("email2")).click();
    wd.findElement(By.name("email2")).clear();
    wd.findElement(By.name("email2")).sendKeys("mail2@mail.com");
    wd.findElement(By.name("email3")).click();
    wd.findElement(By.name("email3")).clear();
    wd.findElement(By.name("email3")).sendKeys("mail3@mail.com");
    wd.findElement(By.name("homepage")).click();
    wd.findElement(By.name("homepage")).clear();
    wd.findElement(By.name("homepage")).sendKeys("URL");
    wd.findElement(By.name("address2")).click();
    wd.findElement(By.name("address2")).clear();
    wd.findElement(By.name("address2")).sendKeys("Minsk");
    wd.findElement(By.name("phone2")).click();
    wd.findElement(By.name("phone2")).clear();
    wd.findElement(By.name("phone2")).sendKeys("+5555555555");
    wd.findElement(By.name("notes")).click();
    wd.findElement(By.name("notes")).clear();
    wd.findElement(By.name("notes")).sendKeys("Notes");
    wd.findElement(By.xpath("//body")).click();
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();

  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }
<<<<<<< HEAD
=======
<<<<<<< HEAD:addressbook-web-tests/src/test/java/ru/stqa/pft1/addressbook1/tests/NewAddressBookCreationTests.java

  private class FillForm {
    public void invoke(GroupDatan groupDatan) {
      wd.findElement(By.name("middlename")).click();
      wd.findElement(By.name("middlename")).clear();
      wd.findElement(By.name("middlename")).sendKeys(groupDatan.getUsermiddlename());
      wd.findElement(By.name("lastname")).click();
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(groupDatan.getUserlastname());
      wd.findElement(By.name("nickname")).click();
      wd.findElement(By.name("nickname")).clear();
      wd.findElement(By.name("nickname")).sendKeys(groupDatan.getUsernickname());
      wd.findElement(By.name("company")).click();
      wd.findElement(By.name("company")).clear();
      wd.findElement(By.name("company")).sendKeys(groupDatan.getUserCompany());
      wd.findElement(By.name("address")).click();
      wd.findElement(By.name("address")).clear();
      wd.findElement(By.name("address")).sendKeys(groupDatan.getUserAddress());
      wd.findElement(By.name("home")).click();
      wd.findElement(By.name("home")).clear();
      wd.findElement(By.name("home")).sendKeys(groupDatan.getUserHome());
      wd.findElement(By.name("mobile")).click();
      wd.findElement(By.name("mobile")).clear();
      wd.findElement(By.name("mobile")).sendKeys(groupDatan.getUserMobile());
      wd.findElement(By.name("work")).click();
      wd.findElement(By.name("work")).clear();
      wd.findElement(By.name("work")).sendKeys(groupDatan.getUserWorkingPhone());
      wd.findElement(By.name("fax")).click();
      wd.findElement(By.name("fax")).clear();
      wd.findElement(By.name("fax")).sendKeys(groupDatan.getUserFax());
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(groupDatan.getUserMail());
      wd.findElement(By.name("email2")).click();
      wd.findElement(By.name("email2")).clear();
      wd.findElement(By.name("email2")).sendKeys(groupDatan.getUserMail2());
      wd.findElement(By.name("email3")).click();
      wd.findElement(By.name("email3")).clear();
      wd.findElement(By.name("email3")).sendKeys(groupDatan.getUserMail3());
      wd.findElement(By.name("homepage")).click();
      wd.findElement(By.name("homepage")).clear();
      wd.findElement(By.name("homepage")).sendKeys(groupDatan.getUserHomepage());
      wd.findElement(By.name("address2")).click();
      wd.findElement(By.name("address2")).clear();
      wd.findElement(By.name("address2")).sendKeys(groupDatan.getUserAddress2());
      wd.findElement(By.name("phone2")).click();
      wd.findElement(By.name("phone2")).clear();
      wd.findElement(By.name("phone2")).sendKeys(groupDatan.getUserPhone2());
      wd.findElement(By.name("notes")).click();
      wd.findElement(By.name("notes")).clear();
      wd.findElement(By.name("notes")).sendKeys(groupDatan.getUserNotes());
    }
  }
=======
>>>>>>> parent of 7cb18ea... Задание №4: Сделать тесты для создания групп и контактов в адресной книге+ рефакторинг:addressbook-web-tests/src/test/java/ru/stqa/pft1/addressbook1/NewAddressBookCreationTests.java
>>>>>>> parent of 526e766... Задание №5: Реализовать двухуровневую архитектуру тестового набора
}
