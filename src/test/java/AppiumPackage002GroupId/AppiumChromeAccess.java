package AppiumPackage002GroupId;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import AppiumPackage002GroupId.LoggingFolder.LogGeneratorClass;
import ResourcePackage.ChromeResource;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumChromeAccess {

    String AppURL = "https://stagewhatsappconnect.blob.core.windows.net/whatstemplateappfiles/sample-video.mp4";
    String destinationFile = "image.jpg";
    String downloadFileName;
    String Appium_Node_Path = "C:/Users/bavithiran/Downloads/Appium-windows-1.18.3/Appium.exe";
    String Appium_JS_Path = "C:/Users/bavithiran/Downloads/Appium-windows-1.18.3/resources/app/node_modules/appium/bin/appium.js";

    AppiumDriverLocalService appiumService;
    String appiumServiceUrl;
    private AppiumServiceBuilder builder;
    // private AppiumDriverLocalService service;

    LogGeneratorClass LogGeneratorClass_obj = new LogGeneratorClass();

    public void chromeCapabilities(String deviceId, WebDriver driver, WebDriverWait wait, String blobUrl)
            throws IOException, InterruptedException, URISyntaxException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "uiAutomator2");
        capabilities.setCapability("deviceName", deviceId);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "org.chromium.chrome.browser.document.ChromeLauncherActivity");
        capabilities.setCapability("noReset", "true");

        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, 20);

        // AndroidDriver driver1 = new AndroidDriver(new
        // URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        Thread.sleep(3000);

        AppiumChromeAccess chrome_obj = new AppiumChromeAccess();

        // ChromeResource_obj.clicksearchplace(driver, blobUrl);
        blobUrl = blobUrl.replace(" ", "%20");

        System.out.println(blobUrl);
        driver.get(blobUrl);

        Thread.sleep(4000);

        // SaveImageFromBlobUrl SaveImageFromBlobUrl_obj = new SaveImageFromBlobUrl();
        // SaveImageFromBlobUrl_obj.saveImage(AppURL, destinationFile);

        chrome_obj.accessingChromeElements(driver);
        // chrome_obj.downloadingImageName(driver);
        chrome_obj.chromeDrivertearDown(driver);

        // chrome_obj.chromeDrivertearDown(driver);

    }

    public void accessingChromeElements(WebDriver driver) throws InterruptedException {

        ChromeResource ChromeResource_obj = new ChromeResource(driver);
        ChromeResource_obj.chromeSettingClick(driver);
        ChromeResource_obj.downloadIconClick(driver);

    }

    public void downloadingImageName(WebDriver driver) {
        WebElement imageclassName = driver
                .findElement(By.xpath("//android.widget.TextView[@content-desc=\"image 2.png. Open button\"]"));
        // return imageclassName.getAttribute("content-desc");
        String image2Name = imageclassName.getText();
        System.out.println("ImageName before Split" + " " + "=" + " " + image2Name);
        if (image2Name.contains("Open")) {
            String[] ImageTT = image2Name.split(". Open");
            String ImageOrgName = ImageTT[0].trim();
            // System.out.println(deviceId);
            System.out.println("ImageName After split " + " " + "=" + " " + ImageOrgName);
        }

    }

    public void chromeDrivertearDown(WebDriver driver) {
        driver.quit();
    }

}
