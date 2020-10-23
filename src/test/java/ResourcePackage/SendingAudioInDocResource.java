package ResourcePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendingAudioInDocResource {

    private WebDriver driver;
    By fileAttachButtonClick = By.xpath("//android.widget.ImageButton[@content-desc=\"Attach\"]");
    By documentFolderClick = By.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageButton");
    By documentSearchbutton = By.xpath("//android.widget.TextView[@content-desc=\"Search\"]");       
    By documentSearchSendKeys = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText");
    By contentSearchSelect    = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ListView/android.widget.FrameLayout[2]");
    By audioSendIcon          = By.xpath("//android.widget.Button[@content-desc=\"Send\"]");

    public SendingAudioInDocResource(WebDriver driver) {
        this.driver = driver;
    }

    public void FileAttachButtonClick(WebDriver driver) throws InterruptedException {
        driver.findElement(fileAttachButtonClick).click();
        Thread.sleep(2000);
    }

    public void DocumentFolderClick(WebDriver driver) throws InterruptedException {
        driver.findElement(documentFolderClick).click();
        Thread.sleep(1000);
    }

    public void DocumentSearchbutton(WebDriver driver) throws InterruptedException
    {
        driver.findElement(documentSearchbutton).click();
        Thread.sleep(1000);
    }

    public void documentSearchSendKeys(String AudioFileValue , WebDriver driver) throws InterruptedException
    {
        driver.findElement(documentSearchSendKeys).sendKeys(AudioFileValue);
        Thread.sleep(1000);
    }

    public void contentSearchSelect (WebDriver driver) throws InterruptedException
    {
        driver.findElement(contentSearchSelect).click();
        Thread.sleep(1000);
    }

    public void documnentaudioSendIcon(WebDriver driver) throws InterruptedException
    {
        driver.findElement(audioSendIcon).click();
        Thread.sleep(1000);
    }

}
