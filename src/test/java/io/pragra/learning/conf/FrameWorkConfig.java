package io.pragra.learning.conf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameWorkConfig {
    private final Logger logger = LogManager.getLogger(FrameWorkConfig.class);
    private static FrameWorkConfig instance;
    private Properties properties;
    final String configFileName = "framework.properties";
    private FrameWorkConfig() {
        try {
            logger.debug("Loading file from src/test/resources/{} ", configFileName);
            InputStream stream = new FileInputStream("src/test/resources/"+configFileName);
            logger.debug("Successfully read file");
            properties = new Properties();
            properties.load(stream);
            logger.debug("Successfully loaded properties in map");
        }catch (FileNotFoundException ex) {
            logger.error("File {} not available to load", configFileName);

        }catch (IOException ex) {
            logger.error(" not able to load", configFileName);

        }
    }

    public static String getProperty(String key) {
        if(key == null) {
            throw new RuntimeException("Invalid/Null key");
        }
        synchronized (FrameWorkConfig.class){
            if(instance == null) {
                instance = new FrameWorkConfig();
            }
        }
        return instance.properties.getProperty(key);
    }
}
