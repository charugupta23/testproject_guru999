package testBase;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

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
            case "firefox":
                driver.set(new FirefoxDriver());
                break;
            default:
                System.out.println("Do not know how to start: " + browser + ", starting chrome.");
                ChromeOptions options1 = new ChromeOptions();
                options1.addArguments("--remote-allow-origins=*");
                driver.set(new ChromeDriver(options1)); break;
        }

        return driver.get();
    }
}