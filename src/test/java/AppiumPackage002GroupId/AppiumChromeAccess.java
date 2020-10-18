package AppiumPackage002GroupId;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumChromeAccess {

    String AppURL = "http://www.seleniumeasy.com";

    public void chromeCapabilities(String deviceId, WebDriver driver, WebDriverWait wait) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Name of mobile web browser to automate. ‘Safari’ for iOS and ‘Chrome’
        // or ‘Browser’ for Android
        // capabilities.setCapability("browserName", "Chrome");

        capabilities.setCapability("automationName", "uiAutomator2");
        // The kind of mobile device or emulator to use - iPad Simulator, iPhone
        // Retina 4-inch, Android Emulator, Galaxy S4 etc
        capabilities.setCapability("deviceName", deviceId);

        // Which mobile OS platform to use - iOS, Android, or FirefoxOS
        capabilities.setCapability("platformName", "Android");

        // Java package of the Android app you want to run- Ex:
        // com.example.android.myApp
        // capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appPackage", "com.android.chrome");

        // Activity name for the Android activity you want to launch from your
        // package
        // capabilities.setCapability("appActivity",
        // "org.chromium.chrome.browser.document.ChromeLauncherActivity");
        capabilities.setCapability("appActivity", "org.chromium.chrome.browser.document.ChromeLauncherActivity");

        capabilities.setCapability("noReset", "true");
        // Initialize the driver object with the URL to Appium Server and
        // passing the capabilities
        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        wait = new WebDriverWait(driver, 6);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }

        driver.get(AppURL);

        AppiumChromeAccess chrome_obj = new AppiumChromeAccess();
        chrome_obj.chromeDrivertearDown(driver);

    }

    public void chromeDrivertearDown(WebDriver driver) {
        driver.quit();
    }

}
