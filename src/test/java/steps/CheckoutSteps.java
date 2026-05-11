package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.training.student_ulises_lara.page.HomePage;
import test.Hooks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Class that represents the step definitions for checkout-related scenarios.
 */
public class CheckoutSteps {

    /** Logger instance for logging scenario details */
    private static final Logger log = LogManager.getLogger(CheckoutSteps.class);

    /** Instance of HomePage to interact with home page elements */
    private final HomePage homePage = new HomePage(Hooks.getDriver());

    /** Step definitions for checkout process, including navigating to cart, entering checkout information, and validating confirmation message */
    @And("I navigate to the cart")
    public void navigateToCart() {

        homePage.goToCart();

        log.info("Navigated to cart");
    }

    /** Step definition for clicking the checkout button in the cart */
    @And("I click the checkout button")
    public void clickCheckoutButton() {

        homePage.clickCheckout();

        log.info("Clicked checkout button");
    }

    /** Step definitions for entering checkout information: first name, last name, and zip code */
    @And("I enter {string} into the first name field")
    public void enterFirstName(String firstName) {

        homePage.enterFirstName(firstName);

        log.info("Entered first name");
    }

    /** Step definition for entering last name in the checkout form */
    @And("I enter {string} into the last name field")
    public void enterLastName(String lastName) {

        homePage.enterLastName(lastName);

        log.info("Entered last name");
    }

    /** Step definition for entering zip code in the checkout form */
    @And("I enter {string} into the zip code field")
    public void enterZipCode(String zipCode) {

        homePage.enterZipCode(zipCode);

        log.info("Entered zip code");
    }

    /** Step definition for clicking the continue button in the checkout process */
    @And("I click the continue button")
    public void clickContinueButton() {

        homePage.clickContinue();

        log.info("Clicked continue button");
    }

    /** Step definition for finishing the checkout process by clicking the finish button */
    @And("I finish the checkout process")
    public void finishCheckout() {

        homePage.finishCheckout();

        log.info("Finished checkout process");
    }

    /** Step definition for validating the confirmation message displayed after completing the checkout process */
    @Then("I should see the confirmation message {string}")
    public void validateConfirmationMessage(String expectedMessage) {

        String actualMessage = homePage.getConfirmationMessage();

        log.info("Validating confirmation message");

        assertThat(actualMessage, equalTo(expectedMessage));
    }
}