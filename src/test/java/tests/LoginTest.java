package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        // Better validation (element check)
        boolean isInventoryVisible =
                driver.findElement(By.className("inventory_list")).isDisplayed();

        Assert.assertTrue(isInventoryVisible, "Login failed - Inventory not visible");
    }

    @Test
    public void invalidLoginTest() {

        LoginPage login = new LoginPage(driver);
        login.login("invalid_user", "wrong_password");

        String error = login.getErrorMessage();

        Assert.assertTrue(error.contains("do not match"),
                "Error message not displayed for invalid login");
    }
}