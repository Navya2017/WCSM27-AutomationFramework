package vtiger.Practice;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

import org.testng.annotations.Test;
import static org.testng.Assert.fail;



public class TestNGPracticeTest {

	@Test
	public void createUserTest()
	{
		//AssertJUnit.fail();
	System.out.println("user created");	
	}

	@Test
	public void modifyUserTest()
	{
	System.out.println("user modified");	
	}
	@Test(dependsOnMethods = "modifyUserTest")
	public void deleteUserTest()
	{
	System.out.println("user deleted");	
	}
}
