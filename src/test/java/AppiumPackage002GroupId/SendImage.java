package AppiumPackage002GroupId;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendImage {

    public void sendImageElementaccess(WebDriver driver) {

        // driver.get(AppURL);
        // To click the Search button
        WebElement SearchButton = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Search\"]"));
        SearchButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }
        // http client request using mobile number..

        // Search text value Place
        WebElement SearchTextValuePlace = driver.findElement(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.EditText"));

        SearchTextValuePlace.sendKeys("Second");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }
        // Searched group selecting ....
        WebElement searchselectGroup = driver.findElement(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout"));
        System.out.println("Searched group selecting ....");
        searchselectGroup.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }

        // attach button click ....
        WebElement fileAttachButtonClick = driver
                .findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Attach\"]"));
        fileAttachButtonClick.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }
        // document click .......
        WebElement documentlick = driver.findElement(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ImageButton"));
        documentlick.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }
        // search button Click .....
        WebElement searchbuttonClick = driver
                .findElement(By.xpath("//android.widget.TextView[@content-desc=\"Search\"]"));
        searchbuttonClick.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }
        // sendleys for searching ...
        WebElement accessSeacrhLabletoSendKeys = driver.findElement(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText"));
        accessSeacrhLabletoSendKeys.sendKeys("image 2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }

        WebElement imageSelect = driver.findElement(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ListView/android.widget.FrameLayout[2]/android.widget.LinearLayout"));
        imageSelect.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }

        WebElement imageSelecttoSend = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Send\"]"));
        imageSelecttoSend.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }

        driver.quit();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }

    }

    public void backbutton(WebDriver driver)
    {
        WebElement backClick = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Navigate up\"]/android.widget.ImageView"));
        backClick.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }
    }
}
