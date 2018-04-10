package comm;

import java.sql.Driver;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import comm.loanL;

public class productOpra extends loanL {

	@Override
	public void init() {
		System.out.println("初始化完成");
	}
	public  void addPro(){
		driver.findElement(By.cssSelector("div.el-submenu__title")).click();
		driver.findElement(By.cssSelector("div.el-menu-item")).click();

	}


}





