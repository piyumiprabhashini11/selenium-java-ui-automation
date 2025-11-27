package examples.waits;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWaitDemo {

    WebDriver driver;
    FluentWait<WebDriver> fluentWait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        // Fluent Wait: custom interval + ignoring exceptions
        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))     // Max wait time
                .pollingEvery(Duration.ofMillis(500))    // Check every 0.5s
                .ignoring(NoSuchElementException.class); // Ignore missing elements
    }

    @Test
    public void waitForPriceElement() {
        // Example: waiting for a dynamic price element

        WebElement priceElement = fluentWait.until(
                driver -> driver.findElement(By.cssSelector("span.a-price"))
        );

        System.out.println("Price found: " + priceElement.getText());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

