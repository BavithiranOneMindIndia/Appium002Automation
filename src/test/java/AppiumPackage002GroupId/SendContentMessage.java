package AppiumPackage002GroupId;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ResourcePackage.SendImageGalleryResource;
import ResourcePackage.SendVideoGalleryResource;
import ResourcePackage.SendingAudioInDocResource;
import ResourcePackage.SendingTextResource;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;

public class SendContentMessage {

    AppiumDriverLocalService appiumService;
    String appiumServiceUrl;
    String BaseUrl = "https://stage-whatsappconnect-webapi.azurewebsites.net/Template/updateMessageTracker";

    public void SendContentMessageProcess(WebDriver driver, String deviceId, WebDriverWait wait,
            List<TemplateViewModel> listOfTemplates, List<GroupTemplateViewModel> ListOfGroups,
            Hashtable<String, String> hashtableContentLable, String PhoneNumber)
            throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("automationName", "uiAutomator2");
        capabilities.setCapability("deviceName", deviceId);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.whatsapp");
        capabilities.setCapability("appActivity", "com.whatsapp.Main");
        capabilities.setCapability("noReset", "true");

        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, 15);

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
        SendingAudioInDocResource SendingAudioInDocResource_obj = new SendingAudioInDocResource(driver);
        ApiAccessing ApiAccessing_obj = new ApiAccessing();

        SendingTextResource_obj.Searchbutton(driver);
        Thread.sleep(3000);

        SendContentMessage SendContentMessage_obj = new SendContentMessage();

        for (GroupTemplateViewModel groupModel : ListOfGroups) {

            try {
                SendingTextResource_obj.SearchTextValuePlace(driver, groupModel.name);
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println(e);
                SendingTextResource_obj.Searchbutton(driver);
                Thread.sleep(3000);
                SendingTextResource_obj.SearchTextValuePlace(driver, groupModel.name);
                Thread.sleep(3000);
            }

            SendingTextResource_obj.SearchselectGroup(driver);
            Thread.sleep(3000);

            for (int templateId : groupModel.templates) {

                TemplateViewModel templateModel = GetTemplateById(listOfTemplates, templateId);
                // Text message send ...
                if (templateModel.messageType == 0) {
                    SendingTextResource_obj.SendTextMessage(driver, templateModel.text);
                    Thread.sleep(2000);

                    SendingTextResource_obj.SendIcon(driver);
                    Thread.sleep(2000);
                    String payloadJsonString = SendContentMessage_obj.jsonObject(groupModel.id, templateId,
                            templateModel.clusterId, PhoneNumber);
                    System.out.println(payloadJsonString);
                    ApiAccessing_obj.apiPostProcessing(BaseUrl, payloadJsonString);

                    // SendingTextResource_obj.NavigateBackFormChat(driver);
                    // Thread.sleep(1000);
                    // Image and video send....
                }

                else {

                    for (FileSourceViewModel fileSourceMain : templateModel.fileSourceViewModels) {
                        // Audio File send ....
                        if (fileSourceMain.fileType == 4) {

                            SendingAudioInDocResource_obj.FileAttachButtonClick(driver);
                            Thread.sleep(1000);
                            SendingAudioInDocResource_obj.DocumentFolderClick(driver);
                            Thread.sleep(1000);
                            SendingAudioInDocResource_obj.DocumentSearchbutton(driver);
                            Thread.sleep(1000);

                            for (FileSourceViewModel file : templateModel.fileSourceViewModels) {
                                SendingAudioInDocResource_obj.documentSearchSendKeys(file.fileName, driver);
                                Thread.sleep(3000);
                            }

                            SendingAudioInDocResource_obj.contentSearchSelect(driver);
                            Thread.sleep(1000);
                            SendingAudioInDocResource_obj.documnentaudioSendIcon(driver);
                            Thread.sleep(1000);

                            String payloadJsonString = SendContentMessage_obj.jsonObject(groupModel.id, templateId,
                                    templateModel.clusterId, PhoneNumber);
                            System.out.println(payloadJsonString);
                            ApiAccessing_obj.apiPostProcessing(BaseUrl, payloadJsonString);
                            Thread.sleep(1000);

                        }
                        // Image and Video send ....
                        else {

                            SendImageGalleryResource_obj.fileAttachButtonClick(driver);
                            Thread.sleep(1000);
                            SendImageGalleryResource_obj.galleryAttachElement(driver);
                            Thread.sleep(1000);
                            SendImageGalleryResource_obj.galleryImageFolderClick(driver);
                            Thread.sleep(1000);
                            for (FileSourceViewModel file : templateModel.fileSourceViewModels) {
                                SendImageGalleryResource_obj.ImageSelect(hashtableContentLable.get(file.id), driver);
                                Thread.sleep(3000);
                            }

                            SendImageGalleryResource_obj.ImageSendClick(driver);
                            // SendingTextResource_obj.SendIcon(driver);
                            Thread.sleep(2000);
                            SendImageGalleryResource_obj.videoAccessTextLableClick(driver);

                            String payloadJsonString = SendContentMessage_obj.jsonObject(groupModel.id, templateId,
                                    templateModel.clusterId, PhoneNumber);
                            System.out.println(payloadJsonString);
                            ApiAccessing_obj.apiPostProcessing(BaseUrl, payloadJsonString);
                            Thread.sleep(1000);
                        }
                    }

                }

            }
            SendingTextResource_obj.NavigateBackFormChat(driver);
            Thread.sleep(1000);
        }
        // SendingTextResource_obj.NavigateBackFormChat(driver);

    }

    private TemplateViewModel GetTemplateById(List<TemplateViewModel> listOfTemplates, int id) {

        for (TemplateViewModel temp : listOfTemplates) {

            if (temp.id == id) {
                return temp;
            }
        }
        return null;
    }

    public String jsonObject(int groupId, int templateMessageId, String clusterId, String mobileNumber) {
        JsonObject empJsonObject = Json.createObjectBuilder().add("groupId", groupId)
                .add("templateMessageId", templateMessageId).add("clusterId", clusterId)
                .add("mobileNumber", mobileNumber).build();
        return empJsonObject.toString();

    }

}
