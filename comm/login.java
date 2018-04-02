package comm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class login {
	private WebDriver driver;
	private String baseUrl;
	
	public void init(){
		System.setProperty("webdriver.firefox.marionette", "D:\\seleniumÂ¼ÖÆ\\driver\\geckodriver-v0.9.0-arm7hf");
		driver = new FirefoxDriver();
         baseUrl = "https://passport.jd.com/new/login.aspx?ReturnUrl=https%3A%2F%2Fwww.jd.com%2F%3Fcu%3Dtrue%26utm_source%3Dp.yiqifa.com%26utm_medium%3Dtuiguang%26utm_campaign%3Dt_1_268502%26utm_term%3D469867d680e545bba5d0b5c4cb7601d5%26abt%3D3";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
	
	public void login(String name,String pwd){
		 driver.get(baseUrl);
		  driver.findElement(By.linkText("ÕË»§µÇÂ¼")).click();
		  driver.findElement(By.id("loginname")).sendKeys(name);
		  driver.findElement(By.id("nloginpwd")).sendKeys(pwd);
		  driver.findElement(By.id("loginsubmit")).click();
		
	}


	public static void main(String[] args) {
		
	}

}
