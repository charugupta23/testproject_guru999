package testBase;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserDriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;
    private Logger log;

    public BrowserDriverFactory(String browser) {
        this.browser = browser.toLowerCase();
    }

    public WebDriver createDriver() {
        // Create drivers
        switch (browser) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver.set(new ChromeDriver(options));
                break;
            default:
                System.out.println("Do not know how to start: " + browser + ", starting chrome.");
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
                driver.set(new ChromeDriver());
                break;
        }

        return driver.get();
    }
}