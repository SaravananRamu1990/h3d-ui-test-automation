package com.h3d.ui.testScripts;

import com.h3d.ui.base.BaseTest;
import com.h3d.ui.pageactions.LoginPageActions;
import com.h3d.ui.pages.LoginPage;
import com.h3d.ui.utilities.ReadExcel;
import org.apache.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LoginTest extends BaseTest {
    static Logger logger = Logger.getLogger(LoginTest.class);

    @Test
    @Parameters({ "testCase" })
    public void loginTest(String testID) {
        try {
            HashMap<String, String> data = ReadExcel.getUserData(testID);
            logger.info("check"+data);

            LoginPageActions.login(data);
        }
        catch(Exception e)
        {
            logger.info("Network connectivity issues");
        }

    }
}
