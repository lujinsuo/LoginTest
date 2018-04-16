package comm;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Random;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Configuration;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Listeners({Report.NewReport.class})
public class JdongTest {

	productOpra pro=new productOpra();
	loanL loan=new loanL();


	@Test(dataProvider = "dp",groups={"testc"})
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
	public Object[][] data(Method m){
		System.out.println(m.getName());
		if(m.getName()=="loanLg"){

			return new Object[][]{
					{"test","111111"},

			};
		};
		return new Object[][]{
				{"admin","111111"}};
	}
	@BeforeClass
	@Configuration(beforeTestClass=true,groups={"config"})
	public void beforeClass() {
		loan.init();
	}

	@AfterClass(alwaysRun=true)
	@Configuration(afterTestClass=true,groups="config")
	public void afterClass() {
		loan.quit();

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

	@Parameters({"loginname","pwd"})
	@Test(groups={"testa"})
	public void loanLg(String name,String pwd) throws InterruptedException{
		loan.login(name, pwd);
		Thread.sleep(2000);
		Assert.assertEquals(loan.art(), "http://10.36.40.211:8383/#/Home");
	}
	@Test(dependsOnGroups={"testa"},dataProvider="test",groups={"testb"},alwaysRun=true)
	public void addpro(String tagName) {
		loan.addPro1(tagName);
		Assert.assertEquals(loan.art(), "http://10.36.40.211:8383/#/product/FeaturesManage");
	}
	@Test(groups={"testa"})
	public String returnurl(){
		String str=loan.art();
		return	str;
	}
	@DataProvider(name="test")
	public Object[][] getsource(){
		int max=600;
		int min=40;
		String str="";
		Random random=new Random();
		HashSet<Integer> hs=new HashSet<Integer>();
		while(hs.size()<10){
			int j=random.nextInt(max)%(max-min+1)+min;
			hs.add(j);
		}
		for(Integer it:hs){
			str=Integer.toString(it);
			return new Object[][]{new Object[]{"testaa"+str+1}};
		}
		return null;

	}


}

