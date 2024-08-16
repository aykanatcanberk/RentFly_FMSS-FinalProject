package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        if (driver == null) {
            try {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", "Android");
                caps.setCapability("deviceName", "sdk_gphone64_x86_64");
                caps.setCapability("automationName", "uiAutomator2");
                caps.setCapability("udid", "emulator-5554");
                caps.setCapability("appium:fastReset", true);
                caps.setCapability("appium:newCommandTimeout", 5);

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("Appium Driver could not be initialized");
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
