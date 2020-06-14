package utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    private static final Logger LOGGER = LogManager.getLogger(PropertyManager.class);

    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = "src/test/resources/configuration.properties";
    private static String driverLocation;
    private static String screenshotLocation;

    //Create a Singleton instance. We need only one instance of Property Manager.
    public static PropertyManager getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    //Get all configuration data and assign to related fields.
    private void loadData() {
        //Declare a properties object
        Properties prop = new Properties();

        //Read configuration.properties file
        try {
            LOGGER.info(propertyFilePath);
            //prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            LOGGER.info("Configuration properties file cannot be found");
        }

        //Get properties from configuration.properties
        driverLocation = prop.getProperty("webdriver.chrome.driver");
        screenshotLocation = prop.getProperty("screenshot.file.location");
    }


    public String getDriverLocation() {
        return driverLocation;
    }
    public  String getScreenshotLocation() {
        return screenshotLocation;
    }

}