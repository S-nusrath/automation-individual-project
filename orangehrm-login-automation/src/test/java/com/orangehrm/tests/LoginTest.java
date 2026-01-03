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

    // TC01: Valid username & valid password
    @Test
    public void TC01_validLogin() {
        LoginPage lp = new LoginPage(driver);
        lp.login("Admin", "admin123");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    // TC02: Valid username & invalid password
    @Test
    public void TC02_validUser_invalidPass() {
        LoginPage lp = new LoginPage(driver);
        lp.login("Admin", "wrong123");
        Assert.assertTrue(lp.getErrorMessage().contains("Invalid"));
    }

    // TC03: Invalid username & valid password
    @Test
    public void TC03_invalidUser_validPass() {
        LoginPage lp = new LoginPage(driver);
        lp.login("WrongUser", "admin123");
        Assert.assertTrue(lp.getErrorMessage().contains("Invalid"));
    }

    // TC04: Invalid username & invalid password
    @Test
    public void TC04_invalidUser_invalidPass() {
        LoginPage lp = new LoginPage(driver);
        lp.login("wrong", "wrong");
        Assert.assertTrue(lp.getErrorMessage().contains("Invalid"));
    }

    // TC05: Empty username & valid password
    @Test
    public void TC05_emptyUsername() {
        LoginPage lp = new LoginPage(driver);
        lp.login("", "admin123");
        Assert.assertTrue(lp.getErrorMessage().contains("Required"));
    }

    // TC06: Valid username & empty password
    @Test
    public void TC06_emptyPassword() {
        LoginPage lp = new LoginPage(driver);
        lp.login("Admin", "");
        Assert.assertTrue(lp.getErrorMessage().contains("Required"));
    }

    // TC07: Empty username & empty password
    @Test
    public void TC07_emptyUser_emptyPass() {
        LoginPage lp = new LoginPage(driver);
        lp.login("", "");
        //Assert.assertTrue(lp.getErrorMessage().contains("Required"));
         Assert.assertTrue(false); 
    }

    // TC08: Username with leading/trailing spaces
    @Test
    public void TC08_usernameWithSpaces() {
        LoginPage lp = new LoginPage(driver);
        lp.login(" Admin ", "admin123");
        Assert.assertTrue(lp.getErrorMessage().contains("Invalid"));
    }

    // TC09: Password field should be masked
    @Test
    public void TC09_passwordMasked() {
        String type = driver
                .findElement(org.openqa.selenium.By.name("password"))
                .getAttribute("type");
        Assert.assertEquals(type, "password");
    }

    // TC10: Login button should be enabled
    @Test
    public void TC10_loginButtonEnabled() {
        boolean enabled = driver
                .findElement(org.openqa.selenium.By.xpath("//button[@type='submit']"))
                .isEnabled();
        Assert.assertTrue(enabled);
    }


}
