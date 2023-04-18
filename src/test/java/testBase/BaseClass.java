package testBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

public class BaseClass {
    protected WebDriver driver;
    protected Logger logger;
    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;

    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser, ITestContext ctx) {
        String testName = ctx.getCurrentXmlTest().getName();
        logger = LogManager.getLogger(this.getClass());
        BrowserDriverFactory factory = new BrowserDriverFactory(browser);
        driver = factory.createDriver();

        // This sleep here is for instructor only. Students don't need this here
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get("http://www.demo.guru99.com/V4/");
        driver.manage().window().maximize();

        this.testSuiteName = ctx.getSuite().getName();
        this.testName = testName;
        this.testMethodName = method.getName();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        // Close browser
        driver.quit();
    }
}




