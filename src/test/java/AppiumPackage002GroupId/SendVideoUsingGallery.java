package AppiumPackage002GroupId;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.remote.RemoteWebDriver;

public class SendVideoUsingGallery {

    public void gallerysendvideo(WebDriver driver, String deviceId, WebDriverWait wait, String selectingVideo)
            throws MalformedURLException {

        
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
        // attach button click ....
        WebElement fileAttachButtonClick = driver
                .findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Attach\"]"));
        fileAttachButtonClick.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }

        // gallery attachment click....
        WebElement galleryAttachElement = driver.findElement(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.ImageButton"));
        galleryAttachElement.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }

        WebElement galleryVideoFolderClick = driver.findElement(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.ImageView"));
        galleryVideoFolderClick.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");

        }

        // Image select
        WebElement videoSelect = driver
                .findElement(By.xpath(selectingVideo));
        videoSelect.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");

        }

        WebElement videoSend = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Send\"]"));
        videoSend.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");

        }

        driver.quit();
    }

}
