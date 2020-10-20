package AppiumPackage002GroupId;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import ResourcePackage.SendImageGalleryResource;

import org.openqa.selenium.remote.RemoteWebDriver;

public class SendImageUsingGallery {

    public void gallerysendimage(WebDriver driver, String deviceId, WebDriverWait wait, String selectingImage)
            throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("automationName", "uiAutomator2");
        capabilities.setCapability("deviceName", deviceId);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.whatsapp.w4b");
        capabilities.setCapability("appActivity", "com.whatsapp.Main");
        capabilities.setCapability("noReset", "true");

        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, 5);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }

        SendImageGalleryResource SendImageGalleryResource_obj = new SendImageGalleryResource(driver);

        SendImageGalleryResource_obj.searchButton(driver);
        SendImageGalleryResource_obj.searchTextValuePlace(driver, selectingImage);
        SendImageGalleryResource_obj.searchselectGroup(driver);
        SendImageGalleryResource_obj.fileAttachButtonClick(driver);
        SendImageGalleryResource_obj.galleryAttachElement(driver);
        SendImageGalleryResource_obj.galleryImageFolderClick(driver);
        SendImageGalleryResource_obj.ImageSelect(selectingImage, driver);
        SendImageGalleryResource_obj.ImageSendClick(driver);

        driver.quit();
    }

}
