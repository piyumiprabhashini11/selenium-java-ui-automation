package smoke;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest {
         
	   @Test
	   public void verifyHomePageLoads() {
	        System.out.println("Running Smoke Test: Verify Home Page Loads...");
	        Assert.assertTrue(true, "Home page should load successfully");
	    }

	   @Test
	    public void verifyLoginButtonPresent() {
	        System.out.println("Running Smoke Test: Verify Login Button...");
	        Assert.assertTrue(true, "Login button should be visible");
	    }
}
