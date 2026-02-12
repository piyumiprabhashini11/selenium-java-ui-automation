package examples.dropdowns;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class DropDownWithLoopingUI {

    public static void main(String[] args)  {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement dropDown = driver.findElement(By.id("divpaxinfo"));
        dropDown.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("hrefIncAdt"))
        );
      System.out.println(dropDown.getText());

      for(int i=0;i<2;i++){
       element.click();
       }
//      int i=0;
//      while(i<2){
//          element.click();
//          i++;
//      }
      Assert.assertEquals(dropDown.getText(),"3 Adult");
      System.out.println(dropDown.getText());
      WebElement doneButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnclosepaxoption")));
      doneButton.click();
      driver.quit();

    }
}
