package com.h3d.ui.pageactions;

import com.h3d.ui.base.BaseTest;
import com.h3d.ui.pages.LoginPage;
import com.h3d.ui.utilities.Helpers;
import com.h3d.ui.utilities.ReadExcel;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LoginPageActions extends Helpers {
    static LoginPage loginPage=new LoginPage();

    public static void login(HashMap<String, String> data) {

        try {
            Thread.sleep(3000);

            System.out.println(data.get("email"));
            enterText(loginPage.email, data.get("email"));
            Thread.sleep(3000);
            enterText(loginPage.password, data.get("Password"));
            Thread.sleep(3000);
            click(loginPage.submitButton);
            try {
                Assert.assertTrue(isDisplayed(loginPage.h3d_image));
                logger.info("Login Successfully");
            } catch (Exception exception) {
                logger.error(exception);
                logger.error("Incorrect combination of user name and password");
            }
        } catch (Exception exception) {
            logger.error("Unable to login");
        }

    }

}
