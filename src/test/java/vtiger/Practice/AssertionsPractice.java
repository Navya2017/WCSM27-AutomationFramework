package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
@Test
public void practice()
{
	System.out.println("step 1");
	System.out.println("step 2");
	Assert.assertEquals(false, true);
	System.out.println("step 3");
	System.out.println("step 4");
}
@Test
public void practice1()
{
	SoftAssert sa=new SoftAssert();
	System.out.println("step 1-practice");
	sa.assertEquals(false, true);
	System.out.println("step 2-practice");
	sa.assertEquals(false, true);
	System.out.println("step 3-practice");
	System.out.println("step 4-practice");
	sa.assertAll();
}



}
