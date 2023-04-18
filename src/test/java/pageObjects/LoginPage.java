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

    public HomePage loginSuccess(String username,String password){
        getTxtUserName().sendKeys(username);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
        return new HomePage(driver);
    }
    public  void negativeLogIn(String username, String password){
        //.info("Executing LogIn with username [" + username + "] and password [" + password + "]");
        getTxtUserName().sendKeys(username);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
    }
}
