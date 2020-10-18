package AppiumPackage002GroupId;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.Style;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppiumTest {
    WebDriver driver;
    WebDriverWait wait;
    String deviceId;
    String PhoneNumber;

    @BeforeTest
    public void setup() throws IOException {

        AppiumTest AppiumTest_obj = new AppiumTest();
        PhoneNumber = AppiumTest_obj.OptionPanel();
        System.out.println("Phonenumber Enter Value " + " " + "=" + " " + PhoneNumber);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }

        AppiumTest_obj.runtimeCommandAccess();

        // Access the chrome ....
        AppiumChromeAccess AppiumChromeAccess_obj = new AppiumChromeAccess();
        AppiumChromeAccess_obj.chromeCapabilities(deviceId, driver, wait);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }

        // Create an object for Desired Capabilitiesdw
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

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }

        SendImage SendImage_obj = new SendImage();
        SendImage_obj.sendImageElementaccess(driver);

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
        // http client request using mobile number..

        // Search text value Place
        WebElement SearchTextValuePlace = driver.findElement(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.EditText"));

        SearchTextValuePlace.sendKeys("Second");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }
        // Searched group selecting ....
        WebElement searchselectGroup = driver.findElement(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout"));
        System.out.println("Searched group selecting ....");
        searchselectGroup.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }
        // Typing text in text label.....
        WebElement typeMessageText = driver.findElement(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText"));

        typeMessageText.sendKeys("Image downloaded in mobile  and Appium Automation 2nd test send.....");
        System.out.println("Typing text in text label.....");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }
        // Clicking send icon...
        WebElement sendIconClick = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Send\"]"));
        sendIconClick.click();
        System.out.println("Clicking send icon...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public String OptionPanel() {
        JFrame f;

        f = new JFrame();
        String PhoneNumberValue = JOptionPane.showInputDialog(f, "Enter PhoneNumber");
        return PhoneNumberValue;

    }

    public void runtimeCommandAccess() throws IOException {
        Runtime rt = Runtime.getRuntime();
        // String[] commands = { "adb devices" };
        // Process proc = new ProcessBuilder("adb devices", "myArg").start();
        Process proc = rt.exec("adb devices");

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }
        // Read the output from the command
        System.out.println("Here is the standard output of the command:\n");
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
            if (!s.contains("List of devices attached")) {
                String[] devices = s.split("device");
                deviceId = devices[0].trim();
                // System.out.println(deviceId);
                System.out.println("deviceId accessed value " + " " + "=" + " " + deviceId);

            }

        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }
        // Read any errors from the attempted command
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
    }
}
