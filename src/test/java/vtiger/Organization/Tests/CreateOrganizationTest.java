package vtiger.Organization.Tests;

import java.io.IOException;
//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.BaseClass;
import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;
import Vtiger.ObjectRepository.LoginPage;
import Vtiger.ObjectRepository.OrganizationsInfoPage;
import Vtiger.ObjectRepository.OrganizationsPage;
import io.github.bonigarcia.wdm.WebDriverManager;



@Listeners(Vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateOrganizationTest extends BaseClass {
	
@Test (groups = "SmokeSuite")                        // (groups = "RegressionSuite")
//

public  void createOrgTest() throws IOException {


String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();


//Step 5: Navigate to Organizations link
	HomePage hp = new HomePage(driver);
	hp.clickOnOrganizationLink();
    Reporter.log("navigated to organizations link",true);//printed in report
    
    
    
	// Step 6: Click on Create Organization Look up Image
	OrganizationsPage op = new OrganizationsPage(driver);
	op.clickOnCreateOrganizationLookUpImg();
	Reporter.log("clicked on oranization look up image",true);//printed in report
	
	
	
	// Step 7: Create organization with mandatory Fields
	CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
	cnop.createNewOrganization(ORGNAME);
	Reporter.log("organization created with mandatory fields",true);//printed in report

	// Step 8: Validate for Organization
	OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
	String OrgHeader = oip.getOrganizationHeader();
	Assert.assertTrue(OrgHeader.contains(ORGNAME));
	/*
	if (OrgHeader.contains(ORGNAME)) {
	System.out.println(OrgHeader + " --- Organization Created ---");
	} else {
	System.out.println(" ----Organization creation Failed ----");
	}
*/
}
@Test
public void demo()
{
	System.out.println("This is demo");
}

	
}	
	



