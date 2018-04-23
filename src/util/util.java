package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public interface util {
	public final static String baseUrl ="http://10.36.40.211:8383/#/login";
	public final static WebDriver driver=new FirefoxDriver();
	public void init();
	public void login(String name,String pwd);
	public void add();
	public void del();
	void quit();
	
	

}
