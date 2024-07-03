package testCases.baseTest;

import base.Base;
import handleTestCases.GetTestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import pages.*;

public class BaseTest {
    protected final SoftAssert softAssert = new SoftAssert();
    protected final GetTestCase getTestCase = new GetTestCase();

    protected Base base;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected OverviewPage overviewPage;
    protected CompletePage completePage;

    @BeforeMethod
    public void beforeTest() {
        base = new Base();
        loginPage = base.openLoginPage();
        softAssert.assertTrue(loginPage.isAppLogoDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        base.closeBrowser();
        softAssert.assertAll();
    }
}
