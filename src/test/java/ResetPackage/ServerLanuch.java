package ResetPackage;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class ServerLanuch {

    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    private DesiredCapabilities cap;

    public void lauchIT() {
        System.out.println("Server launching...");
        ServerLanuch ServerLanuch_obj = new ServerLanuch();

        int port = 4723;
        if (!ServerLanuch_obj.checkIfServerIsRunnning(port)) {
            ServerLanuch_obj.startServer();
            ServerLanuch_obj.stopServer();
        } else {
            System.out.println("Appium Server already running on Port - " + port);
        }
    }

    public void startServer() {

        

        builder = new AppiumServiceBuilder();
        builder.usingAnyFreePort();
        builder.usingDriverExecutable(new File("C:/Program Files/nodejs/node.exe"));
        builder.withAppiumJS(new File("C:/Program Files/Appium/Appium.exe"));


        builder.withIPAddress("127.0.0.1");
        builder.usingPort(4723);
        //builder.withCapabilities(capabilities);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        
        try {
            service = AppiumDriverLocalService.buildService(builder);
            service.start();
        } catch (Exception e) {
            System.out.println(e);
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "uiAutomator2");
        capabilities.setCapability("deviceName", "RZ8N81QR5FV");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "org.chromium.chrome.browser.document.ChromeLauncherActivity");
        capabilities.setCapability("noReset", "true");

    }

    public void stopServer() {
        service.stop();
    }

    public boolean checkIfServerIsRunnning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            // If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

}
