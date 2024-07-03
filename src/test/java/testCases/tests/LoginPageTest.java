package testCases.tests;

import handleTestCases.TestCase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import testCases.baseTest.BaseTest;
import testCases.testCasesNames.TestCasesNames;

public class LoginPageTest extends BaseTest {
    @Test
    @Epic("EP0001")
    @Feature("Login")
    @Description("Test Case 1 : Login with valid credentials")
    public void loginWithValidCredentials() {
        TestCase testCase = getTestCase.getTestCase(TestCasesNames.tc_1);
        loginPage.sendTextToUsernameInput(testCase.getUserName());
        loginPage.sendTextToPasswordInput(testCase.getPassword());
        homePage = loginPage.clickOnLoginBtnWithValidCredentials();
        softAssert.assertTrue(homePage.isAppLogoDisplayd());
    }


    @Test
    @Epic("EP0001")
    @Feature("Login")
    @Description("Test Case 2 : Login without username or password")
    public void loginWithoutUsernameOrPassword() {
        loginPage.clickOnLoginBtnWithInvalidCredentials();
        softAssert.assertTrue(loginPage.isUsernameRequiredErrorDisplayed());
    }

    @Test
    @Epic("EP0001")
    @Feature("Login")
    @Description("Test Case 3 : Login with username and without password")
    public void loginWithUsernameAndWithoutPassword() {
        TestCase testCase = getTestCase.getTestCase(TestCasesNames.tc_3);
        loginPage.sendTextToUsernameInput(testCase.getUserName());
        loginPage.clickOnLoginBtnWithInvalidCredentials();
        softAssert.assertTrue(loginPage.isPasswordRequiredErrorDisplayed());
    }

    @Test
    @Epic("EP0001")
    @Feature("Login")
    @Description("Test Case 4 : Login in with valid username invalid password")
    public void loginWithValidUsernameInvalidPassword() {
        TestCase testCase = getTestCase.getTestCase(TestCasesNames.tc_4);
        loginPage.sendTextToUsernameInput(testCase.getUserName());
        loginPage.sendTextToPasswordInput(testCase.getPassword());
        loginPage.clickOnLoginBtnWithInvalidCredentials();
        softAssert.assertTrue(loginPage.isWrongCredentialsErrorDisplayed());
    }

    @Test
    @Epic("EP0001")
    @Feature("Login")
    @Description("Test Case 5 : Login in with invalid username valid password")
    public void loginWithInvalidUsernameValidPassword() {
        TestCase testCase = getTestCase.getTestCase(TestCasesNames.tc_5);
        loginPage.sendTextToUsernameInput(testCase.getUserName());
        loginPage.sendTextToPasswordInput(testCase.getPassword());
        loginPage.clickOnLoginBtnWithInvalidCredentials();
        softAssert.assertTrue(loginPage.isWrongCredentialsErrorDisplayed());
    }

    @Test
    @Epic("EP0001")
    @Feature("Login")
    @Description("Test Case 6 : Login in with invalid username invalid password")
    public void loginWithInvalidUsernameInvalidPassword() {
        TestCase testCase = getTestCase.getTestCase(TestCasesNames.tc_6);
        loginPage.sendTextToUsernameInput(testCase.getUserName());
        loginPage.sendTextToPasswordInput(testCase.getPassword());
        loginPage.clickOnLoginBtnWithInvalidCredentials();
        softAssert.assertTrue(loginPage.isWrongCredentialsErrorDisplayed());
    }
}
