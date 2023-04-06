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

   // @FindBy(xpath = "//*[contains(text(),'Manger Id']")
    @FindBy(css = "body > table > tbody > tr > td > table > tbody > tr.heading3 > td")
    WebElement lblManagerID;

    public WebElement getLinkLogout() {
        return linkLogout;
    }

    public WebElement getLblManagerID() {
        return lblManagerID;
    }
}
