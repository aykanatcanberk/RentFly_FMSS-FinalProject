package steps;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignUpPage;
import utils.DriverFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SignUpSteps {

    private AppiumDriver driver;
    private SignUpPage signUpPage;

    public SignUpSteps() {
        this.driver = DriverFactory.getDriver();
        this.signUpPage = new SignUpPage(driver);
    }

    @Given("user navigates to Sign Up page")
    public void navigateToSignUpPage() {
        driver.findElement(AppiumBy.id("com.example.app:id/sign_up_button")).click();
    }

    @Then("user should see the Sign Up page with all required fields")
    public void verifySignUpPage() {
        assertTrue(signUpPage.isSignUpPageDisplayed());
    }

    @When("user enters {string} as first name")
    public void enterFirstName(String firstName) {
        signUpPage.enterName(firstName);
    }

    @When("user enters {string} as last name")
    public void enterLastName(String lastName) {
        signUpPage.enterSurname(lastName);
    }

    @When("user enters {string} as email")
    public void enterEmail(String email) {
        signUpPage.enterEmail(email);
    }

    @When("user enters {string} as password")
    public void enterPassword(String password) {
        signUpPage.enterPassword(password);
    }

    @When("user enters {string} as phone")
    public void enterPhone(String phone) {
        signUpPage.enterPhone(phone);
    }

    @When("user clicks the Sign Up button")
    public void clickSignUpButton() {
        signUpPage.clickSignUpButton();
    }

    @Then("user should be redirected to the homepage")
    public void verifyHomePage() {
        assertTrue(signUpPage.isHomePageDisplayed());
    }

    @Then("user should see the message {string}")
    public void verifyErrorMessage(String expectedMessage) {
        assertEquals(expectedMessage, signUpPage.getErrorMessage());
    }
}
