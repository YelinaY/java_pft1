package ru.stqa.pft1.addressbook1.tests;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft1.addressbook1.model.GroupDatan;

import org.openqa.selenium.support.ui.Select;

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
  public void testNewAddressBook() throws Exception {
    userFirstName("Eлена");
<<<<<<< HEAD:addressbook-web-tests/src/test/java/ru/stqa/pft1/addressbook1/tests/NewAddressBookCreationTests.java
    new FillForm().invoke(new GroupDatan("Y/Y", "Yelina", "Lina", "TCWD", "Paris, Royal sq.", "+1111111111", "+222222222", "+33333333", "+44444444", "mail@mail.com", "mail1@mail.com", "mail3@mail.com", "URL", "Minsk", "+5555555555", "Notes"));

=======
    new FillForm().invoke("Y/Y", "Yelina", "Lina", "TCWD", "Paris, Royal sq.", "+1111111111", "+222222222", "+33333333", "+44444444", "mail@mail.com", "mail1@mail.com", "mail3@mail.com", "URL", "Minsk", "+5555555555", "Notes");
    submitNewAddressBook();
>>>>>>> parent of 6ddcc8f... 4 задание - рефакторинг Parametr Object:addressbook-web-tests/src/test/java/ru/stqa/pft1/addressbook1/NewAddressBookCreationTests.java

  }

  private void userFirstName(String userfirstname) {
    wd.get("http://localhost/addressbook/group.php");
    wd.findElement(By.linkText("add new")).click();
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

  private class FillForm {
    public void invoke(String usermiddlename, String userlastname, String usernickname, String userCompany, String userAddress, String userHome, String userMobile, String userWorkingPhone, String userFax, String userMail, String userMail2, String userMail3, String userHomepage, String userAddress2, String userPhone2, String userNotes) {
      wd.findElement(By.name("middlename")).click();
      wd.findElement(By.name("middlename")).clear();
      wd.findElement(By.name("middlename")).sendKeys(usermiddlename);
      wd.findElement(By.name("lastname")).click();
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(userlastname);
      wd.findElement(By.name("nickname")).click();
      wd.findElement(By.name("nickname")).clear();
      wd.findElement(By.name("nickname")).sendKeys(usernickname);
      wd.findElement(By.name("company")).click();
      wd.findElement(By.name("company")).clear();
      wd.findElement(By.name("company")).sendKeys(userCompany);
      wd.findElement(By.name("address")).click();
      wd.findElement(By.name("address")).clear();
      wd.findElement(By.name("address")).sendKeys(userAddress);
      wd.findElement(By.name("home")).click();
      wd.findElement(By.name("home")).clear();
      wd.findElement(By.name("home")).sendKeys(userHome);
      wd.findElement(By.name("mobile")).click();
      wd.findElement(By.name("mobile")).clear();
      wd.findElement(By.name("mobile")).sendKeys(userMobile);
      wd.findElement(By.name("work")).click();
      wd.findElement(By.name("work")).clear();
      wd.findElement(By.name("work")).sendKeys(userWorkingPhone);
      wd.findElement(By.name("fax")).click();
      wd.findElement(By.name("fax")).clear();
      wd.findElement(By.name("fax")).sendKeys(userFax);
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(userMail);
      wd.findElement(By.name("email2")).click();
      wd.findElement(By.name("email2")).clear();
      wd.findElement(By.name("email2")).sendKeys(userMail2);
      wd.findElement(By.name("email3")).click();
      wd.findElement(By.name("email3")).clear();
      wd.findElement(By.name("email3")).sendKeys(userMail3);
      wd.findElement(By.name("homepage")).click();
      wd.findElement(By.name("homepage")).clear();
      wd.findElement(By.name("homepage")).sendKeys(userHomepage);
      wd.findElement(By.name("address2")).click();
      wd.findElement(By.name("address2")).clear();
      wd.findElement(By.name("address2")).sendKeys(userAddress2);
      wd.findElement(By.name("phone2")).click();
      wd.findElement(By.name("phone2")).clear();
      wd.findElement(By.name("phone2")).sendKeys(userPhone2);
      wd.findElement(By.name("notes")).click();
      wd.findElement(By.name("notes")).clear();
      wd.findElement(By.name("notes")).sendKeys(userNotes);
    }
  }
}
