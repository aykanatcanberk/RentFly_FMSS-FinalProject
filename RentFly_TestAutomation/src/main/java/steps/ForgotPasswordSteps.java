package steps;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ForgotPasswordPage;
import utils.DriverFactory;

import static org.junit.Assert.assertTrue;

public class ForgotPasswordSteps {

    private AppiumDriver driver;
    private ForgotPasswordPage forgotPasswordPage;

    public ForgotPasswordSteps() {
        this.driver = DriverFactory.getDriver();
        this.forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    @Given("user is on the login page")
    public void navigateToLoginPage() {

        driver.findElement(AppiumBy.id("com.example.app:id/login_button")).click();
    }

    @When("user clicks on the Forgot Password link")
    public void clickForgotPasswordLink() {
        forgotPasswordPage.clickForgotPasswordLink();
    }

    @When("user enters {string} as the email")
    public void enterEmail(String email) {
        forgotPasswordPage.enterEmail(email);
    }

    @When("user enters {string} as the phone number")
    public void enterPhone(String phone) {
        forgotPasswordPage.enterPhone(phone);
    }

    @When("user clicks the Submit button")
    public void clickSubmitButton() {
        forgotPasswordPage.clickSubmitButton();
    }

    @Then("user should receive a password reset link")
    public void verifyResetLinkSent() {
        assertTrue(forgotPasswordPage.isResetLinkSent());
    }
}
