package comm;
import java.lang.reflect.Method;
import java.sql.Driver;
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
import org.testng.annotations.ExpectedExceptions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
@Listeners({Report.NewReport.class})
public class JdongTest {
	String str="";


	productOpra pro=new productOpra();
	loanL loan=new loanL();


	@Test(dataProvider = "dp",groups={"testc"})

	public void f(Integer n, String s) {
		long id=Thread.currentThread().getId();


	}
	@BeforeMethod
	public void beforeMethod() {
		long id=Thread.currentThread().getId();
		System.out.println("before Thread is"+id);
	}

	@AfterMethod
	public void afterMethod() {
		long id=Thread.currentThread().getId();
		System.out.println("after Thread is" +id);

	}


	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
				new Object[] { 1, "a" },
				new Object[] { 2, "b" },
		};

	}

	@DataProvider(name="loanParam", parallel=true)
	public static Object[][] data(Method m){
		System.out.println(m.getName());
		if(m.getName()=="loanLg"){

			return new Object[][]{
					{"test","111111"},

			};
		}else{
			return new Object[][]{
					{"admin","111111"}};
		}

	}
	@BeforeClass
	@Configuration(beforeTestClass=true,groups={"config"})
	public void beforeClass() {
		loan.init();
	}

	@AfterClass(alwaysRun=true,dependsOnGroups="testb")
	@Configuration(afterTestClass=true,groups="config")
	public void afterClass() {
		loan.quit();
		long id = Thread.currentThread().getId();
	}
	@Parameters({"test-name"})
	@BeforeTest
	public void beforeTest() {
		long id=Thread.currentThread().getId();
		//		System.out.println("Before test " + testName + ". Thread id is: " + id);
	}

	@AfterTest
	public void afterTest() {
		long id = Thread.currentThread().getId();
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

	/*@Parameters({"loginname","pwd"})*/
	@Test(groups={"testa"} ,dataProvider="loanParam",singleThreaded=true,priority=1 )
//	@ExpectedExceptions(InterruptedException.class)
	public void loanLg(String name,String pwd) throws Exception  {
		loan.login(name, pwd);
		Thread.sleep(2000);
		Assert.assertEquals(loan.art(), "http://10.36.40.211:8383/#/Home");
		//assert false;
	}
	@Test(dependsOnGroups={"testa"},dataProvider="test",groups={"testb"},alwaysRun=true
		,priority=2)
	public void addpro(String tagName) {
		long id=Thread.currentThread().getId();
		loan.addPro1(tagName);
		this.str=tagName;
		//Assert.assertEquals(loan.art(), "http://10.36.40.211:8383/#/product/FeaturesManage");
	}
	@Test(dependsOnMethods={"addpro"},groups={"testb"})
	public void delePro(){
		loan.delePro();
		//	Assert.assertEquals(loan.art(), "http://10.36.40.211:8383/#/product/FeaturesAdd?featureId=tagname");
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
			return new Object[][]{new Object[]{"test"+str+1}};
		}
		return null;

	}

	@DataProvider(name="del")
	public Object[][] delpro(){
		return new Object[][]{new Object[]{str}};


	}


}

