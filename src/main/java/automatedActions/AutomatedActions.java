package automatedActions;

import configs.configFileProperties.ConfigFileProperties;
import handleFilesAndDirectories.handleConfigFile.Config;
import handleFilesAndDirectories.handleConfigFile.GetPropertiesFromConfigFile;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomatedActions {
    protected final WebDriver webDriver;
    private final Actions actions;
    private final WebDriverWait webDriverWait;
    private static long implicitWaitDuration;

    public AutomatedActions(WebDriver webDriver) {
        this.webDriver = webDriver;
        actions = new Actions(this.webDriver);
        long elementWaitDuration = Long.parseLong(GetPropertiesFromConfigFile.getPropertyFromConfigFile(ConfigFileProperties.element_wait_duration));
        webDriverWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(elementWaitDuration));
        implicitWaitDuration = Long.parseLong(GetPropertiesFromConfigFile.getPropertyFromConfigFile(ConfigFileProperties.implicit_wait_duration));
    }

    public ClickingActions clickingActions() {
        return new ClickingActions();
    }

    public TextActions textActions() {
        return new TextActions();
    }

    public WaitActions waitActions() {
        return new WaitActions();
    }

    public DisplayActions displayActions() {
        return new DisplayActions();
    }

    public BrowserActions browserActions() {
        return new BrowserActions();
    }

    public ListActions listActions() {
        return new ListActions();
    }

    public DropdownListActions dropdownListActions(){return new DropdownListActions();}

    public NestedActions nestedActions(){return new NestedActions();}

    public class ClickingActions {
        public void clickOnElement(WebElement webElement) {
            webElement.click();
        }

        public void doubleTabOnElement(WebElement webElement) {
            actions.doubleClick(webElement);
        }
    }

    public static class TextActions {
        public String getTextFromElement(WebElement webElement) {
            return webElement.getText();
        }

        public void sendTextToElement(WebElement webElement, String text) {
            webElement.sendKeys(text);
        }
    }

    public class WaitActions {
        public void setImplicitWait() {
            webDriver.manage().timeouts().implicitlyWait(implicitWaitDuration, TimeUnit.SECONDS);
        }

        public WebElement waitForAnElementToBeClickable(By by) {
            return (WebElement) webDriverWait.until(ExpectedConditions.elementToBeClickable(by));

        }

        public WebElement waitForAnElementToBeVisible(By mobileBy) {
            return (WebElement) webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(mobileBy));
        }
    }

    public static class DisplayActions {
        public boolean isElementDisplayed(WebElement webElement) {
            return webElement.isDisplayed();
        }

        public boolean isElementSelected(WebElement webElement) {
            return webElement.isSelected();
        }

        public boolean isElementEnabled(WebElement webElement) {
            return webElement.isEnabled();
        }
    }

    public class BrowserActions {
        public void openWebsite() {
            webDriver.get(Config.uRL);
        }

        public void maximizeWindow() {
            webDriver.manage().window().maximize();
        }

        public String getCurrentUrl(){
            return webDriver.getCurrentUrl();
        }

        public void closeCurrentWindow() {
            webDriver.close();
        }

        public void closeBrowser() {
            webDriver.quit();
        }
    }

    public class ListActions {
        public List<WebElement> getListOfWebElements(By elementsBy) {
            return webDriver.findElements(elementsBy);
        }

        public List<WebElement> getListOfWebElementsWithinParentWebElement(By childElementsBy, WebElement parentWebElement) {
            return parentWebElement.findElements(childElementsBy);
        }
    }

    public class DropdownListActions{
        public void selectAnOptionFromADropdownList(WebElement dropdownListWebElement,String optionToBeSelected){
            String script = "arguments[0].style.display='block';";
            ((JavascriptExecutor) webDriver).executeScript(script, dropdownListWebElement);
            Select select = new Select(dropdownListWebElement);
            select.selectByVisibleText(optionToBeSelected);
        }
    }

    public class NestedActions{
        public WebElement getAnElementWithinAnElement(By childElementBy, WebElement parentWebElement){
            return parentWebElement.findElement(childElementBy);
        }
    }
}
