package pages;

import automatedActions.AutomatedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private WebDriver webDriver;
    private AutomatedActions automatedActions;

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.automatedActions = new AutomatedActions(this.webDriver);
    }

    private final By yourCartTitleBy = By.className("title");

    private final By cartListBy = By.className("cart_list");

    private final By singleItemBy = By.className("cart_item");

    private final By productNameBy = By.className("inventory_item_name");

    private final By checkoutBtnBy = By.id("checkout");


    public boolean isCartTitleDisplayed(){
        WebElement cartTitle = this.automatedActions.waitActions().waitForAnElementToBeVisible(yourCartTitleBy);
        return this.automatedActions.displayActions().isElementDisplayed(cartTitle);
    }

    public String getTitleText(){
        WebElement overviewTitle = this.automatedActions.waitActions().waitForAnElementToBeVisible(yourCartTitleBy);
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

    public CheckoutPage clickOnCheckoutButton(){
        WebElement checkoutBtn = this.automatedActions.waitActions().waitForAnElementToBeClickable(checkoutBtnBy);
        this.automatedActions.clickingActions().clickOnElement(checkoutBtn);
        return new CheckoutPage(this.webDriver);
    }
}
