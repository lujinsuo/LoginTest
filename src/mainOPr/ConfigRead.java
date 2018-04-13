package mainOPr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigRead {
	public Properties Readconf() throws IOException {
		InputStream input=this.getClass().getResourceAsStream("/FileConfig/confg.properties");
		/*File file=new File("confg.properties");
		FileInputStream stream=new FileInputStream(file);*/
		Properties pro=new Properties();
		pro.load(input);
		System.out.println(pro.getProperty("suite2"));
		//pro.load(new FileReader("E:\\Users\\Administrator\\workspace1\\test\\confg.properties"));
		return pro;

	}
}
