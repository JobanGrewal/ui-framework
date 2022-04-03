package io.pragra.learning.utils;

import io.pragra.learning.conf.FrameWorkConfig;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    private static void createDirs(String dir){
        Path dirs = Paths.get(dir);
        try {
            if(!Files.exists(dirs)){
                Files.createDirectories(dirs);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generateFileName(String testName) {
        String timestampPattern = FrameWorkConfig.getProperty("timestamp_pattern");
        if(null == timestampPattern ) {
            timestampPattern = "ddMMyyyyhhmmss";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(timestampPattern);
        String screenShotFilePattern = FrameWorkConfig.getProperty("screenshot.file");
       return screenShotFilePattern.replace("{TEST_NAME}", testName).replace("{TIME_STAMP}", dateFormat.format(new Date()));

    }

    public static String captureScreenShot(WebDriver driver, String testName){
        createDirs(FrameWorkConfig.getProperty("screenshot.dir"));
        String fileName = generateFileName(testName);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path fileOnDisk = Paths.get(FrameWorkConfig.getProperty("screenshot.dir"), fileName);
        try {
            Files.copy(screenshot.toPath(), fileOnDisk);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }


}
