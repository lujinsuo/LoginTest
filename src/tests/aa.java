package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class aa{
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.marionette", "D:\\seleniumÂ¼ÖÆ\\driver\\geckodriver-v0.9.0-arm7hf");
		driver = new FirefoxDriver();
		baseUrl = "http://10.36.40.211:8383/#/login";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void test12() throws Exception {
		driver.get(baseUrl + "/#/login");
		driver.findElement(By.cssSelector("input.el-input__inner")).clear();
		driver.findElement(By.cssSelector("input.el-input__inner")).sendKeys("admin");
		driver.findElement(By.cssSelector("div.el-form-item.is-required > div.el-form-item__content > div.el-input > input.el-input__inner")).clear();
		driver.findElement(By.cssSelector("div.el-form-item.is-required > div.el-form-item__content > div.el-input > input.el-input__inner")).sendKeys("111111");
		driver.findElement(By.id("loginBtn")).click();
		driver.findElement(By.cssSelector("div.el-submenu__title")).click();
		driver.findElement(By.cssSelector("li.el-menu-item")).click();
	}

	@AfterMethod
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
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
