package AppiumPackage002GroupId.LoggingFolder;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogGeneratorClass {

    public void GenerateLog(String loggingValue) {
        Logger Logger = java.util.logging.Logger.getLogger("Log");

        // Simple file logging Handler.
        FileHandler FileHandler;

        try {

            // We are setting handler to true = append data to file
            String current = System.getProperty("user.dir");
            // System.out.println("Current working directory in Java : " + current);
            FileHandler = new FileHandler(current + "/src/test/java/AppiumPackage002GroupId/LoggingFolder/Log.log",
                    true);
            Logger.addHandler(FileHandler);

            // Print a brief summary of the LogRecord in a human readable format.
            SimpleFormatter formatter = new SimpleFormatter();
            FileHandler.setFormatter(formatter);

            // Format a LogRecord into a standard XML format
            // XML result.

            // XMLFormatter formatter2 = new XMLFormatter();
            // crunchifyFileHandler.setFormatter(formatter2);

            // infinite loop

            // Log an INFO message.
            Logger.info(loggingValue);
            Thread.sleep(1000);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
