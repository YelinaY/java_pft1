package ru.stqa.pft1.addressbook1.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.NoSuchElementException;

public class HelperBase {
  protected FirefoxDriver wd;

  public HelperBase(FirefoxDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    /*если вводимые данные - "0" -(null)
        if (text == null) {
    }else {
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
    }
    }
    */
    //значение по умолчанию null
    if (text != null) {
      //проверить если вводимое значение совпадает с ранее вводимым значением -
      String existingText = wd.findElement(locator).getAttribute("value");
      //get.Attribute - для полей ввода, get.Text - возвращает пустую строчку
      if (!text.equals(existingText)) {
        //если текст не  совпадает с существующим текстом ввода: ввели вначале ""ASD"  а затем "ZXC"
      }
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
    }
  }
  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}
