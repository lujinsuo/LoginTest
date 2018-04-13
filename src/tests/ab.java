package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ab{
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.firefox.marionette", "D:\\selenium¼��\\driver\\geckodriver-v0.9.0-arm7hf");
    driver = new FirefoxDriver();
    baseUrl = "http://10.36.40.211:8383/#/login";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test33() throws Exception {
    driver.get(baseUrl + "/#/login");
    driver.findElement(By.cssSelector("input.el-input__inner")).clear();
    driver.findElement(By.cssSelector("input.el-input__inner")).sendKeys("admin");
    driver.findElement(By.cssSelector("div.el-form-item.is-required > div.el-form-item__content > div.el-input > input.el-input__inner")).clear();
    driver.findElement(By.cssSelector("div.el-form-item.is-required > div.el-form-item__content > div.el-input > input.el-input__inner")).sendKeys("111111");
    driver.findElement(By.id("loginBtn")).click();
    driver.findElement(By.cssSelector("div.el-submenu__title")).click();
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/aside/ul/li/ul/li[2]")).click();
    driver.findElement(By.cssSelector("a > button.el-button.el-button--primary")).click();
    driver.findElement(By.cssSelector("input.el-input__inner")).clear();
    driver.findElement(By.cssSelector("input.el-input__inner")).sendKeys("test");
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/section/div/div[2]/section/div/div/form/div[3]/div/div/div/i")).click();
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/section/div/div[2]/section/div/div/form/div[3]/div/div/div/i")).click();
    driver.findElement(By.xpath("//div/ul/li[2]")).click();
    driver.findElement(By.cssSelector("div.el-form-item__content > button.el-button.el-button--primary")).click();
    driver.findElement(By.id("image")).clear();
    driver.findElement(By.id("image")).sendKeys("C:\\Users\\Administrator\\Desktop\\图片\\电签\\b.png");
    driver.findElement(By.cssSelector("div.el-form-item__content > button.el-button.el-button--primary")).click();
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/section/div/div[2]/section/div[2]/div/ul/li[2]")).click();
    driver.findElement(By.cssSelector("a > button.el-button.el-button--primary")).click();
    driver.findElement(By.cssSelector("button.el-button.el-button--primary")).click();
    driver.findElement(By.cssSelector("a > button.el-button.el-button--primary")).click();
    driver.findElement(By.cssSelector("a > button.el-button.el-button--primary")).click();
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/section/div/div[2]/section/form")).click();
    driver.findElement(By.cssSelector("a > button.el-button.el-button--primary")).click();
    driver.findElement(By.cssSelector("input.el-input__inner.firepath-matching-node")).click();
    driver.findElement(By.id("image")).click();
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
