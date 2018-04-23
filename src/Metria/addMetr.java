package Metria;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import bsh.commands.dir;

import util.util;

public class addMetr implements util{
	String mainhand;
	public StringBuffer verificationErrorString=new StringBuffer();

	@Override
	public void init() {
		System.setProperty("webdriver.firefox.marionette", "D:\\selenium录制\\driver\\geckodriver-v0.9.0-arm7hf");
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Override
	public void login(String name,String pwd) {
		String longhand=driver.getWindowHandle();
		Set<String>hands=driver.getWindowHandles();
		for(String handle:hands){
			if(longhand.endsWith(handle)==false){
				driver.switchTo().window(handle);
				System.out.println("窗口正确");
			}
		}
		driver.findElement(By.cssSelector("input.el-input__inner")).clear();
		driver.findElement(By.cssSelector("input[placeholder='请输入用户名']")).sendKeys(name);
		//		driver.findElement(By.cssSelector("div.el-form-item.is-required>div.el-form-item__content>div.el-input>input.el-input__inner")).clear();
		driver.findElement(By.cssSelector("input.el-input__inner")).clear();
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(pwd);
		mainhand=driver.getWindowHandle();
		driver.findElement(By.id("loginBtn")).click();
	}

	@Override
	public void quit() {
		driver.quit();
		String err=verificationErrorString.toString();
		if(!"".equals(verificationErrorString)){
			System.err.println(verificationErrorString);
		}

	}
	@Override
	public void del() {

		//driver.findElement(By.xpath("//div[@id='app']/div/div[2]/section/div/div[2]/section/div[3]/div/ul/li[2]")).click();
		driver.findElement(By.xpath("//td[@class='el-table_1_column_3']/div[@class='cell']/button[@type='button'][3]")).click();
		driver.findElement(By.cssSelector("td.el-table_1_column_3.is-hidden>div.cell>button:nth-of-type(2)")).click();
	}
	@Override
	public void add() {
		if(mainhand.equals(driver.getWindowHandle())){
			driver.findElement(By.cssSelector("div.el-submenu__title")).click();
			driver.findElement(By.cssSelector("li.el-menu-item:nth-of-type(3)")).click();
			driver.findElement(By.cssSelector("form.el-form.el-form--inline>button.el-button.el-button--primary")).click();
			driver.findElement(By.className("el-input__inner")).sendKeys("test118");
			driver.findElement(By.cssSelector(".el-form-item__content>.el-button.el-button--primary")).click();
			System.out.println(driver.getWindowHandle());
		}
		else
		{
			System.out.println("非当前页面");
		}


	}
}