package steps;

import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.training.student_ulises_lara.page.HomePage;
import com.epam.training.student_ulises_lara.page.LoginPage;
import test.Hooks;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Class that represents the steps definitions for login-related scenarios.
 */
public class LoginSteps {

    /** Logger instance for logging scenario details */
    private static final Logger log = LogManager.getLogger(LoginSteps.class);

    /** Instance of LoginPage to interact with login page elements */
    private LoginPage loginPage;


    /** Step definitions for opening login page */
    @Given("I open the login page")
    public void openLoginPage() {
        loginPage = new LoginPage(Hooks.getDriver()).openPage();
        log.info("Opened login page");
    }

    /** Step definition for entering username */
    @When("I enter {string} into the username field")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
        log.info("Entered username");
    }

    /** Step definition for entering password */
    @When("I enter {string} into the password field")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
        log.info("Entered password");
    }

    /** Step definition for clearing username field */
    @When("I clear the username field")
    public void clearUsernameField() {
        loginPage.clearUsername();
        log.info("Cleared username field");
    }

    /** Step definition for clearing password field */
    @When("I clear the password field")
    public void clearPasswordField() {
        loginPage.clearPassword();
        log.info("Cleared password field");
    }

    /** Step definition for clicking the login button */
    @When("I click the login button")
    public void clickLoginButton() {
        loginPage.clickLogin();
        log.info("Clicked login button");
    }

    /** Step definition for validating error message on failed login */
    @Then("I should see the error message {string}")
    public void validateErrorMessage(String expectedMessage) {

        String actualMessage = loginPage.getAlertMessage();

        log.info("Validating error message");

        assertThat(actualMessage, equalTo(expectedMessage));
    }

    /** Step definition for validating header title on successful login */
    @Then("I should see the header title {string}")
    public void validateHeaderTitle(String expectedTitle) {

        HomePage homePage = new HomePage(Hooks.getDriver());

        String actualTitle = homePage.getHeaderTitle();

        log.info("Validating header title");

        assertThat(actualTitle, equalTo(expectedTitle));
    }
}