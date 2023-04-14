package Vtiger.GenericUtilities;

import java.util.Date;
import java.util.Random;
/**
 * This class consists of methods related to java
 * @author A
 *
 */
public class JavaUtility {
/**
 * This method will return random number after every run
 * @return
 */
	public int getRandomNumber()
	{
		Random r=new Random();
		return r.nextInt(1000);
		
	}
	/**
	 * This method will return current system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		return d.toString();
	}
	public String getSystemDateInFormat()
	
	{
		Date d=new Date();
		String[] dArr= d.toString().split(" ");
		String date=dArr[2];
		String month=dArr[1];
		String year=dArr[5];
		String time=dArr[3].replace(":","-");
		String dateValue=date+"-"+month+"-"+year+"_"+time;
		return dateValue;
		
		
				
		
		
		
		
		
	}
	
}
