package com.h3d.ui.properties;

import com.h3d.ui.constants.FilePathConstants;
import org.testng.log4testng.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class PropertyParser {

    static Logger logger = Logger.getLogger(PropertyParser.class);

    public static String readLocators(String locator) {
        return (String) readProperties().getProperty(locator);

    }

    /**
     * This method is used to read the properties
     * @return
     */
    public static Properties readProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(FilePathConstants.CONFIG_PATH));
        } catch (IOException e) {
            logger.info("File Not Found");
            logger.info(e.getLocalizedMessage());
        }
        return properties;
    }
}
