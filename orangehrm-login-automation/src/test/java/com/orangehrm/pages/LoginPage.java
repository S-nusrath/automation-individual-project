package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Locators
    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.xpath("//button[@type='submit']");
    By errorMsg = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String user) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public String getErrorMessage() {

    // For invalid login alert
    if (driver.findElements(
            By.xpath("//p[contains(@class,'oxd-alert-content-text')]")
        ).size() > 0) {

        return driver.findElement(
            By.xpath("//p[contains(@class,'oxd-alert-content-text')]")
        ).getText();
    }

    // For required field message
    return driver.findElement(
        By.xpath("//span[contains(@class,'oxd-input-field-error-message')]")
    ).getText();
}


    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }
}
