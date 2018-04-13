package mainOPr;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

import java.util.List;

import org.testng.SuiteRunner;
import org.testng.reporters.jq.TestNgXmlPanel;
import org.testng.xml.XmlSuite;

import com.beust.testng.TestNG;

public class TestInput {

	public static void main(String[] args) throws IOException {
		Properties pro=new ConfigRead().Readconf();	
		TestNG testng=new TestNG();
		List<String> suite=new ArrayList<String>();
		/*suite.add("E:\\Users\\Administrator\\workspace1\\test\\loan.xml");
		suite.add("E:\\Users\\Administrator\\workspace1\\test\\loginTest.xml");*/
		//suite.add(pro.getProperty("suite1"));
		suite.add(pro.getProperty("suite2"));		
		testng.setTestSuites(suite);
		testng.run();
	}
}

