package com.orangehrm.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String testName) {

    try {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        // File screenshotsDir = new File("screenshots");
        // if (!screenshotsDir.exists()) {
        //     screenshotsDir.mkdirs(); 
        // }

        // File dest = new File(
        //         screenshotsDir,
        //         testName + "_" + timestamp + ".png"
        // );
        File folder = new File("screenshots");
            if (!folder.exists()) {
                folder.mkdirs(); // 🔥 VERY IMPORTANT
            }

            File dest = new File(
                    folder,
                    testName + "_" + timestamp + ".png"
            );

        FileUtils.copyFile(src, dest);

        System.out.println("Screenshot saved: " + dest.getAbsolutePath());

    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
