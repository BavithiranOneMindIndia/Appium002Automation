package ResourcePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendingTextResource {

    WebDriver driver;
    By searchbutton = By.xpath("//android.widget.TextView[@content-desc=\"Search\"]");
    By searchTextValuePlace = By.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.EditText");
    By searchselectGroup = By.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout");
    By sendTextMessage = By.xpath(
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText");
    By sendIcon = By.xpath("//android.widget.ImageButton[@content-desc=\"Send\"]");     
    By navigateBackFormChat = By.xpath("//android.widget.LinearLayout[@content-desc=\"Navigate up\"]/android.widget.ImageView");

    public SendingTextResource(WebDriver driver) {
        this.driver = driver;
    }

    public void Searchbutton(WebDriver driver) {
        driver.findElement(searchbutton).click();
    }

    public void SearchTextValuePlace(WebDriver driver,String groupName) {
        driver.findElement(searchTextValuePlace).clear();
        driver.findElement(searchTextValuePlace).sendKeys(groupName);

    }

    public void SearchselectGroup(WebDriver driver) {
        driver.findElement(searchselectGroup).click();
    }

    public void SendTextMessage(WebDriver driver, String textMessage) {
        driver.findElement(sendTextMessage).sendKeys(textMessage);
    }
    public void SendIcon(WebDriver driver)
    {
        driver.findElement(sendIcon).click();
    }

    public void NavigateBackFormChat(WebDriver driver)
    {
        driver.findElement(navigateBackFormChat).click();
    }

}
