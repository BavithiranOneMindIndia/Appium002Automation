package AppiumPackage002GroupId;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Unit test for simple App.
 */
public class AppTest {
    WebDriver driver;
    WebDriverWait wait;
    String AppURL = "http://www.seleniumeasy.com";

    @BeforeTest
    public void setup() throws MalformedURLException {

        // Create an object for Desired Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Name of mobile web browser to automate. ‘Safari’ for iOS and ‘Chrome’
        // or ‘Browser’ for Android
        // capabilities.setCapability("browserName", "Chrome");

        capabilities.setCapability("automationName", "uiAutomator2");
        // The kind of mobile device or emulator to use - iPad Simulator, iPhone
        // Retina 4-inch, Android Emulator, Galaxy S4 etc
        capabilities.setCapability("deviceName", "d9ec4e2e");

        // Which mobile OS platform to use - iOS, Android, or FirefoxOS
        capabilities.setCapability("platformName", "Android");

        // Java package of the Android app you want to run- Ex:
        // com.example.android.myApp
        // capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appPackage", "com.whatsapp.w4b");

        // Activity name for the Android activity you want to launch from your
        // package
        // capabilities.setCapability("appActivity",
        // "org.chromium.chrome.browser.document.ChromeLauncherActivity");
        capabilities.setCapability("appActivity", "com.whatsapp.Main");

        capabilities.setCapability("noReset", "true");
        // Initialize the driver object with the URL to Appium Server and
        // passing the capabilities
        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void testSearchAppium() {
        // driver.get(AppURL);
        // To click the Search button
        WebElement SearchButton = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Search\"]"));
        SearchButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }
        // Search text value Place
        WebElement SearchTextValuePlace = driver.findElement(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText"));

        SearchTextValuePlace.sendKeys("Second");

        // String homePageTitle = titleElement.getText();
        // Assert.assertEquals(homePageTitle, "Selenium Easy");

        // WebElement searchElement = driver.findElement(By.name("search_block_form"));
        // searchElement.sendKeys("Appium Tutorials");

        // WebElement searchBtnEle = driver.findElement(By.id("edit-submit"));
        // searchBtnEle.click();

        // By byPageTitle = By.id("page-title");
        // wait.until(ExpectedConditions.presenceOfElementLocated(byPageTitle));

        // String searchPageTitle = driver.findElement(byPageTitle).getText();
        // Assert.assertEquals(searchPageTitle, "Search");
    }

    @AfterTest
    public void tearDown() {
        // driver.quit();
    }
}
