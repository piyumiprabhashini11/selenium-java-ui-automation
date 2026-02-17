package examples.dropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DynamicDropdowns {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@value='BLR'])[2]")));
        /*If indexing is not allowed inside the xpath,
        div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//descendant::a[@value='BLR'] or //div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='BLR']
        can be used instead of (//a[@value='BLR'])[1] */
        driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
        driver.close();
    }
}
