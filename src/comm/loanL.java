package comm;

import java.util.concurrent.TimeUnit;

import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.seleniumhq.jetty9.server.Authentication.Failed;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

public class loanL {
	public WebDriver driver;
	public String baseUrl;
	public StringBuffer verificationErrorString=new StringBuffer();
	private int num;
	private String str;
	 public loanL(int num){
		 this.num=num;
		  
	 }
	 public loanL(){};
	
	 
	public void init(){
		System.setProperty("webdriver.firefox.marionette", "D:\\selenium录制\\driver\\geckodriver-v0.9.0-arm7hf");
		driver = new FirefoxDriver();
		baseUrl ="http://10.36.40.211:8383/#/login";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);


	}
	public void login(String name,String pwd){
		driver.findElement(By.cssSelector("input.el-input__inner")).clear();
		driver.findElement(By.cssSelector("input[placeholder='请输入用户名']")).sendKeys(name);
		//		driver.findElement(By.cssSelector("div.el-form-item.is-required>div.el-form-item__content>div.el-input>input.el-input__inner")).clear();
		driver.findElement(By.cssSelector("input.el-input__inner")).clear();
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(pwd);
		driver.findElement(By.id("loginBtn")).click();
	}

	public void quit(){
		driver.quit();
		String err=verificationErrorString.toString();
		if(!"".equals(verificationErrorString)){
			System.err.println(verificationErrorString);
		}
	}
	public  void addPro1(String tagname){
		driver.findElement(By.cssSelector("div.el-submenu__title")).click();
		driver.findElement(By.cssSelector("li.el-menu-item:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector("form.el-form.el-form--inline button[type=button]" )).click();
		driver.findElement(By.xpath(".//*[@id='app']/div/div[2]/section/div/div[2]/section/div/div/form/div[1]/div/div/input")).sendKeys(tagname);
		
		driver.findElement(By.id("image")).clear();
		driver.findElement(By.id("image")).sendKeys("C:\\Users\\Administrator\\Desktop\\图片\\电签\\b.png");
		driver.findElement(By.cssSelector(".el-form-item__content>.el-button.el-button--primary")).click();

	}
	
	public void delePro(){
	//driver.findElement(By.cssSelector("a[href='#/product/FeaturesAdd?featureId=50'][target='_self']")).click();	
	//driver.findElement(By.xpath("//a[@href='#/product/FeaturesAdd?featureId=50']")).click();
	driver.findElement(By.cssSelector(".el-table__row hover-row>td:nth-type-of(4)>.cell>button :nth-type-of(1)")).click();
	};

	public void custom(){
		driver.findElement(By.cssSelector("ul.el-menu.el-menu-vertical-demo>li.el-submenu:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector("ul.el-menu.el-menu-vertical-demo li.el-submenu:nth-of-type(2)>ul.el-menu>li:nth-child(1)+li")).click();


	}
	public void load(){
		driver.findElement(By.cssSelector("ul.el-menu.el-menu-vertical-demo>li.el-submenu:nth-of-type(3)")).click();
		driver.findElement(By.cssSelector("ul.el-menu.el-menu-vertical-demo>li.el-submenu:last-child>ul.el-menu li:nth-child(1)+li")).click();

	}

	public String art(){
		String  str=driver.getCurrentUrl();

		return str;

	}

}


