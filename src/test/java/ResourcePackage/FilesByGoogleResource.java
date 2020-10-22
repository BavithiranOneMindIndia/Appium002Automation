package ResourcePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilesByGoogleResource {

    WebDriver driver;
    By clickBrowse = By.xpath("//android.widget.FrameLayout[@content-desc=\"Browse\"]/android.widget.ImageView");
    By clickDownloadsIcon = By.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView");

    By clickSettingsOption = By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]");
    By clickSelectallInSettings = By.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
    By clickDeleteMainIcon = By.xpath("//android.widget.TextView[@content-desc=\"Delete\"]");
    By clickDeleteButton = By.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.Button[2]");

    public FilesByGoogleResource(WebDriver driver) {
        this.driver = driver;

    }

    public void clickBrowse(WebDriver driver) {
        driver.findElement(clickBrowse).click();
    }

    public void clickDownloadsIcon(WebDriver driver) {
        driver.findElement(clickDownloadsIcon).click();
    }

    public void clickSettingsOption(WebDriver driver) {
        driver.findElement(clickSettingsOption).click();
    }

    public void clickSelectallInSettings(WebDriver driver) {
        driver.findElement(clickSelectallInSettings).click();
    }

    public void clickDeleteMainIcon(WebDriver driver) {
        driver.findElement(clickDeleteMainIcon).click();
    }

    public void clickDeleteButton(WebDriver driver) {
        driver.findElement(clickDeleteButton).click();
    }
}
