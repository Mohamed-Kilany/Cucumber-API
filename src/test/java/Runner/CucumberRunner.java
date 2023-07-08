package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "StepsDefinition",
        tags = "",
        plugin = {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports/Cucumber.html"}
)

public class CucumberRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
