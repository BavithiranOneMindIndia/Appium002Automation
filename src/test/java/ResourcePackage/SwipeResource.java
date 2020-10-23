package ResourcePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;

public class SwipeResource {

    // double startPercentage, double endPercentage, double anchorPercentage
    public void horizontalSwipeByPercentage(WebDriver driver) {

        double startPercentage = 160;
        double endPercentage = 720;
        double anchorPercentage = 1274;
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);

        TouchAction TouchAction = new TouchAction((PerformsTouchActions) driver);

         driver.findElement(By.xpath("")).getText();
       
    }
}
