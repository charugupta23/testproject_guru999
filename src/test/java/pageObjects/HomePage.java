package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Log out")
    WebElement linkLogout;
    @FindBy(xpath = "//body//table//table/tbody/tr[3]/td[1]")
    WebElement lblManagerID;
    public WebElement getLinkLogout() {
        return linkLogout;
    }
    public WebElement getLblManagerID() {
        return lblManagerID;
    }
}
