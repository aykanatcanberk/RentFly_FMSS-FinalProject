package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    private AppiumDriver driver;

    private WebElement nameField;
    private WebElement surnameField;
    private WebElement emailField;
    private WebElement passwordField;
    private WebElement phoneField;
    private WebElement signUpButton;

    public SignUpPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        nameField = driver.findElement(AppiumBy.id("com.rentfly.app:id/name"));
        surnameField = driver.findElement(AppiumBy.id("com.rentfly.app:id/surname"));
        emailField = driver.findElement(AppiumBy.id("com.rentfly.app:id/email"));
        passwordField = driver.findElement(AppiumBy.id("com.rentfly.app:id/password"));
        phoneField = driver.findElement(AppiumBy.id("com.rentfly.app:id/phone"));
        signUpButton = driver.findElement(AppiumBy.id("com.rentfly.app:id/sign_up_button"));
    }

    public boolean isSignUpPageDisplayed() {
        return nameField.isDisplayed() &&
                surnameField.isDisplayed() &&
                emailField.isDisplayed() &&
                passwordField.isDisplayed() &&
                phoneField.isDisplayed();
    }

    public void enterName(String name) {
        nameField.sendKeys(name);
    }

    public void enterSurname(String surname) {
        surnameField.sendKeys(surname);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void enterPhone(String phone) {
        phoneField.sendKeys(phone);
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public String getErrorMessage() {
        WebElement errorMessage = driver.findElement(AppiumBy.id("com.rentfly.app:id/error_message"));
        return errorMessage.getText();
    }

    public boolean isHomePageDisplayed() {
        WebElement homePageElement = driver.findElement(AppiumBy.id("com.rentfly.app:id/home_page_element"));
        return homePageElement.isDisplayed();
    }
}
