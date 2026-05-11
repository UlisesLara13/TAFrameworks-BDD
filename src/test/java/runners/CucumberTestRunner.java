package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Cucumber Test Runner Class
 * Configures the Cucumber test execution environment.
 * Specifies the location of feature files.
 * Sets the glue code packages.
 * Enables parallel execution with dynamic configuration.
 * Adjusts the parallel execution factor for optimal performance.
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "test"},
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
        }
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}