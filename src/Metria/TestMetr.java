package Metria;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Configuration;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Report.NewReport;
@Listeners({Report.NewReport.class})
public class TestMetr {
	addMetr met=new addMetr();
	@BeforeClass
	@Configuration(beforeTestClass=true,groups={"config"})
	public void Befclass(){
		met.init();	
	}

	@AfterClass
	@Configuration(afterTestClass=true,groups={"config"})
	public void after(){
		met.quit();
	}

	@Test(dataProvider="loanParam",dataProviderClass=comm.JdongTest.class,singleThreaded=true)
	public void lgin(String name,String pwd){
		met.login(name, pwd);
		System.out.println("met");

	}

	@DataProvider(name="login")
	public Object[][] dataLgin(Method m){
		if (m.getName()=="lgin"){
			return new Object[][]{{"admin","111111"}};
		}else
		{
			return null;
		}

	}


}
