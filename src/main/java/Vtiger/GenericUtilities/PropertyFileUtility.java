package Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic methods related to property file
 * @author Navya
 * 
 */
public class PropertyFileUtility {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromPropertyFile(String key) throws IOException
	{

        FileInputStream fisp= new FileInputStream(IConstantsUtility.propertyfilePath);
		 Properties pObj=new Properties();
		pObj.load(fisp);
		String value=pObj.getProperty(key);
		return value;
	}
	
}
