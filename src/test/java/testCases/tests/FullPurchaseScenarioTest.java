package testCases.tests;

import handleTestCases.TestCase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.interfaces.ExpectedTitles;
import pages.interfaces.SortingSelections;
import testCases.baseTest.BaseTest;
import testCases.testCasesNames.TestCasesNames;

public class FullPurchaseScenarioTest extends BaseTest {

    @Test
    @Epic("EP0002")
    @Feature("Full Purchase")
    @Description("Test Case 7 : Test full purchase scenario")
    public void testFullPurchaseScenario(){
        TestCase testCase = getTestCase.getTestCase(TestCasesNames.tc_7);
        loginPage.sendTextToUsernameInput(testCase.getUserName());
        loginPage.sendTextToPasswordInput(testCase.getPassword());
        homePage = loginPage.clickOnLoginBtnWithValidCredentials();
        softAssert.assertTrue(homePage.isAppLogoDisplayd());
        homePage.selectSortingOption(SortingSelections.priceHiLo);
        String firstProductName = homePage.getTheNameOfAProductSelectedByItsNumberInTheProductsList(1);
        String secondProductName = homePage.getTheNameOfAProductSelectedByItsNumberInTheProductsList(2);
        float firstProductPrice = homePage.getThePriceOfAProductSelectedByItsNumberInTheProductList(1);
        float secondProductPrice = homePage.getThePriceOfAProductSelectedByItsNumberInTheProductList(2);
        float totalPrice = firstProductPrice + secondProductPrice;
        homePage.clickOnAddToCartBtnForProductSelectedByItsNumberInTheProductsList(1);
        homePage.clickOnAddToCartBtnForProductSelectedByItsNumberInTheProductsList(2);
        cartPage = homePage.clickOnCartBtn();
        softAssert.assertTrue(cartPage.isCartTitleDisplayed());
        softAssert.assertEquals(cartPage.getTitleText(), ExpectedTitles.cartPageTitle);
        softAssert.assertTrue(cartPage.getItemNameForAnItemSelectedByItsNumberInTheItemsList(1).equalsIgnoreCase(firstProductName));
        softAssert.assertTrue(cartPage.getItemNameForAnItemSelectedByItsNumberInTheItemsList(2).equalsIgnoreCase(secondProductName));
        checkoutPage = cartPage.clickOnCheckoutButton();
        softAssert.assertTrue(checkoutPage.isCheckoutTitleDisplayed());
        softAssert.assertEquals(checkoutPage.getTitleText(),ExpectedTitles.checkoutTitle);
        checkoutPage.sendTextToFirstNameInput(testCase.getFirstName());
        checkoutPage.sendTextToLastNameInput(testCase.getLastName());
        checkoutPage.sendTextToZipcodeInput(testCase.getZipcode());
        overviewPage = checkoutPage.clickOnContinueButtonWithValidData();
        softAssert.assertTrue(overviewPage.isOverviewTitleDisplayed());
        softAssert.assertEquals(overviewPage.getTitleText(),ExpectedTitles.overviewTitle);
        softAssert.assertEquals(overviewPage.getTotalPriceBeforeTaxes(),totalPrice);
        softAssert.assertEquals(base.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
        completePage = overviewPage.clickOnFinishButton();
        softAssert.assertTrue(completePage.isCompleteTitleDisplayed());
        softAssert.assertEquals(completePage.getTitleText(),ExpectedTitles.completeTitle);
        softAssert.assertTrue(completePage.isSuccessLogoDisplayed());
        softAssert.assertTrue(completePage.isThankYouMessageDisplayed());
        softAssert.assertTrue(completePage.isOrderDispatchedMessageDisplayed());
    }
}
