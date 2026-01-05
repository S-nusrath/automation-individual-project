package com.orangehrm.tests;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
public void TC01_validLogin() {
    try {
        LoginPage lp = new LoginPage(driver);
        lp.login("Admin", "admin123");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    } catch (Exception e) {
        takeScreenshot("TC01_validLogin");
        Assert.fail("TC01 failed: " + e.getMessage());
    }
}

@Test(priority = 2)
public void TC02_validUser_invalidPass() {
    try {
        LoginPage lp = new LoginPage(driver);
        lp.login("Admin", "wrong123");
        Assert.assertTrue(lp.getErrorMessage().contains("Invalid"));
    } catch (Exception e) {
        takeScreenshot("TC02_validUser_invalidPass");
        Assert.fail("TC02 failed: " + e.getMessage());
    }
}

@Test(priority = 3)
public void TC03_invalidUser_validPass() {
    try {
        LoginPage lp = new LoginPage(driver);
        lp.login("WrongUser", "admin123");
        Assert.assertTrue(lp.getErrorMessage().contains("Invalid"));
    } catch (Exception e) {
        takeScreenshot("TC03_invalidUser_validPass");
        Assert.fail("TC03 failed: " + e.getMessage());
    }
}

@Test(priority = 4)
public void TC04_invalidUser_invalidPass() {
    try {
        LoginPage lp = new LoginPage(driver);
        lp.login("wrong", "wrong");
        Assert.assertTrue(lp.getErrorMessage().contains("Invalid"));
    } catch (Exception e) {
        takeScreenshot("TC04_invalidUser_invalidPass");
        Assert.fail("TC04 failed: " + e.getMessage());
    }
}

@Test(priority = 5)
public void TC05_emptyUsername() {
    try {
        LoginPage lp = new LoginPage(driver);
        lp.login("", "admin123");
        Assert.assertTrue(lp.getErrorMessage().contains("Required"));
    } catch (Exception e) {
        takeScreenshot("TC05_emptyUsername");
        Assert.fail("TC05 failed: " + e.getMessage());
    }
}

@Test(priority = 6)
public void TC06_emptyPassword() {
    try {
        LoginPage lp = new LoginPage(driver);
        lp.login("Admin", "");
        Assert.assertTrue(lp.getErrorMessage().contains("Required"));
    } catch (Exception e) {
        takeScreenshot("TC06_emptyPassword");
        Assert.fail("TC06 failed: " + e.getMessage());
    }
}

@Test(priority = 7)
public void TC07_emptyUser_emptyPass() {
    try {
        LoginPage lp = new LoginPage(driver);
        lp.login("", "");
        Assert.assertTrue(lp.getErrorMessage().contains("Required"));
    } catch (Exception e) {
        takeScreenshot("TC07_emptyUser_emptyPass");
        Assert.fail("TC07 failed: " + e.getMessage());
    }
}

@Test(priority = 8)
public void TC08_usernameWithSpaces() {
    try {
        LoginPage lp = new LoginPage(driver);
        lp.login(" Admin ", "admin123");
        Assert.assertTrue(lp.getErrorMessage().contains("Invalid"));
    } catch (Exception e) {
        takeScreenshot("TC08_usernameWithSpaces");
        Assert.fail("TC08 failed: " + e.getMessage());
    }
}

@Test(priority = 9)
public void TC09_passwordMasked() {
    try {
        String type = driver
                .findElement(org.openqa.selenium.By.name("password"))
                .getAttribute("type");
        Assert.assertEquals(type, "password");
    } catch (Exception e) {
        takeScreenshot("TC09_passwordMasked");
        Assert.fail("TC09 failed: " + e.getMessage());
    }
}

@Test(priority = 10)
public void TC10_loginButtonEnabled() {
    try {
        boolean enabled = driver
                .findElement(org.openqa.selenium.By.xpath("//button[@type='submit']"))
                .isEnabled();
        Assert.assertTrue(enabled);
    } catch (Exception e) {
        takeScreenshot("TC10_loginButtonEnabled");
        Assert.fail("TC10 failed: " + e.getMessage());
    }
}

}

