package pages;

import automatedActions.AutomatedActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.interfaces.Pages;
import utils.Utils;

public class LoginPage {
    private Utils utils;
    private WebDriver webDriver;
    private AutomatedActions automatedActions;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.automatedActions = new AutomatedActions(this.webDriver);
        this.utils = new Utils();
    }


    String appLogo = "appLogo",
            usernameInput = "usernameInput",
            passwordInput = "passwordInput",
            loginBtn = "loginBtn",
            usernameRequiredErrorMessage = "usernameRequiredErrorMessage",
            passwordRequiredErrorMessage = "passwordRequiredErrorMessage",
            wrongCredentialsErrorMessage = "wrongCredentialsErrorMessage";


    public boolean isAppLogoDisplayed() {
        WebElement appLogo = this.automatedActions.waitActions().waitForAnElementToBeVisible(
                utils.getElement(Pages.loginPage, this.appLogo)
        );
        return this.automatedActions.displayActions().isElementDisplayed(appLogo);
    }

    public void sendTextToUsernameInput(String username) {
        WebElement usernameInput = this.automatedActions.waitActions().waitForAnElementToBeVisible(
                utils.getElement(Pages.loginPage, this.usernameInput)
        );
        this.automatedActions.textActions().sendTextToElement(usernameInput, username);
    }

    public void sendTextToPasswordInput(String password) {
        WebElement passwordInput = this.automatedActions.waitActions().waitForAnElementToBeVisible(
                utils.getElement(Pages.loginPage, this.passwordInput)
        );
        this.automatedActions.textActions().sendTextToElement(passwordInput, password);
    }

    public HomePage clickOnLoginBtnWithValidCredentials() {
        WebElement loginBtn = this.automatedActions.waitActions().waitForAnElementToBeClickable(
                utils.getElement(Pages.loginPage, this.loginBtn)
        );
        this.automatedActions.clickingActions().clickOnElement(loginBtn);
        return new HomePage(this.webDriver);
    }

    public void clickOnLoginBtnWithInvalidCredentials() {
        WebElement loginBtn = this.automatedActions.waitActions().waitForAnElementToBeClickable(
                utils.getElement(Pages.loginPage, this.loginBtn)
        );
        this.automatedActions.clickingActions().clickOnElement(loginBtn);
    }

    public boolean isUsernameRequiredErrorDisplayed() {
        WebElement usernameErrorMessage = this.automatedActions.waitActions().waitForAnElementToBeVisible(
                utils.getElement(Pages.loginPage, this.usernameRequiredErrorMessage)
        );
        return this.automatedActions.displayActions().isElementDisplayed(usernameErrorMessage);
    }

    public boolean isPasswordRequiredErrorDisplayed() {
        WebElement passwordErrorMessage = this.automatedActions.waitActions().waitForAnElementToBeVisible(
                utils.getElement(Pages.loginPage, this.passwordRequiredErrorMessage)
        );
        return this.automatedActions.displayActions().isElementDisplayed(passwordErrorMessage);
    }

    public boolean isWrongCredentialsErrorDisplayed() {
        WebElement wrongCredentialsErrorMessage = this.automatedActions.waitActions().waitForAnElementToBeVisible(
                utils.getElement(Pages.loginPage, this.wrongCredentialsErrorMessage)
        );
        return this.automatedActions.displayActions().isElementDisplayed(wrongCredentialsErrorMessage);
    }

}
