package vtiger.Organization.Tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
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
public class CreateMultipleOrgTest extends BaseClass {

	ExcelFileUtility eUtil=new ExcelFileUtility();
	JavaUtility jUtil = new JavaUtility();
	@Test(dataProvider="OrgWithIndustry")
	
	public void createOrgTest(String ORG,String INDUSTRY) throws IOException
	{
		/*PropertyFileUtility pUtil = new PropertyFileUtility();
		
		WebDriverUtility wUtil = new WebDriverUtility();

		//Step 2: Read all the required Data
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
*/
		String ORGNAME = ORG+jUtil.getRandomNumber();

		/*WebDriver driver = null;

		//Step 3: Launch the Browser - RUNTIME POLYMORPHISM
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		}
		else
		{
		System.out.println("invalid browser name");
		}

		wUtil.maximizewindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		


		// Step 4: Login to App
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		*/
		
		
		//Step 5: Navigate to Organizations link
			HomePage hp = new HomePage(driver);
			hp.clickOnOrganizationLink();

			// Step 6: Click on Create Organization Look up Image
			OrganizationsPage op = new OrganizationsPage(driver);
			op.clickOnCreateOrganizationLookUpImg();

			// Step 7: Create organization with mandatory Fields
			CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			cnop.createNewOrganization(ORGNAME,INDUSTRY);

			// Step 8: Validate for Organization
			OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
			String OrgHeader = oip.getOrganizationHeader();
			
			Assert.assertTrue(OrgHeader.contains(ORGNAME));
		/*	if (OrgHeader.contains(ORGNAME)) {
			System.out.println(OrgHeader + " --- Organization Created ---");
			} else {
			System.out.println(" ----Organization creation Failed ----");
			}
*/
			// Step 9: Logout
		//	hp.logoutOfApp(driver);
		//	System.out.println("Sign out successful");
}
	@DataProvider(name="OrgWithIndustry")
	public Object[][]getData() throws EncryptedDocumentException, IOException 
	{
	Object[][] data=eUtil.readDataFromExcelToDataProvider("dataProviderOrg");           
	return data;	
	}
	
	
}
