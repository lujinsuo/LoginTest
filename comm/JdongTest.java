package comm;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Driver;

import comm.loanL;
import comm.productOpra;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class JdongTest {
	loanL loan=new loanL();
	productOpra pro=new productOpra();
	

	@Test(dataProvider = "dp")
	public void f(Integer n, String s) {
	}
	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}


	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
				new Object[] { 1, "a" },
				new Object[] { 2, "b" },
		};

	}

	@DataProvider(name="loanParam")
	public Object[][] data(){

		return new Object[][]{
				{"admin","111111"}

		};
	}
	@BeforeClass
	public void beforeClass() {
		loan.init();
	}

	@AfterClass(alwaysRun=true)
	public void afterClass() {
		//loan.quit();
		
	}

	@BeforeTest
	public void beforeTest() {

	}

	@AfterTest
	public void afterTest() {
	
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}
	@Test(dataProvider="loanParam")
	public void loanLg(String name,String pwd){

		loan.login(name, pwd);
   Assert.assertEquals("", "");

	}
	@Test(dependsOnMethods={"loanLg"})
	public void addpro() {
		loan.addPro1();
	}

}
