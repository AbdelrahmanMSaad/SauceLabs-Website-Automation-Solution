package pages;

import automatedActions.AutomatedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompletePage {
    private WebDriver webDriver;
    private AutomatedActions automatedActions;

    public CompletePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.automatedActions = new AutomatedActions(this.webDriver);
    }

    private final By overviewTitleBy = By.className("title");

    private final By successLogoBy = By.xpath("//img[@data-test = 'pony-express']");
    private final By thankYouMessageBy = By.className("complete-header");
    private final By orderDispatchedMessageBy = By.className("complete-text");



    public boolean isCompleteTitleDisplayed(){
        WebElement overviewTitle = this.automatedActions.waitActions().waitForAnElementToBeVisible(overviewTitleBy);
        return this.automatedActions.displayActions().isElementDisplayed(overviewTitle);
    }

    public String getTitleText(){
        WebElement overviewTitle = this.automatedActions.waitActions().waitForAnElementToBeVisible(overviewTitleBy);
        return this.automatedActions.textActions().getTextFromElement(overviewTitle);
    }

    public boolean isSuccessLogoDisplayed(){
        WebElement successLogo = this.automatedActions.waitActions().waitForAnElementToBeVisible(successLogoBy);
        return this.automatedActions.displayActions().isElementDisplayed(successLogo);
    }

    public boolean isThankYouMessageDisplayed(){
        WebElement thankYouMessage = this.automatedActions.waitActions().waitForAnElementToBeVisible(thankYouMessageBy);
        return this.automatedActions.displayActions().isElementDisplayed(thankYouMessage);
    }
    
    public boolean isOrderDispatchedMessageDisplayed(){
        WebElement orderDispatchedMessage = this.automatedActions.waitActions().waitForAnElementToBeVisible(orderDispatchedMessageBy);
        return this.automatedActions.displayActions().isElementDisplayed(orderDispatchedMessage);
    }

}
