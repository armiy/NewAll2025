package EStepDefinitions;

import Base.theBase;
import DWebElements.allWebElements;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

import static Base.theBase.driver;

public class searchProductsStepDefinitions extends theBase {

    static allWebElements element;
    public static allWebElements getElement(){
        element = new allWebElements(driver);
        return element;
    }
    /*@Before
    public void SetUp() throws MalformedURLException {
        driverSetUp(false,"browserstack",
                "chrome","116",
                "Windows","11","https://www.ebya.com");
    }
    @After
    public void Close(){
        driver.quit();
    }*/

    @When("users enter this {} in the search field")
    public void users_enter_item_name(String itemName){
        getElement().searchOnSearchField(itemName);

    }
    @And("users click the search button")
    public void users_click_Search_button() throws InterruptedException {
        getElement().searchButton.click();
        Thread.sleep(6000);

    }
    @Then("^users land on the searched item this(.*) page")
    public void users_land_on_this_page(String ExpectedpageTitle){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String page_title = driver.getTitle();
        System.out.println(page_title);
        Assert.assertTrue(page_title.contains(ExpectedpageTitle));

    }
}
