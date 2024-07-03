package base;

import Browsers.Browsers;
import Browsers.OpenBrowsers;
import handleFilesAndDirectories.handleConfigFile.Config;
import org.openqa.selenium.WebDriver;

public class GetDriver {
    public WebDriver getDriver(){
        if(Config.browser.equalsIgnoreCase(Browsers.chrome)){
            return OpenBrowsers.openChrome();
        }else if(Config.browser.equalsIgnoreCase(Browsers.firefox)){
            return OpenBrowsers.openFirefox();
        }else{
            return null;
        }
    }
}
