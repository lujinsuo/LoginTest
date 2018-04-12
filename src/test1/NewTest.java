package test1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterSuite;
import comm.login;
public class NewTest {
/*	private WebDriver driver;
	private String baseUrl;*/
  login lg=new login();
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }
  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider(name="param")
  public Object[][] dp() {
    return new Object[][]{
    		{"merry110208","mei510174771"},
    		{"",""}
    };
  }
  @AfterClass
  public void afterClass() {
  }

  @AfterTest
  public void afterTest() {
  }

  @AfterSuite
  public void afterSuite() {
  }
  @Test(dataProvider="param")
  public void Test(String name,String pwd){

	 lg.login(name, pwd);
	 System.err.println("≤‚ ‘Ω· ¯");
	  
  
  }
  @BeforeClass
  public void BeforeClass(){  
	
  }

}
