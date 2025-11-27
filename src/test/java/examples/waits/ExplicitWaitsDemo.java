package examples.waits;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class ExplicitWaitsDemo {
	
	    WebDriver driver;
	    WebDriverWait wait;

	    @BeforeMethod
	    public void setUp() {
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	        driver.manage().window().maximize();
	        driver.get("https://opensource-demo.orangehrmlive.com/");
	    }

	    /* ---------------------------------------------------------
	       REAL-WORLD EXAMPLE 1:
	       Login to OrangeHRM using multiple explicit waits
	       --------------------------------------------------------- */
	    @Test
	    public void loginUsingExplicitWaits() {

	        waitUntilVisible(By.name("username")).sendKeys("Admin");
	        waitUntilVisible(By.name("password")).sendKeys("admin123");

	        waitUntilClickable(By.cssSelector("button[type='submit']")).click();

	        // Verify dashboard loaded
	        waitUntilVisible(By.className("oxd-topbar-header-breadcrumb"));
	    }

	    /* ---------------------------------------------------------
	       REAL-WORLD EXAMPLE 2:
	       textToBePresentInElement() - waiting for dynamic loading text
	       --------------------------------------------------------- */
	    @Test
	    public void waitForTextToAppear() throws InterruptedException {
	        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/1");
	        driver.findElement(By.cssSelector("#start button")).click();

	        // Wait for "Hello World!" text to appear
	        wait.until(ExpectedConditions.textToBePresentInElementLocated(
	                By.id("finish"), "Hello World!"
	        ));
	    }

	    /* ---------------------------------------------------------
	       REAL-WORLD EXAMPLE 3:
	       invisibilityOfElement() - loaders/spinners
	       --------------------------------------------------------- */
	    @Test
	    public void waitForLoaderToDisappear() {
	        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/2");
	        driver.findElement(By.cssSelector("#start button")).click();

	        // Wait for loader to hide
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

	        // Wait for result to show
	        waitUntilVisible(By.id("finish"));
	    }

	    /* ---------------------------------------------------------
	       REAL-WORLD EXAMPLE 4:
	       elementToBeSelected() - checkboxes, dropdown options
	       --------------------------------------------------------- */
	    @Test
	    public void waitForCheckboxSelection() {
	        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");

	        WebElement checkbox = driver.findElement(By.xpath("//form/input[1]"));
	        checkbox.click();

	        wait.until(ExpectedConditions.elementToBeSelected(checkbox));
	    }

	    /* ---------------------------------------------------------
	       REAL-WORLD EXAMPLE 5:
	       alertIsPresent() - waiting for JavaScript popups
	       --------------------------------------------------------- */
	    @Test
	    public void waitForAlert() {
	        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
	        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	        alert.accept();
	    }

	    /* ---------------------------------------------------------
	       REAL-WORLD EXAMPLE 6:
	       frameToBeAvailableAndSwitchToIt() - iFrames
	       --------------------------------------------------------- */
	    @Test
	    public void waitForFrame() {
	        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("mce_0_ifr")));

	        WebElement editor = waitUntilVisible(By.id("tinymce"));
	        editor.clear();
	        editor.sendKeys("Automation typing into iFrame...");
	    }

	    /* ---------------------------------------------------------
	       REAL-WORLD EXAMPLE 7:
	       visibilityOfAllElements() - tables, lists, dropdowns
	       --------------------------------------------------------- */
	    @Test
	    public void waitForMultipleElements() {
	        driver.navigate().to("https://www.selenium.dev/documentation/");

	        List<WebElement> menuItems =
	                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
	                        By.cssSelector("ul.navbar-nav li.nav-item")
	                ));

	        System.out.println("Menu count: " + menuItems.size());
	    }

	    /* ---------------------------------------------------------
	       HELPER METHODS FOR CLEAN CODE
	       --------------------------------------------------------- */
	    public WebElement waitUntilVisible(By locator) {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }

	    public WebElement waitUntilClickable(By locator) {
	        return wait.until(ExpectedConditions.elementToBeClickable(locator));
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    
	}
	    
}

	
	

