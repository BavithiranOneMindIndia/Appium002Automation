package ResourcePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendVideoGalleryResource {
    private WebDriver driver;
    By searchButton = By.xpath("//android.widget.TextView[@content-desc=\"Search\"]");
    By searchTextValuePlace = By.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget"
                    + ".FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget"
                    + ".FrameLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget"
                    + ".HorizontalScrollView/android.widget.LinearLayout/android.widget.EditText");
    By searchselectGroupElement = By
            .xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget"
                    + ".FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget"
                    + ".FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout");
    By fileAttachButtonClick = By.xpath("//android.widget.ImageButton[@content-desc=\"Attach\"]");
    By galleryAttachElement = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget"
            + ".FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget"
            + ".LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.ImageButton");
    By galleryVideoFolderClick = By.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view"
                    + ".ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview"
                    + ".widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.ImageView");
    By videoSelect = By.xpath("");
    By videoSend = By.xpath("//android.widget.ImageButton[@content-desc=\"Send\"]");
    By longPressOkButton = By.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.TextView");

    public SendVideoGalleryResource(WebDriver driver) {
        this.driver = driver;
    }

    public void SearchButtonElement(WebDriver driver) {
        driver.findElement(searchButton).click();
    }

    public void SearchGroupNamePlaceElement(WebDriver driver, String groupName) {
        driver.findElement(searchTextValuePlace).sendKeys(groupName);
    }

    public void SearchselectGroupElement(WebDriver driver) {
        driver.findElement(searchselectGroupElement).click();
    }

    public void FileAttachButtonClick(WebDriver driver) {
        driver.findElement(fileAttachButtonClick).click();
    }

    public void GalleryAttachElement(WebDriver driver) {
        driver.findElement(galleryAttachElement).click();
    }

    public void GalleryVideoFolderClick(WebDriver driver) {
        driver.findElement(galleryVideoFolderClick).click();
    }

    public void VideoSelect(String selectingVideo) {
        By ImageSelect = By.xpath(selectingVideo);
        driver.findElement(ImageSelect).click();
    }

    public void VideoSend(WebDriver driver)
    {
        driver.findElement(videoSend).click();
    }

    public void LongPressOkButton() {
        driver.findElement(longPressOkButton).click();
    }

}
