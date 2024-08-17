package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

    private AppiumDriver driver;

    private WebElement emailField;
    private WebElement phoneField;
    private WebElement submitButton;
    private WebElement forgotPasswordLink;

    public ForgotPasswordPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        forgotPasswordLink = driver.findElement(AppiumBy.id("com.rentfly.app:id/forgot_password_link"));
        emailField = driver.findElement(AppiumBy.id("com.rentfly.app:id/email"));
        phoneField = driver.findElement(AppiumBy.id("com.rentfly.app:id/phone"));
        submitButton = driver.findElement(AppiumBy.id("com.rentfly.app:id/submit_button"));
    }

    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPhone(String phone) {
        phoneField.sendKeys(phone);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public boolean isResetLinkSent() {
        WebElement confirmationMessage = driver.findElement(AppiumBy.id("com.rentfly.app:id/confirmation_message"));
        return confirmationMessage.isDisplayed();
    }
}
