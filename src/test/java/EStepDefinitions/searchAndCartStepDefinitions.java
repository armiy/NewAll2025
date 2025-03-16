package EStepDefinitions;

import Base.theBase;
import DWebElements.allWebElements;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.time.Duration;

import static Base.theBase.driver;

public class searchAndCartStepDefinitions extends theBase{


     static allWebElements elements;
     public static allWebElements getElements(){
         elements = new allWebElements(driver);
         return elements;
     }
     @Before

     public void beforeMethod() throws MalformedURLException {
         driverSetUp(false,"saucelabs",
                 "chrome","116",
                 "windows","https://www.ebay.com");

     }
     @After
     public void close(){
         driver.quit();
     }

     @When("^users select (.*) in category selection")
    public void searchMajorCategory(String categoryName){
         getElements().selectCategory(categoryName);

     }
     @And("users search click to search for Laptops")
    public void searchDellComputers(){

         getElements().searchLaptopCategory();
     }
     @And("users click for Dell Laptops")
    public void searchDellLaptops(){
         getElements().searchForDellLapTops();
     }
     @And("user search for Dell specific")
    public void searchForDellCore5(){

         getElements().searchDellCore5();
     }

     @Then("^users see this page title (.*)")
    public void Assert(String expectedPagegTitle) {
         String pageTitle = driver.getTitle();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
         Assert.assertFalse(expectedPagegTitle.contains(pageTitle));

     }


}
