package Metria;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.util;

public class addMetr implements util{
	public StringBuffer verificationErrorString=new StringBuffer();

	@Override
	public void init() {
		System.setProperty("webdriver.firefox.marionette", "D:\\selenium录制\\driver\\geckodriver-v0.9.0-arm7hf");
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Override
	public void login(String name,String pwd) {
		driver.findElement(By.cssSelector("input.el-input__inner")).clear();
		driver.findElement(By.cssSelector("input[placeholder='请输入用户名']")).sendKeys(name);
		//		driver.findElement(By.cssSelector("div.el-form-item.is-required>div.el-form-item__content>div.el-input>input.el-input__inner")).clear();
		driver.findElement(By.cssSelector("input.el-input__inner")).clear();
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(pwd);
		driver.findElement(By.id("loginBtn")).click();
	}
	@Override
	public void add(String tagname) {
		
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
		
	}

}
