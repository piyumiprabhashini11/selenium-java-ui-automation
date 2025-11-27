package examples.waits;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomWaitDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/");
    }

    // Custom retry wait - checks every 1 second
    public WebElement customWait(By locator, int timeoutSec) {
        WebElement element = null;

        for (int i = 0; i < timeoutSec; i++) {
            try {
                element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    return element;    // SUCCESS
                }
            } catch (Exception e) {}

            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        }

        throw new RuntimeException("Element not found after " + timeoutSec + " seconds.");
    }

    @Test
    public void customWaitExample() {
        // Example: waiting for dynamic text or animation finish
        WebElement downloads = customWait(By.linkText("Downloads"), 10);
        downloads.click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

