package ru.alexsumin.testcase;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.alexsumin.testcase.pages.HomePage;
import ru.alexsumin.testcase.pages.ResendPage;
import ru.alexsumin.testcase.util.ProjectUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTestCase extends TestCase {

    @Test
    public void signUpTest() throws Exception {
        HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);

        homePage.open();
        homePage.getStartedForFreeButtonClick();
        homePage.enterEmail(ProjectUtil.generateRandomString(6) + "+wpt@writeraj.qaa");
        homePage.createAccount();

        ResendPage resendPage = PageFactory.initElements(webDriver, ResendPage.class);

        assertEquals("https://www.wrike.com/resend/", resendPage.getCurrentUrl());

        resendPage.fillForm();
        resendPage.resendEmail();

        assertTrue(resendPage.isEmailSent());
        assertTrue(resendPage.isTwitterVisible());

        resendPage.clickTwitterIco();

        assertEquals("https://twitter.com/wrike", resendPage.getCurrentUrl());
    }
}
