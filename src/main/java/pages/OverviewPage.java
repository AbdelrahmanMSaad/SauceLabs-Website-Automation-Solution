package pages;

import automatedActions.AutomatedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OverviewPage {
    private WebDriver webDriver;
    private AutomatedActions automatedActions;

    public OverviewPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.automatedActions = new AutomatedActions(this.webDriver);
    }

    private final By overviewTitleBy = By.className("title");

    private final By cartListBy = By.className("cart_list");

    private final By singleItemBy = By.className("cart_item");

    private final By productNameBy = By.className("inventory_item_name");

    private final By totalPriceBeforeTaxesBy = By.className("summary_subtotal_label");

    private final By finishBtnBy = By.id("finish");

    public boolean isOverviewTitleDisplayed(){
        WebElement overviewTitle = this.automatedActions.waitActions().waitForAnElementToBeVisible(overviewTitleBy);
        return this.automatedActions.displayActions().isElementDisplayed(overviewTitle);
    }

    public String getTitleText(){
        WebElement overviewTitle = this.automatedActions.waitActions().waitForAnElementToBeVisible(overviewTitleBy);
        return this.automatedActions.textActions().getTextFromElement(overviewTitle);
    }

    private List<WebElement> getListOfItems(){
        WebElement cartList = this.automatedActions.waitActions().waitForAnElementToBeVisible(cartListBy);
        return this.automatedActions.listActions().getListOfWebElementsWithinParentWebElement(singleItemBy,cartList);
    }

    private WebElement getSingleProductSelectedByItsNumberInTheItemsList(int index){
        return this.getListOfItems().get(index-1);
    }

    public String getItemNameForAnItemSelectedByItsNumberInTheItemsList(int index){
        WebElement prodcutName = this.automatedActions.nestedActions().getAnElementWithinAnElement(productNameBy,this.getSingleProductSelectedByItsNumberInTheItemsList(index));
        return this.automatedActions.textActions().getTextFromElement(prodcutName);
    }

    public float getTotalPriceBeforeTaxes(){
        WebElement totalPriceBeforeTaxes = this.automatedActions.waitActions().waitForAnElementToBeVisible(totalPriceBeforeTaxesBy);
        return Float.parseFloat(this.automatedActions.textActions().getTextFromElement(totalPriceBeforeTaxes).replace("Item total: $",""));
    }

    public CompletePage clickOnFinishButton(){
        WebElement finishBtn = this.automatedActions.waitActions().waitForAnElementToBeClickable(finishBtnBy);
        this.automatedActions.clickingActions().clickOnElement(finishBtn);
        return new CompletePage(this.webDriver);
    }

}
