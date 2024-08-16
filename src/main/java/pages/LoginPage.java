package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private AppiumDriver driver;

    private WebElement emailOrPhoneTextbox;
    private WebElement passwordTextbox;
    private WebElement loginButton;
    private WebElement facebookLoginButton;
    private WebElement gmailLoginButton;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        emailOrPhoneTextbox = driver.findElement(AppiumBy.id("com.rentfly.app:id/email_or_phone"));
        passwordTextbox = driver.findElement(AppiumBy.id("com.rentfly.app:id/password"));
        loginButton = driver.findElement(AppiumBy.id("com.rentfly.app:id/login_button"));
        facebookLoginButton = driver.findElement(AppiumBy.id("com.rentfly.app:id/facebook_login_button"));
        gmailLoginButton = driver.findElement(AppiumBy.id("com.rentfly.app:id/gmail_login_button"));
    }

    public void enterEmailOrPhone(String emailOrPhone) {
        emailOrPhoneTextbox.sendKeys(emailOrPhone);
    }

    public void enterPassword(String password) {
        passwordTextbox.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickFacebookLoginButton() {
        facebookLoginButton.click();
    }

    public void clickGmailLoginButton() {
        gmailLoginButton.click();
    }
}
