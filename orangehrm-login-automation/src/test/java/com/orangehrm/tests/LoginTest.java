import com.orangehrm.base.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void TC01_validLogin() {
        LoginPage lp = new LoginPage(driver);
        lp.login("Admin", "admin123");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @Test
    public void TC02_validUser_invalidPass() {
        LoginPage lp = new LoginPage(driver);
        lp.login("Admin", "wrong123");
        Assert.assertTrue(lp.getErrorMessage().contains("Invalid"));
    }

    @Test
    public void TC03_invalidUser_validPass() {
        LoginPage lp = new LoginPage(driver);
        lp.login("WrongUser", "admin123");
        Assert.assertTrue(lp.getErrorMessage().contains("Invalid"));
    }

    @Test
    public void TC04_invalidUser_invalidPass() {
        LoginPage lp = new LoginPage(driver);
        lp.login("wrong", "wrong");
        Assert.assertTrue(lp.getErrorMessage().contains("Invalid"));
    }

    @Test
    public void TC05_emptyUsername() {
        LoginPage lp = new LoginPage(driver);
        lp.login("", "admin123");
        Assert.assertTrue(lp.getErrorMessage().contains("Required"));
    }

    @Test
    public void TC06_emptyPassword() {
        LoginPage lp = new LoginPage(driver);
        lp.login("Admin", "");
        Assert.assertTrue(lp.getErrorMessage().contains("Required"));
    }

    @Test
    public void TC07_emptyUser_emptyPass() {
        LoginPage lp = new LoginPage(driver);
        lp.login("", "");
        Assert.assertTrue(lp.getErrorMessage().contains("Required"));
    }

    @Test
    public void TC08_usernameWithSpaces() {
        LoginPage lp = new LoginPage(driver);
        lp.login(" Admin ", "admin123");
        Assert.assertTrue(lp.getErrorMessage().contains("Invalid"));
    }

    @Test
    public void TC09_passwordMasked() {
        LoginPage lp = new LoginPage(driver);
        String type = driver.findElement(
            org.openqa.selenium.By.name("password")
        ).getAttribute("type");
        Assert.assertEquals(type, "password");
    }

    @Test
    public void TC10_loginButtonEnabled() {
        LoginPage lp = new LoginPage(driver);
        Assert.assertTrue(
            driver.findElement(
                org.openqa.selenium.By.xpath("//button[@type='submit']")
            ).isEnabled()
        );
    }
}
