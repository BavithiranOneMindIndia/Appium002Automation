package ResourcePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChromeResource {

    WebDriver driver;
    By chromeSettingClick = By.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView");
    By downloadIconClick = By.xpath("//android.widget.ImageButton[@content-desc=\"Download\"]");
    By downloadingImageName = By.xpath("//android.widget.TextView[@content-desc=\"image 2.png. Open button\"]");

    public ChromeResource(WebDriver driver) {
        this.driver = driver;

    }

    // To click chrome setting to open the Setting Options...
    public void chromeSettingClick(WebDriver driver) throws InterruptedException {

        driver.findElement(chromeSettingClick).click();
        Thread.sleep(2000);
    }

    // To click download Click icon....
    public void downloadIconClick(WebDriver driver) throws InterruptedException {
        driver.findElement(downloadIconClick).click();
        Thread.sleep(2000);
    }

    // After downloading the Image to get the image name...
    public void downloadingImageName() {
        String image2Name = driver.findElement(downloadingImageName).getText();
        System.out.println("ImageName before Split" + " " + "=" + " " + image2Name);
        if (image2Name.contains("Open")) {
            String[] ImageTT = image2Name.split(". Open");
            String ImageOrgName = ImageTT[0].trim();
            // System.out.println(deviceId);
            System.out.println("ImageName After split " + " " + "=" + " " + ImageOrgName);
        }
    }

    // To quit the chromedriver...
    public void chromeDrivertearDown(WebDriver driver) {
        driver.quit();
    }
}
