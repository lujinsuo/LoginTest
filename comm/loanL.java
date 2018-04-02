package comm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class loanL {
	public WebDriver driver;
	public String baseUrl;
	public void init(){
		System.setProperty("webdriver.firefox.marionette", "D:\\selenium录制\\driver\\geckodriver-v0.9.0-arm7hf");
		driver = new FirefoxDriver();
		baseUrl ="http://10.36.40.211:8383/#/login";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);


	}
	public void login(String name,String pwd){
		
		driver.findElement(By.cssSelector("input[placeholder='请输入用户名']")).sendKeys(name);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(pwd);
		driver.findElement(By.id("loginBtn")).click();
	}


}
