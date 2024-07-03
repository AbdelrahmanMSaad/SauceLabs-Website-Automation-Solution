package pages;

import automatedActions.AutomatedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver webDriver;
    private AutomatedActions automatedActions;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.automatedActions = new AutomatedActions(this.webDriver);
    }

    private final By appLogoBy = By.className("login_logo");
    private final By userNameInputBy = By.id("user-name");
    private final By passwordInputBy = By.id("password");
    private final By loginBtnBy = By.id("login-button");
    private final By closeErrorBtn = By.xpath("//button[@data-test = 'error-button']");
    private final By usernameRequiredErrorMessageBy = By.xpath("//h3[contains(text(),'Epic sadface: Username is required')]");
    private final By passwordRequiredErrorMessageBy = By.xpath("//h3[contains(text(),'Epic sadface: Password is required')]");
    private final By wrongCredentialsErrorMessageBy = By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]");

    public boolean isAppLogoDisplayed(){
        WebElement appLogo = this.automatedActions.waitActions().waitForAnElementToBeVisible(appLogoBy);
        return this.automatedActions.displayActions().isElementDisplayed(appLogo);
    }

    public void sendTextToUsernameInput(String username){
        WebElement usernameInput = this.automatedActions.waitActions().waitForAnElementToBeVisible(userNameInputBy);
        this.automatedActions.textActions().sendTextToElement(usernameInput,username);
    }

    public void sendTextToPasswordInput(String password){
        WebElement passwordInput = this.automatedActions.waitActions().waitForAnElementToBeVisible(passwordInputBy);
        this.automatedActions.textActions().sendTextToElement(passwordInput,password);
    }

    public HomePage clickOnLoginBtnWithValidCredentials(){
        WebElement loginBtn = this.automatedActions.waitActions().waitForAnElementToBeClickable(loginBtnBy);
        this.automatedActions.clickingActions().clickOnElement(loginBtn);
        return new HomePage(this.webDriver);
    }

    public void clickOnLoginBtnWithInvalidCredentials(){
        WebElement loginBtn = this.automatedActions.waitActions().waitForAnElementToBeClickable(loginBtnBy);
        this.automatedActions.clickingActions().clickOnElement(loginBtn);
    }

    public boolean isUsernameRequiredErrorDisplayed(){
        WebElement usernameErrorMessage = this.automatedActions.waitActions().waitForAnElementToBeVisible(usernameRequiredErrorMessageBy);
        return this.automatedActions.displayActions().isElementDisplayed(usernameErrorMessage);
    }

    public boolean isPasswordRequiredErrorDisplayed(){
        WebElement passwordErrorMessage = this.automatedActions.waitActions().waitForAnElementToBeVisible(passwordRequiredErrorMessageBy);
        return this.automatedActions.displayActions().isElementDisplayed(passwordErrorMessage);
    }

    public boolean isWrongCredentialsErrorDisplayed(){
        WebElement wrongCredentialsErrorMessage = this.automatedActions.waitActions().waitForAnElementToBeVisible(wrongCredentialsErrorMessageBy);
        return this.automatedActions.displayActions().isElementDisplayed(wrongCredentialsErrorMessage);
    }

}
