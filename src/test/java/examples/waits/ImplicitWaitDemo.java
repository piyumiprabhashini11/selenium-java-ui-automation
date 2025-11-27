package examples.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class ImplicitWaitDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();

        // GLOBAL WAIT - applies to every findElement()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
    }

    @Test
    public void searchProduct() {
        // Selenium will wait UP TO 10 seconds for the element automatically
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}