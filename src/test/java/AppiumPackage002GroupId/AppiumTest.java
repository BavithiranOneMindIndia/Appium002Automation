package AppiumPackage002GroupId;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SuiteRunState;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AppiumPackage002GroupId.LoggingFolder.LogGeneratorClass;
import ResetPackage.GalleryAppReset;
import ResetPackage.ServerLanuch;

/**
 * Unit test for simple App.
 */
public class AppiumTest extends LogGeneratorClass {
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
    static Logger logger = Logger.getLogger(AppiumTest.class);
    // Hashtable<String, Integer> hashtableFileType = new Hashtable<String,
    // Integer>();

    LogGeneratorClass LogGeneratorClass_obj = new LogGeneratorClass();

    List<GroupTemplateViewModel> ListOfGroups;
    List<TemplateViewModel> listOfTemplates;

    @BeforeTest
    public void setup() throws IOException, InterruptedException, URISyntaxException {

        AppiumTest AppiumTest_obj = new AppiumTest();
        PhoneNumber = AppiumTest_obj.OptionPanel();
        System.out.println("Phonenumber Enter Value " + " " + "=" + " " + PhoneNumber);

        LogGeneratorClass_obj.GenerateLog("Phonenumber Enter Value " + " " + "=" + " " + PhoneNumber);

        ApiAccessing ApiAccessing_obj = new ApiAccessing();

        String clusterUrl = BaseUrl + "/GroupAdmin/getClusterId/" + PhoneNumber;
        String cluserId = ApiAccessing_obj.apiGetProcessing(clusterUrl);
        System.out.println("ClusterId" + " = " + cluserId);
        LogGeneratorClass_obj.GenerateLog("ClusterId" + " = " + cluserId);

        // https://stage-whatsappconnect-webapi.azurewebsites.net/Template/getByMobileNumber/9710565667
        String templateUrl = BaseUrl + "/Template/getByMobileNumber/" + PhoneNumber;
        String templateString = ApiAccessing_obj.apiGetProcessing(templateUrl);
        System.out.println("templateString" + " = " + templateString);
        LogGeneratorClass_obj.GenerateLog("templateString" + " = " + templateString);

        String getGroups = BaseUrl + "/Group/getGroupsByMobileNumber/" + PhoneNumber;
        String getGroupString = ApiAccessing_obj.apiGetProcessing(getGroups);
        System.out.println("getGroups" + " = " + getGroups);
        LogGeneratorClass_obj.GenerateLog("getGroups" + " = " + getGroups);

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

        // ServerLanuch ServerLanuch_object = new ServerLanuch();
        // ServerLanuch_object.startServer();
        // AppiumTest_obj.clearAFolder();
        GalleryAppReset GalleryAppReset_Object = new GalleryAppReset();
        // Deleting files by Google -> downloads -> delete all the files in Download
        GalleryAppReset_Object.FilesByGoogleDeleteProcess(driver, deviceId, wait);
        // Accessing Chrome process ....
        AppiumChromeAccess AppiumChromeAccess_obj = new AppiumChromeAccess();

        // for (int j = allFilesOfTemplate.size(); j > 0; j--) {

        DownloadContents(AppiumChromeAccess_obj);
        Thread.sleep(2000);

    }

    private void DownloadContents(AppiumChromeAccess AppiumChromeAccess_obj)
            throws IOException, InterruptedException, URISyntaxException {
        // Content downloading loop ......

        int videoId = 1;
        int photoId = 1;

        for (int i = allFilesOfFileSource.size(); i > 0; i--) {
            file = allFilesOfFileSource.get(i - 1);
            // Image file type
            if (file.fileType == 0) {
                // String file12 = file.id;
                hashtableContentLable.put(file.id,
                        "(//android.widget.ImageView[@content-desc=\"Photo\"])[" + photoId + "]");
                hashtableBlobUrl.put(file.id, file.blobUrl);
                System.out.println(hashtableBlobUrl.get(file.id).toString());
                LogGeneratorClass_obj.GenerateLog(hashtableBlobUrl.get(file.id).toString());

                AppiumChromeAccess_obj.chromeCapabilities(deviceId, driver, wait, hashtableBlobUrl.get(file.id));
                // Video file type
            } else if (file.fileType == 1) {
                hashtableContentLable.put(file.id,
                        "(//android.widget.ImageView[@content-desc=\"Video\"])[" + videoId + "]");
                hashtableBlobUrl.put(file.id, file.blobUrl);
                System.out.println(hashtableContentLable.get(file.id));
                LogGeneratorClass_obj.GenerateLog(hashtableContentLable.get(file.id));

                // to Access Chrome to download content using blobUrl , this is for Video...
                AppiumChromeAccess_obj.chromeCapabilities(deviceId, driver, wait, hashtableBlobUrl.get(file.id));
                videoId = videoId + 1;
            } else if (file.fileType == 4) {
                System.out.println("Audio file downloading");
                hashtableBlobUrl.put(file.id, file.blobUrl);
                System.out.println(hashtableContentLable.get(file.id));
                LogGeneratorClass_obj.GenerateLog(hashtableContentLable.get(file.id));
                AppiumChromeAccess_obj.chromeCapabilities(deviceId, driver, wait, hashtableBlobUrl.get(file.id));
            }

        }
        LogGeneratorClass_obj.GenerateLog("DownloadContents is successfull");
    }

    // accessing the Whatsapp after downloading blobUrl contents
    @Test
    public void testSearchAppium() throws IOException, InterruptedException {

        SendContentMessage SendContentMessage_obj = new SendContentMessage();
        SendVideoUsingGallery SendVideoUsingGallery = new SendVideoUsingGallery();

        SendContentMessage_obj.SendContentMessageProcess(driver, deviceId, wait, listOfTemplates, ListOfGroups,
                hashtableContentLable, PhoneNumber);

        System.out.println("Content sends successfully sent .......");
        LogGeneratorClass_obj.GenerateLog("Content sends successfully sent .......");
        /// driver.quit();

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

    public void runtimeCommandAccess() throws IOException, InterruptedException {
        Runtime rt = Runtime.getRuntime();
        // String[] commands = { "adb devices" };
        // Process proc = new ProcessBuilder("adb devices", "myArg").start();
        Process proc = rt.exec("adb devices");

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

        BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

        Thread.sleep(2000);
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
            System.out.println("deviceId accessed value " + " " + "=" + " " + deviceId);
            LogGeneratorClass_obj.GenerateLog("deviceId accessed value " + " " + "=" + " " + deviceId);
        }

        Thread.sleep(2000);

        // Read any errors from the attempted command
        System.out.println("Here is the standard error of the command (if any):\n");
        LogGeneratorClass_obj.GenerateLog("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            System.out.println(s);
            LogGeneratorClass_obj.GenerateLog(s);
        }
    }

    public void clearAFolder() throws IOException {
        String adbCommand = "adb shell rm -f /Downloads/gupshup.png";

        Runtime.getRuntime().exec(adbCommand);
        // printResults(process);

    }
}
