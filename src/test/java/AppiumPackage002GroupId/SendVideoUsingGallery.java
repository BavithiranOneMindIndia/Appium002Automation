package AppiumPackage002GroupId;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import ResourcePackage.SendVideoGalleryResource;

import org.openqa.selenium.remote.RemoteWebDriver;

public class SendVideoUsingGallery {

    public void gallerysendvideo(WebDriver driver, String deviceId, WebDriverWait wait, String selectingVideo,
            String groupName) throws MalformedURLException {

        // Create an object for Desired Capabilitiesdw
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "uiAutomator2");
        capabilities.setCapability("deviceName", deviceId);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.whatsapp.w4b");
        capabilities.setCapability("appActivity", "com.whatsapp.Main");
        capabilities.setCapability("noReset", "true");

        // passing the capabilities
        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, 5);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("thread . sleep interrupted Exception.....");
        }

        SendVideoGalleryResource SendVideoGalleryResource_obj = new SendVideoGalleryResource(driver);

        SendVideoGalleryResource_obj.SearchButtonElement(driver);
        SendVideoGalleryResource_obj.SearchGroupNamePlaceElement(driver, groupName);
        SendVideoGalleryResource_obj.SearchselectGroupElement(driver);
        SendVideoGalleryResource_obj.FileAttachButtonClick(driver);
        SendVideoGalleryResource_obj.GalleryAttachElement(driver);
        SendVideoGalleryResource_obj.GalleryVideoFolderClick(driver);
        SendVideoGalleryResource_obj.VideoSelect(selectingVideo);
        SendVideoGalleryResource_obj.VideoSend(driver);

        driver.quit();
    }

}
