package steps;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import utils.DriverFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private AppiumDriver driver;
    private LoginPage loginPage;

    @Given("kullanıcı uygulamayı açmış olmalı")
    public void openApp() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
    }

    @When("Giriş Yap butonuna tıklanır")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("kullanıcı login sayfasını görmelidir")
    public void verifyLoginPage() {
        WebElement loginButton = driver.findElement(AppiumBy.id("com.example.app:id/login_button"));
        assertTrue(loginButton.isDisplayed());
    }

    @When("email alanına {string} girilir")
    public void enterEmail(String email) {
        loginPage.enterEmailOrPhone(email);
    }

    @When("şifre alanına {string} girilir")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Then("kullanıcı başarılı bir şekilde giriş yapar ve ana sayfaya yönlendirilir")
    public void verifySuccessfulLogin() {
        WebElement homeElement = driver.findElement(AppiumBy.id("com.example.app:id/home_page_element"));
        assertTrue(homeElement.isDisplayed());
    }

    @Then("kullanıcı {string} hata mesajını alır ve giriş yapamaz")
    public void verifyErrorMessage(String errorMessage) {
        WebElement errorElement = driver.findElement(AppiumBy.id("com.example.app:id/error_message"));
        assertEquals(errorMessage, errorElement.getText());
    }

    @When("telefon numarası alanına {string} girilir")
    public void enterPhoneNumber(String phoneNumber) {
        loginPage.enterEmailOrPhone(phoneNumber);
    }

    @When("Google ile Giriş Yap butonuna tıklanır")
    public void clickGoogleLogin() {
        loginPage.clickGmailLoginButton();
    }

    @When("Facebook ile Giriş Yap butonuna tıklanır")
    public void clickFacebookLogin() {
        loginPage.clickFacebookLoginButton();
    }

    @Then("kullanıcı Google hesap seçim ekranını görmelidir")
    public void verifyGoogleAccountSelection() {
        WebElement googleAccountSelectScreen = driver.findElement(AppiumBy.id("com.google.android.gms:id/account_name"));
        assertTrue(googleAccountSelectScreen.isDisplayed());
    }

    @Then("kullanıcı Facebook giriş ekranını görmelidir")
    public void verifyFacebookLoginScreen() {
        WebElement facebookLoginScreen = driver.findElement(AppiumBy.id("com.facebook.katana:id/login_button"));
        assertTrue(facebookLoginScreen.isDisplayed());
    }
}
