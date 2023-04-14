package vtiger.Practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario5 {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		String parentId=driver.getWindowHandle();
	     System.out.println("parent window "+parentId);
	     driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Navya");
	    driver.findElement(By.xpath("//img[@title='Select'][1]")).click();
	     Set<String> handles=driver.getWindowHandles();
	     for(String handle:handles) {
	    	 System.out.println(handle);
	    	 if(!handle.equals(parentId)) {
	    		 driver.switchTo().window(handle);
	    	 
	    	 driver.findElement(By.id("1")).click();
	    	 Thread.sleep(4000);
	    	 }
	    	 }
	     driver.switchTo().window(parentId);
	    	driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	    	 Thread.sleep(4000);
	    	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	    	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	     
	     }
		

	}


