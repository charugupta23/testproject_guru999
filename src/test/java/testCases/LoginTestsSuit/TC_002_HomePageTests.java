package testCases.LoginTestsSuit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_002_HomePageTests extends BaseClass {
    @Test
    public void Test_HomePage() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
      /*  String managerID = homePage.getLblManagerID().getText();
        Assert.assertEquals(managerID,"Manger Id : mngr489806");
        Thread.sleep(2000);*/
        String pageText = driver.findElement(By.tagName("tbody")).getText();

    }
}

