package AppiumPackage002GroupId;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.Style;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.service.local.AppiumDriverLocalService;

/**
 * Unit test for simple App.
 */
public class AppiumTest {
    WebDriver driver;
    WebDriverWait wait;
    String deviceId;
    String PhoneNumber;
    FileSourceViewModel file;
    List<FileSourceViewModel> allFilesOfFileSource = new ArrayList<FileSourceViewModel>();
    List<TemplateViewModel> allFilesOfTemplate = new ArrayList<TemplateViewModel>();

    String BaseUrl = "https://stage-whatsappconnect-webapi.azurewebsites.net";
    Hashtable<String, String> hashtableTypeValue = new Hashtable<String, String>();
    Hashtable<String, String> hashtableBlobUrl = new Hashtable<String, String>();
    Hashtable<String, Integer> hashtableFileType = new Hashtable<String, Integer>();

    @BeforeTest
    public void setup() throws IOException {

        AppiumTest AppiumTest_obj = new AppiumTest();
        PhoneNumber = AppiumTest_obj.OptionPanel();
        System.out.println("Phonenumber Enter Value " + " " + "=" + " " + PhoneNumber);

        ApiAccessing ApiAccessing_obj = new ApiAccessing();

        // GroupAdmin/getClusterId/9710565667

        String clusterUrl = BaseUrl + "/GroupAdmin/getClusterId/" + PhoneNumber;
        String cluserId = ApiAccessing_obj.apiGetProcessing(clusterUrl);
        // https://stage-whatsappconnect-webapi.azurewebsites.net/Template/getByMobileNumber/9710565667

        String templateUrl = BaseUrl + "/Template/getByMobileNumber/" + PhoneNumber;
        String templateString = ApiAccessing_obj.apiGetProcessing(templateUrl);

        Gson gson = new Gson();
        List<TemplateViewModel> listOfTemplates = gson.fromJson(templateString,
                new TypeToken<List<TemplateViewModel>>() {
                }.getType());

        for (TemplateViewModel templateViewModel : listOfTemplates) {

            allFilesOfTemplate.add(templateViewModel);
            for (FileSourceViewModel filesoruce : templateViewModel.fileSourceViewModels) {
                allFilesOfFileSource.add(filesoruce);
            }
        }

        AppiumChromeAccess AppiumChromeAccess_obj = new AppiumChromeAccess();

        // for (int j = allFilesOfTemplate.size(); j > 0; j--) {

        for (int i = allFilesOfFileSource.size(); i > 0; i--) {
            file = allFilesOfFileSource.get(i - 1);
            if (file.fileType == 0) {
                // String file12 = file.id;
                hashtableTypeValue.put(file.id, "(//android.widget.ImageView[@content-desc=\"Photo\"])[" + i + "]");
                hashtableBlobUrl.put(file.id, file.blobUrl);
                hashtableFileType.put(file.id, file.fileType);
                System.out.println(hashtableTypeValue.get(file.id));
                // to Access Chrome to download content using blobUrl , this is for Image...
                AppiumChromeAccess_obj.chromeCapabilities(deviceId, driver, wait, hashtableBlobUrl.get(file.id));
            } else if (file.fileType == 1) {
                hashtableTypeValue.put(file.id, "(//android.widget.ImageView[@content-desc=\"Video\"])[" + i + "]");
                hashtableBlobUrl.put(file.id, file.blobUrl);
                hashtableFileType.put(file.id, file.fileType);
                System.out.println(hashtableTypeValue.get(file.id));
                // to Access Chrome to download content using blobUrl , this is for Video...
                AppiumChromeAccess_obj.chromeCapabilities(deviceId, driver, wait, hashtableBlobUrl.get(file.id));
            }

        }
        for (int x = hashtableFileType.size(); x > 0; x--) {
            // this is for Image ..
            if (hashtableFileType.get(file.id) == 0) {
                SendImageUsingGallery SendImageUsingGallery_obj = new SendImageUsingGallery();
                SendImageUsingGallery_obj.gallerysendimage(driver,  deviceId,  wait ,  hashtableTypeValue.get(file.id));
            }
            // this is for video..
            else if (hashtableFileType.get(file.id) == 1) {
                SendVideoUsingGallery SendVideoUsingGallery_obj = new SendVideoUsingGallery();
                SendVideoUsingGallery_obj.gallerysendvideo(driver,  deviceId,  wait ,  hashtableTypeValue.get(file.id));
            }

        }

        // }

        try

        {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }

        // Appium driver Local service .........
        // AppiumDriverLocalService service =
        // AppiumDriverLocalService.buildDefaultService();
        // service.start();

        // Devices Accessing
        AppiumTest_obj.runtimeCommandAccess();

        // Accessing chrome to load Url and download the Image/Video/Audio...
        // AppiumChromeAccess AppiumChromeAccess_obj = new AppiumChromeAccess();
        // AppiumChromeAccess_obj.chromeCapabilities(deviceId, driver, wait);
        // try {
        // } catch (InterruptedException e) {
        // this part is executed when an exception (in this example
        // InterruptedException) occurs
        // System.out.println("thread . sleep interrupted Exception.....");
        // }
        // AppiumChromeAccess_obj.downloadingImageName(driver);
        // System.out.println(downloadValue);


        // sending video using Whatsapp gallery.....
        //SendVideoUsingGallery SendVideoUsingGallery_obj = new SendVideoUsingGallery();
        //SendVideoUsingGallery_obj.gallerysendvideo(driver);

        // sending image using Whatsapp gallery....
        //SendImageUsingGallery SendImageUsingGallery_obj = new SendImageUsingGallery();
        //SendImageUsingGallery_obj.gallerysendimage(driver);

        // sending image using whatsapp documents ......
        //SendImage SendImage_obj = new SendImage();
        ///SendImage_obj.sendImageElementaccess(driver);

       // driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

      //  wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void testSearchAppium() {
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
        // Typing text in text label.....
        WebElement typeMessageText = driver.findElement(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText"));

        typeMessageText.sendKeys("Image downloaded in mobile  and Appium Automation 2nd test send.....");
        System.out.println("Typing text in text label.....");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }
        // Clicking send icon...
        WebElement sendIconClick = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Send\"]"));
        sendIconClick.click();
        System.out.println("Clicking send icon...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public String OptionPanel() {
        JFrame f;

        f = new JFrame();
        String PhoneNumberValue = JOptionPane.showInputDialog(f, "Enter PhoneNumber");
        return PhoneNumberValue;

    }

    public void runtimeCommandAccess() throws IOException {
        Runtime rt = Runtime.getRuntime();
        // String[] commands = { "adb devices" };
        // Process proc = new ProcessBuilder("adb devices", "myArg").start();
        Process proc = rt.exec("adb devices");

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }
        // Read the output from the command
        System.out.println("Here is the standard output of the command:\n");
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
            if (!s.contains("List of devices attached")) {
                String[] devices = s.split("device");
                deviceId = devices[0].trim();
                // System.out.println(deviceId);
                System.out.println("deviceId accessed value " + " " + "=" + " " + deviceId);

            }

        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }
        // Read any errors from the attempted command
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
        }
    }
}
