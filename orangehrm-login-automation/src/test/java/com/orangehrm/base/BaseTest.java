// package com.orangehrm.base;

// import java.time.Duration;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.PageLoadStrategy;
// import org.testng.ITestResult;
// import org.testng.annotations.AfterMethod;
// import org.testng.annotations.BeforeMethod;

// import com.orangehrm.utils.ScreenshotUtil;

// public class BaseTest {

//     protected WebDriver driver;

//     //@BeforeMethod
//     // public void setUp() {
//     //     ChromeOptions options = new ChromeOptions();
//     //     options.setPageLoadStrategy(PageLoadStrategy.EAGER);

//     //     driver = new ChromeDriver(options);
//     //     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//     //     driver.manage().window().maximize();
//     //     driver.get("https://opensource-demo.orangehrmlive.com/");
//     // }
//     @BeforeMethod
// public void setUp() {

//     ChromeOptions options = new ChromeOptions();
//     options.addArguments("--remote-allow-origins=*");
//     options.addArguments("--disable-notifications");
//     options.addArguments("--disable-infobars");
//     options.addArguments("--disable-extensions");
//     options.addArguments("--start-maximized");

//     driver = new ChromeDriver(options);

//     driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
//     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//     driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
// }


//     @AfterMethod
//     public void tearDown(ITestResult result) {

//         // Take screenshot ONLY if test fails
//         if (ITestResult.FAILURE == result.getStatus()) {
//             ScreenshotUtil.takeScreenshot(driver, result.getName());
//         }

//         if (driver != null) {
//             driver.quit();
//         }
//     }

//      public WebDriver getDriver() {
//         return driver;
//     }
// }

package com.orangehrm.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.orangehrm.utils.ScreenshotUtil;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        // 🔥 THIS IS THE KEY PART
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtil.takeScreenshot(driver, result.getName());
        }

        if (driver != null) {
            driver.quit();
        }
    }
}
