package ResourcePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

public class SendImageGalleryResource {

    WebDriver driver;
    By searchButton = By.xpath("//android.widget.TextView[@content-desc=\"Search\"]");
    By searchTextValuePlace = By.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.EditText");
    By searchselectGroup = By.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout");
    By fileAttachButtonClick = By.xpath("//android.widget.ImageButton[@content-desc=\"Attach\"]");
    By galleryAttachElement = By.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.ImageButton");
    By galleryImageFolderClick = By.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.ImageView");
    By ImageSendClick = By.xpath("//android.widget.ImageButton[@content-desc=\"Send\"]");
    By longPressOkButton = By.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView");
    By VideoAccessTextLableClick = By.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText");

    public SendImageGalleryResource(WebDriver driver) {
        this.driver = driver;
    }

    public void searchButton(WebDriver driver) throws InterruptedException {
        driver.findElement(searchButton).click();
        Thread.sleep(1000);
    }

    public void searchTextValuePlace(WebDriver driver, String Groupname) throws InterruptedException {
        driver.findElement(searchTextValuePlace).sendKeys(Groupname);
        Thread.sleep(1000);
    }

    public void searchselectGroup(WebDriver driver) throws InterruptedException {
        driver.findElement(searchselectGroup).click();
        Thread.sleep(1000);
    }

    public void fileAttachButtonClick(WebDriver driver) throws InterruptedException {
        driver.findElement(fileAttachButtonClick).click();
        Thread.sleep(2000);
    }

    public void galleryAttachElement(WebDriver driver) throws InterruptedException {
        driver.findElement(galleryAttachElement).click();
        Thread.sleep(2000);
    }

    public void galleryImageFolderClick(WebDriver driver) throws InterruptedException {
        driver.findElement(galleryImageFolderClick).click();
        Thread.sleep(2000);
    }

    public void ImageSelect(String selectingImage, WebDriver driver) {
        By ImageSelect = By.xpath(selectingImage);
        driver.findElement(ImageSelect).click();

    }

    public void LongPressImageSelect(String selectingImage, WebDriver driver) {
        By ImageSelect = By.xpath(selectingImage);
        WebElement LongPress = driver.findElement(ImageSelect);

        TouchActions action = new TouchActions(driver);
        action.longPress(LongPress);
        action.perform();
    }

    public void ImageSendClick(WebDriver driver) throws InterruptedException {
        driver.findElement(ImageSendClick).click();
        Thread.sleep(2000);
    }

    public void LongPressOkButton(WebDriver driver) {
        driver.findElement(longPressOkButton).click();
    }

    public void videoAccessTextLableClick(WebDriver driver) {
        driver.findElement(VideoAccessTextLableClick).click();
    }

}
