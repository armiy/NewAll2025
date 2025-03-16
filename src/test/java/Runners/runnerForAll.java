package Runners;
import Base.theBase;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

import static Base.theBase.driver;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/CFeatures/searchProducts.feature"},
        glue = "EStepDefinitions",
        //plugin = {"pretty","json:target/cucumber-reports/cucumber.json","html:target/cucumber-reports"},
        plugin = {"pretty","html:target/site/cucumber-pretty.html","json:target/cucumber/cucumber.json"},
        //strict = true,
        monochrome = true,
        dryRun = false,
        tags = ""
)

public class runnerForAll extends AbstractTestNGCucumberTests  {


}
