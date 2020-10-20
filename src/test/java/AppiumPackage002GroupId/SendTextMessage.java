package AppiumPackage002GroupId;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ResourcePackage.SendImageGalleryResource;
import ResourcePackage.SendVideoGalleryResource;
import ResourcePackage.SendingTextResource;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.List;

public class SendTextMessage {

    public void SendTextMessageProcess(WebDriver driver, String deviceId, WebDriverWait wait,
            List<TemplateViewModel> listOfTemplates, List<GroupTemplateViewModel> ListOfGroups,
            Hashtable<String, String> hashtableContentLable) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("automationName", "uiAutomator2");
        capabilities.setCapability("deviceName", deviceId);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.whatsapp.w4b");
        capabilities.setCapability("appActivity", "com.whatsapp.Main");
        capabilities.setCapability("noReset", "true");

        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, 5);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example
            // InterruptedException) occurs
            System.out.println("thread . sleep interrupted Exception.....");
        }

        SendingTextResource SendingTextResource_obj = new SendingTextResource(driver);
        SendImageGalleryResource SendImageGalleryResource_obj = new SendImageGalleryResource(driver);
        SendVideoGalleryResource SendVideoGalleryResource_obj = new SendVideoGalleryResource(driver);

        SendingTextResource_obj.Searchbutton(driver);
        Thread.sleep(2000);

        for (GroupTemplateViewModel groupModel : ListOfGroups) {

            SendingTextResource_obj.SearchTextValuePlace(driver, groupModel.name);
            Thread.sleep(2000);
            SendingTextResource_obj.SearchselectGroup(driver);
            Thread.sleep(2000);

            for (int templateId : groupModel.templates) {

                TemplateViewModel templateModel = GetTemplateById(listOfTemplates, templateId);

                if (templateModel.messageType == 0) {
                    SendingTextResource_obj.SendTextMessage(driver, templateModel.text);
                    Thread.sleep(2000);

                    SendingTextResource_obj.SendIcon(driver);
                    Thread.sleep(2000);
                  

                } else {

                    SendImageGalleryResource_obj.fileAttachButtonClick(driver);
                    Thread.sleep(1000);
                    SendImageGalleryResource_obj.galleryAttachElement(driver);
                    Thread.sleep(1000);
                    SendImageGalleryResource_obj.galleryImageFolderClick(driver);
                    Thread.sleep(1000);
                    for (FileSourceViewModel file : templateModel.fileSourceViewModels) {
                        SendImageGalleryResource_obj.ImageSelect(hashtableContentLable.get(file.id), driver);
                        Thread.sleep(1000);
                    }

                    SendingTextResource_obj.SendTextMessage(driver, templateModel.text);

                }

            }
            SendingTextResource_obj.NavigateBackFormChat(driver);
            Thread.sleep(1000);
        }

    }

    private TemplateViewModel GetTemplateById(List<TemplateViewModel> listOfTemplates, int id) {

        for (TemplateViewModel temp : listOfTemplates) {

            if (temp.id == id) {
                return temp;
            }
        }
        return null;
    }

}
