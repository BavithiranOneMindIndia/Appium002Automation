package ResetPackage;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import AppiumPackage002GroupId.LoggingFolder.LogGeneratorClass;
import ResourcePackage.FilesByGoogleResource;

public class GalleryAppReset {

    //LogGeneratorClass LogGeneratorClass_obj = new LogGeneratorClass();

    public void FilesByGoogleDeleteProcess(WebDriver driver, String deviceId, WebDriverWait wait)
            throws MalformedURLException, InterruptedException {
        GalleryAppReset GalleryAppReset_obj = new GalleryAppReset();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // to files by Google ....
        capabilities.setCapability("automationName", "uiAutomator2");
        capabilities.setCapability("deviceName", deviceId);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.google.android.apps.nbu.files");
        capabilities.setCapability("appActivity", "com.google.android.apps.nbu.files.home.HomeActivity");
        /// capabilities.setCapability("fullReset", "true");
        capabilities.setCapability("noReset", "true");

        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, 10);

        GalleryAppReset_obj.SetDeleteProcess(driver);

    }

    public void SetDeleteProcess(WebDriver driver) throws InterruptedException {
        FilesByGoogleResource FilesByGoogleResource_obj = new FilesByGoogleResource(driver);

        FilesByGoogleResource_obj.clickBrowse(driver);
        Thread.sleep(1000);
        try {
            FilesByGoogleResource_obj.clickDownloadsIcon(driver);
            Thread.sleep(1000);
            FilesByGoogleResource_obj.clickSettingsOption(driver);
            Thread.sleep(1000);
            FilesByGoogleResource_obj.clickSelectallInSettings(driver);
            Thread.sleep(1000);
            FilesByGoogleResource_obj.clickDeleteMainIcon(driver);
            Thread.sleep(1000);
            FilesByGoogleResource_obj.clickDeleteButton(driver);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("In files by gooleApp downloads folder is empty...");
            driver.quit();
        }
        driver.quit();

    }

}
