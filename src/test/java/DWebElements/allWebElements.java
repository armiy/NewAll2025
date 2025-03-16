package DWebElements;

import Base.theBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.time.Duration;

import static Base.theBase.driver;

public class allWebElements {

    WebDriver gdriver;
    public allWebElements(WebDriver ldriver){
        gdriver = ldriver;
        PageFactory.initElements(ldriver,this);
    }

    //Find Items WebElements
    @FindBy(className = "gh-search-categories") public WebElement searchByCatagorySelection;
    @FindBy(css = "#gh-ac") public WebElement searchField;
    @FindBy(id="gh-search-btn") public WebElement searchButton;

    @FindBy(xpath = "//a[contains(@href,'bn_317584')]") public WebElement LaptopSubCategory;
    @FindBy(xpath = "//a[contains(@href,'bn_352905')]") public WebElement DellLaptopSubCategory;
    @FindBy(css = "#s0-1-0-15-4-48\\[3\\]-17\\[19\\]-0-1-2-1\\[0\\]-6-2-list") public WebElement DellCore5;

    @FindBy(css = "body > div.page-container > div.main-content > section.brw-region.brw-region--right > section:nth-child(1) > div.seo-expandable-list.seoel > ul > li:nth-child(2) > div > a") public WebElement ApplePhonesCategory;
    @FindBy(xpath = "//a[contains(@href,'9355/bn_7121795167')]") public WebElement Apple15Pro;
    @FindBy(xpath = "/html/body/div[2]/div[2]/section/section[4]/ul/li[1]/div/div/div[1]/button") public WebElement Apple15ProSpecific;




    //Find Dell Computer through Catagory

    public void searchOnSearchField(String itemName){
        searchField.sendKeys(itemName);
    }

    public void selectCategory(String categoryName){
        Select selectItemCategory = new Select(searchByCatagorySelection);
        selectItemCategory.selectByVisibleText(categoryName);
        searchButton.click();
    }

    public void searchLaptopCategory(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", LaptopSubCategory);
        LaptopSubCategory.click();
    }

    public void searchApplePhones(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ApplePhonesCategory);
        ApplePhonesCategory.click();
    }
    public void searchForDellLapTops(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", DellLaptopSubCategory);
        DellLaptopSubCategory.click();
    }
    public void searchApplePro15(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", Apple15Pro);
        Apple15Pro.click();
    }
    public void searchDellCore5(){
        DellCore5.click();
    }
    public void searchForApple15ProSpecific(){
        Apple15ProSpecific.click();
    }

    public void validatePage(String expectedTitle){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.startsWith(expectedTitle));
        System.out.println(pageTitle);
    }

    public static void main(String[] args) throws MalformedURLException {
        theBase obj = new theBase();
        obj.driverSetUp(false,"browserstack",
                "chrome","132","windows",
                "https://www.ebay.com");
        driver.findElement(By.cssSelector("#gh-ac")).sendKeys("Boys shoes");
        driver.findElement(By.id("gh-search-btn")).click();
        System.out.println(driver.getTitle());
    }


}
