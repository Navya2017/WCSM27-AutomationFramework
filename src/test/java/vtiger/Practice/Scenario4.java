package vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Scenario4 {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("jsp");
		
		WebElement ele1=driver.findElement(By.name("industry"));
				Select s=new Select(ele1);
				s.selectByValue("Energy");
				
				WebElement ele2=driver.findElement(By.name("accounttype"));
				Select s1=new Select(ele2);
				s1.selectByValue("Customer");

				
				driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();	
				 Thread.sleep(4000);
				 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			    	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	}

}
