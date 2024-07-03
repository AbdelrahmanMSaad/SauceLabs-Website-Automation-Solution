package steps;

import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {

    Base base = new Base();
    LoginPage loginPage;
    HomePage homePage;
    SoftAssert softAssert = new SoftAssert();

    @Then("Expected results are asserted")
    public void expected_results_are_asserted() {
        softAssert.assertAll();
    }

    @Given("User opens the application")
    public void  user_opens_the_application(){
        loginPage = base.openLoginPage();
        softAssert.assertTrue(loginPage.isAppLogoDisplayed());
    }

    @When("User passes {string} as a valid username")
    public void user_sends_valid_user_name(String username){
        loginPage.sendTextToUsernameInput(username);
    }

    @When("User passes {string} as a valid password")
    public void user_sends_valid_password(String password){
        loginPage.sendTextToPasswordInput(password);
    }

    @When("User clicks on login button with the valid credentials")
    public void user_clicks_on_login_button_with_valid_credentials(){
        homePage = loginPage.clickOnLoginBtnWithValidCredentials();
    }

    @Then("Home page opens and home page app logo is displayed")
    public void verify_home_page_app_logo_is_displayed(){
        softAssert.assertTrue(homePage.isAppLogoDisplayd(),"Home page App Logo is not displayed");
    }

    @When("User clicks on login button with the invalid credentials")
    public void userClicksOnLoginButtonWithTheInvalidCredentials() {
        loginPage.clickOnLoginBtnWithInvalidCredentials();
    }

    @Then("Error message stating that username is required is displayed")
    public void errorMessageStatingThatUsernameIsRequiredIsDisplayed() {
        softAssert.assertTrue(loginPage.isUsernameRequiredErrorDisplayed());
    }

    @Then("Error message stating that password is required is displayed")
    public void errorMessageStatingThatPasswordIsRequiredIsDisplayed() {
        softAssert.assertTrue(loginPage.isPasswordRequiredErrorDisplayed());
    }

    @Then("Error message stating that credentials are invalid is displayed")
    public void errorMessageStatingThatCredentialsAreInvalidIsDisplayed() {
        softAssert.assertTrue(loginPage.isWrongCredentialsErrorDisplayed());
    }

    @Then("User closes the application")
    public void userClosesTheApplication() {
        base.closeBrowser();
    }
}
