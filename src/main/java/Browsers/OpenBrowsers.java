package Browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowsers {
    public static ChromeDriver openChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static FirefoxDriver openFirefox() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
