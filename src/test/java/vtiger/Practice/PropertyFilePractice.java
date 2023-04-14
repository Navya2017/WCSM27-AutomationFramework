package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
		//step1:load the file in java readable format using file input stream
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step 2:create an object of properties from java.util
		Properties pObj=new Properties();
		
		
		//step 3: load file input stream into properties
		pObj.load(fis);
		
		//step 4:using key read the value
		String BROWSER=pObj.getProperty("password");
		System.out.println(BROWSER);
		

	}

}
