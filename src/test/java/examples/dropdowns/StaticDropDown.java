package examples.dropdowns;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement staticDropdownLocation=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        //Dropdowns with select tag(Static Dropdowns with fixed options),so create an object with 'Select' class in Selenium
        Select dropdown=new Select(staticDropdownLocation);
        dropdown.selectByVisibleText("USD");
        assert dropdown.getFirstSelectedOption().getText().equals("USD"); //To assert the text on the selected option
        dropdown.selectByValue("INR");
        assert dropdown.getFirstSelectedOption().getText().equals("INR");
        dropdown.selectByIndex(2);
        assert dropdown.getFirstSelectedOption().getText().equals("AED");

//        driver.close();
    }



}
