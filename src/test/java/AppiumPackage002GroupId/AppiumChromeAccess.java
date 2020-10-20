package AppiumPackage002GroupId;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ResourcePackage.ChromeResource;

public class AppiumChromeAccess {

    String AppURL = "https://stagewhatsappconnect.blob.core.windows.net/whatstemplateappfiles/sample-video.mp4";
    String destinationFile = "image.jpg";
    String downloadFileName;

    public void chromeCapabilities(String deviceId, WebDriver driver, WebDriverWait wait, String blobUrl)
            throws IOException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "uiAutomator2");
        capabilities.setCapability("deviceName", deviceId);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "org.chromium.chrome.browser.document.ChromeLauncherActivity");
        capabilities.setCapability("noReset", "true");
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

        driver.get(blobUrl);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }

        // SaveImageFromBlobUrl SaveImageFromBlobUrl_obj = new SaveImageFromBlobUrl();
        // SaveImageFromBlobUrl_obj.saveImage(AppURL, destinationFile);

        AppiumChromeAccess chrome_obj = new AppiumChromeAccess();
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
