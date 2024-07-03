package pages;

import automatedActions.AutomatedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private WebDriver webDriver;
    private AutomatedActions automatedActions;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.automatedActions = new AutomatedActions(this.webDriver);
    }

    private final By appLogoBy = By.className("app_logo");
    private final By cartBtnBy = By.xpath("//a[@data-test='shopping-cart-link']");

    private final By productSortingListBy = By.className("product_sort_container");

    private final By productsContainerBy = By.id("inventory_container");
    private final By singleProductBy = By.className("inventory_item");

    private final By productNameBy = By.className("inventory_item_name");
    private final By productPrice = By.className("inventory_item_price");
    private final By addToCartBtnBy = By.xpath("//button[text()='Add to cart']");

    public boolean isAppLogoDisplayd() {
        WebElement appLogo = this.automatedActions.waitActions().waitForAnElementToBeVisible(appLogoBy);
        return this.automatedActions.displayActions().isElementDisplayed(appLogo);
    }

    public CartPage clickOnCartBtn(){
        WebElement cartBtn = this.automatedActions.waitActions().waitForAnElementToBeClickable(cartBtnBy);
        this.automatedActions.clickingActions().clickOnElement(cartBtn);
        return new CartPage(this.webDriver);
    }

    public void selectSortingOption(String sortingOption){
        WebElement productSortingList = this.automatedActions.waitActions().waitForAnElementToBeVisible(productSortingListBy);
        this.automatedActions.dropdownListActions().selectAnOptionFromADropdownList(productSortingList,sortingOption);
    }

    public boolean areProductsDisplayed() {
        WebElement productsContainer = this.automatedActions.waitActions().waitForAnElementToBeVisible(productsContainerBy);
        return this.automatedActions.displayActions().isElementDisplayed(productsContainer);
    }

    private List<WebElement> getListOfProducts(){
        WebElement productsContainer = this.automatedActions.waitActions().waitForAnElementToBeVisible(productsContainerBy);
        return this.automatedActions.listActions().getListOfWebElementsWithinParentWebElement(singleProductBy,productsContainer);
    }

    private WebElement selectSingleProductUsingItsNumberInTheProductsList(int index){
        return this.getListOfProducts().get(index-1);
    }

    public String getTheNameOfAProductSelectedByItsNumberInTheProductsList(int index){
        WebElement productName = this.automatedActions.nestedActions().getAnElementWithinAnElement(productNameBy,this.selectSingleProductUsingItsNumberInTheProductsList(index));
        return this.automatedActions.textActions().getTextFromElement(productName);
    }

    public float getThePriceOfAProductSelectedByItsNumberInTheProductList(int index){
        WebElement prductPrice = this.automatedActions.nestedActions().getAnElementWithinAnElement(productPrice,this.selectSingleProductUsingItsNumberInTheProductsList(index));
        return Float.parseFloat(this.automatedActions.textActions().getTextFromElement(prductPrice).replace("$",""));
    }

    public void clickOnAddToCartBtnForProductSelectedByItsNumberInTheProductsList(int index){
        WebElement addToCartBtn = this.automatedActions.nestedActions().getAnElementWithinAnElement(addToCartBtnBy,this.selectSingleProductUsingItsNumberInTheProductsList(index));
        this.automatedActions.clickingActions().clickOnElement(addToCartBtn);
    }
}
