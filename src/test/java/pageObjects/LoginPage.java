package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@name='uid']")
    WebElement txtUserName;
    @FindBy(xpath = "//input[@name='password']")
    WebElement txtPassword;
    @FindBy(xpath = "//input[@name='btnLogin']")
    WebElement btnLogin;
    public WebElement getTxtUserName() {
        return txtUserName;
    }

    public WebElement getTxtPassword() {
        return txtPassword;
    }

    public WebElement getBtnLogin() {
        return btnLogin;
    }
}
