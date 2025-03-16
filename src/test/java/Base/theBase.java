package Base;

import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class theBase {

    public static WebDriver driver;
    public String saucelabsUserName = "oauth-armachenanbessa26-85b1f";
    public String saucelabsAccessKey ="62263865-c720-49ad-8a5c-d8290c685acf";
    public String browserstackUserName = "armachenanbessa_6Li9Qr";
    public String browserstackAccessKey ="FuuS8SXzM5p495VTpjAR";

    @Parameters({"use_cloud_env","env_name","browser_name","browser_version","OS","url"})

    @BeforeTest
    public void driverSetUp(@Optional("false") boolean use_cloud_env,@Optional("saucelabs") String env_name,
                @Optional("chrome")String browser_name,@Optional("116")String browser_version,
                @Optional("windows") String OS,String url) throws MalformedURLException {
       if(use_cloud_env == true){
           if(env_name.equalsIgnoreCase("saucelabs")){
               cloudSetup(env_name,saucelabsUserName,saucelabsAccessKey,
                       browser_name,browser_version,OS);
           }
           if(env_name.equalsIgnoreCase("browserstack")){
               cloudSetup(env_name,browserstackUserName,browserstackAccessKey,
                       browser_name,browser_version,OS);
           }
       }
       else {
           localSetup(browser_name);

        }

       driver.get(url);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterTest
    public void close(){
        driver.quit();
    }

    public WebDriver localSetup(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        }
        return driver;
    }

    public WebDriver cloudSetup(String envName, String envUserName,
                                String envAccessKey,String browserName,
                                String browserVersion,String os
                                ) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browserName",browserName);
        cap.setCapability("browserVersion",browserVersion);
        cap.setCapability("platformName",os);
        if(envName.equalsIgnoreCase("saucelabs")){
            driver = new RemoteWebDriver(new URL("http://"+envUserName+":"+envAccessKey+
                    "@ondemand.saucelabs.com:80/wd/hub"),cap);
        }
        if(envName.equalsIgnoreCase("browserstack")){
            //cap.setCapability("resolution","1024x768");
            driver = new RemoteWebDriver(new URL("http://"+envUserName+":"+envAccessKey+
                    "@hub-cloud.browserstack.com/wd/hub"),cap);
        }
        return driver;
    }


    public static void main(String[] args) throws MalformedURLException {
        theBase obj = new theBase();
        obj.driverSetUp(false,"browserstack",
                "chrome","134","windows",
                "https://www.ebay.com");

        driver.findElement(By.cssSelector("#gh-ac")).sendKeys("Samsung Phones");
        driver.findElement(By.id("gh-search-btn")).click();
        System.out.println( driver.getTitle());
    }


}
