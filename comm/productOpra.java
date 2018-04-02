package comm;

import java.sql.Driver;

import org.openqa.selenium.By;

import comm.loanL;

public class productOpra extends loanL {

	@Override
	public void init() {
		System.out.println("初始化完成");
	}
	public  void addPro(){
		driver.findElement(By.cssSelector("div> .el-submenu__title")).click();
		driver.findElement(By.cssSelector("li> .el-menu-item")).click();
		
	}
}
