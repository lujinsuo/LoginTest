package com.aa;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test55{
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.firefox.marionette","D:\\selenium¼��\\driver\\geckodriver-v0.9.0-arm7hf");
    driver = new FirefoxDriver();
    baseUrl = "http://10.36.40.211:8383/#/login";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test55() throws Exception {
    driver.get(baseUrl + "/#/product/FeaturesManage");
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/aside/ul/li/ul/li[2]")).click();
    driver.findElement(By.cssSelector("a > button.el-button.el-button--primary")).click();
    driver.findElement(By.cssSelector("input.el-input__inner")).clear();
    driver.findElement(By.cssSelector("input.el-input__inner")).sendKeys("test");
    driver.findElement(By.cssSelector("div.el-form-item__content > button.el-button.el-button--primary")).click();
    driver.findElement(By.cssSelector("input.el-input__inner")).clear();
    driver.findElement(By.cssSelector("input.el-input__inner")).sendKeys("test123459");
    driver.findElement(By.cssSelector("div.el-form-item__content > button.el-button.el-button--primary")).click();
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/section/div/div[2]/section/div[2]/div/ul/li[8]")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[42]")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}