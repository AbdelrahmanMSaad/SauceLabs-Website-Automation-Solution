package base;

import Initializers.Initializers;
import automatedActions.AutomatedActions;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class Base {
    private WebDriver webDriver;
    private AutomatedActions automatedActions;

    private final GetDriver getDriver = new GetDriver();

    public LoginPage openLoginPage(){
        Initializers.initializeConfigFile();

        this.webDriver = getDriver.getDriver();

        automatedActions = new AutomatedActions(this.webDriver);

        automatedActions.browserActions().openWebsite();
        automatedActions.browserActions().maximizeWindow();
        automatedActions.waitActions().setImplicitWait();

        return new LoginPage(this.webDriver);
    }

    public void closeCurrentWindow(){
        this.automatedActions.browserActions().closeCurrentWindow();
    }

    public void closeBrowser(){
        this.automatedActions.browserActions().closeBrowser();
    }

    public String getCurrentUrl(){
        return this.automatedActions.browserActions().getCurrentUrl();
    }



    public static void main(String[] args) {
         LoginPage loginPage = new Base().openLoginPage();
    }
}
