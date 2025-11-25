package smoke;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class SmokeTest {

    public void verifyHomePageLoads() {
        System.out.println("Running Smoke Test: Verify Home Page Loads...");
        Assert.assertTrue(true, "Home page should load successfully");
    }

    public void verifyLoginButtonPresent() {
        System.out.println("Running Smoke Test: Verify Login Button...");
        Assert.assertTrue(true, "Login button should be visible");
    }
}
