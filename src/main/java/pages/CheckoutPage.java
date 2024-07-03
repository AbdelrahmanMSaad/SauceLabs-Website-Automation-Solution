package pages;

import automatedActions.AutomatedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    private WebDriver webDriver;
    private AutomatedActions automatedActions;

    public CheckoutPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.automatedActions = new AutomatedActions(this.webDriver);
    }

    private final By checkoutTitleBy = By.className("title");

    private final By firstNameInputBy = By.id("first-name");
    private final By lastNameInputBy = By.id("last-name");
    private final By zipcodeInputBy = By.id("postal-code");

    private final By continueBtnBy = By.id("continue");

    public boolean isCheckoutTitleDisplayed(){
        return this.automatedActions.displayActions().isElementDisplayed((this.automatedActions.waitActions().waitForAnElementToBeVisible(checkoutTitleBy)));
    }

    public String getTitleText(){
        WebElement checkoutTitle = this.automatedActions.waitActions().waitForAnElementToBeVisible(checkoutTitleBy);
        return this.automatedActions.textActions().getTextFromElement(checkoutTitle);
    }

    public void sendTextToFirstNameInput(String firstName){
        WebElement firstNameInput = this.automatedActions.waitActions().waitForAnElementToBeVisible(firstNameInputBy);
        this.automatedActions.textActions().sendTextToElement(firstNameInput,firstName);
    }

    public void sendTextToLastNameInput(String lastName){
        WebElement lastNameInput = this.automatedActions.waitActions().waitForAnElementToBeVisible(lastNameInputBy);
        this.automatedActions.textActions().sendTextToElement(lastNameInput,lastName);
    }

    public void sendTextToZipcodeInput(String zipcode){
        WebElement zipcodeInput = this.automatedActions.waitActions().waitForAnElementToBeVisible(zipcodeInputBy);
        this.automatedActions.textActions().sendTextToElement(zipcodeInput,zipcode);
    }

    public OverviewPage clickOnContinueButtonWithValidData(){
        WebElement continueBtn = this.automatedActions.waitActions().waitForAnElementToBeClickable(continueBtnBy);
        this.automatedActions.clickingActions().clickOnElement(continueBtn);
        return new OverviewPage(this.webDriver);
    }




}
