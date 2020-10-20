package AppiumPackage002GroupId;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SuiteRunState;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
    Hashtable<String, String> hashtableContentLable = new Hashtable<String, String>();
    Hashtable<String, String> hashtableBlobUrl = new Hashtable<String, String>();
    // Hashtable<String, Integer> hashtableFileType = new Hashtable<String,
    // Integer>();

    List<GroupTemplateViewModel> ListOfGroups;
    List<TemplateViewModel> listOfTemplates;

    @BeforeTest
    public void setup() throws IOException, InterruptedException {
        AppiumTest AppiumTest_obj = new AppiumTest();
        PhoneNumber = AppiumTest_obj.OptionPanel();
        System.out.println("Phonenumber Enter Value " + " " + "=" + " " + PhoneNumber);

        ApiAccessing ApiAccessing_obj = new ApiAccessing();

        String clusterUrl = BaseUrl + "/GroupAdmin/getClusterId/" + PhoneNumber;
        String cluserId = ApiAccessing_obj.apiGetProcessing(clusterUrl);
        System.out.println("ClusterId" + " = " + cluserId);

        // https://stage-whatsappconnect-webapi.azurewebsites.net/Template/getByMobileNumber/9710565667
        String templateUrl = BaseUrl + "/Template/getByMobileNumber/" + PhoneNumber;
        String templateString = ApiAccessing_obj.apiGetProcessing(templateUrl);
        System.out.println("templateString" + " = " + templateString);

        String getGroups = BaseUrl + "/Group/getGroupsByMobileNumber/" + PhoneNumber;
        String getGroupString = ApiAccessing_obj.apiGetProcessing(getGroups);
        System.out.println("getGroups" + " = " + getGroups);

        Gson gson = new Gson();

        ListOfGroups = gson.fromJson(getGroupString, new TypeToken<List<GroupTemplateViewModel>>() {
        }.getType());

        listOfTemplates = gson.fromJson(templateString, new TypeToken<List<TemplateViewModel>>() {
        }.getType());

        for (TemplateViewModel templateViewModel : listOfTemplates) {

            allFilesOfTemplate.add(templateViewModel);
            for (FileSourceViewModel filesoruce : templateViewModel.fileSourceViewModels) {
                allFilesOfFileSource.add(filesoruce);
            }
        }
        // adb Devices Accessing .....
        AppiumTest_obj.runtimeCommandAccess();

        // Accessing Chrome process ....
        AppiumChromeAccess AppiumChromeAccess_obj = new AppiumChromeAccess();

        // for (int j = allFilesOfTemplate.size(); j > 0; j--) {

        // Content downloading loop ......
        for (int i = allFilesOfFileSource.size(); i > 0; i--) {
            file = allFilesOfFileSource.get(i - 1);
            if (file.fileType == 0) {
                // String file12 = file.id;
                hashtableContentLable.put(file.id, "(//android.widget.ImageView[@content-desc=\"Photo\"])[" + i + "]");
                hashtableBlobUrl.put(file.id, file.blobUrl);
                AppiumChromeAccess_obj.chromeCapabilities(deviceId, driver, wait, hashtableBlobUrl.get(file.id));
            } else if (file.fileType == 1) {
                hashtableContentLable.put(file.id, "(//android.widget.ImageView[@content-desc=\"Video\"])[" + i + "]");
                hashtableBlobUrl.put(file.id, file.blobUrl);
                System.out.println(hashtableContentLable.get(file.id));
                // to Access Chrome to download content using blobUrl , this is for Video...
                AppiumChromeAccess_obj.chromeCapabilities(deviceId, driver, wait, hashtableBlobUrl.get(file.id));
            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }

    }

    // accessing the Whatsapp after downloading blobUrl contents
    @Test
    public void testSearchAppium() throws IOException, InterruptedException {

        SendTextMessage SendTextMessage_obj = new SendTextMessage();
        SendVideoUsingGallery SendVideoUsingGallery = new SendVideoUsingGallery();

        SendTextMessage_obj.SendTextMessageProcess(driver, deviceId, wait, listOfTemplates, ListOfGroups,
                hashtableContentLable);
                
        System.out.println("Entering testSearchAppium class .......");

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

            }

        }
        System.out.println("deviceId accessed value " + " " + "=" + " " + deviceId);

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
