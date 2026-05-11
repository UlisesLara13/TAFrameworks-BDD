package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.training.student_ulises_lara.page.HomePage;
import test.Hooks;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Class that represents the step definitions for cart-related scenarios.
 */
public class CartSteps {

    /** Logger instance for logging scenario details */
    private static final Logger log = LogManager.getLogger(CartSteps.class);

    /** Instance of HomePage to interact with home page elements */
    private final HomePage homePage = new HomePage(Hooks.getDriver());

    /** Step definition for adding the first product to the cart */
    @When("I add the first product to the cart")
    public void addFirstProductToCart() {

        homePage.addFirstProductToCart();

        log.info("Added first product to cart");
    }

    /** Step definition for validating the cart badge count */
    @Then("the cart badge should show {string}")
    public void validateCartBadge(String expectedCount) {

        String actualCount = String.valueOf(homePage.getCartCount());

        log.info("Validating cart badge count");

        assertThat(actualCount, equalTo(expectedCount));
    }
}