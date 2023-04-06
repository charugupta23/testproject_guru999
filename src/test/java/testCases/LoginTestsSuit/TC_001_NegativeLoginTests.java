package testCases.LoginTestsSuit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TC_001_NegativeLoginTests extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;
    String CSV_Path="//Users//trivendrakumar//Desktop//SeleniumPractice//testproject_guru99//src//test//java//testCases//LoginTestsSuit//logindata.csv";
    //@Test
   /* public void Test_LoginPage() throws InterruptedException {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.getTxtUserName().sendKeys("mngr489806");
        loginPage.getTxtPassword().sendKeys("ynAbAze");
        loginPage.getBtnLogin().click();

        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"Guru99 Bank Manager HomePage");
        Thread.sleep(2000);
        homePage.getLinkLogout().click();
        Thread.sleep(2000);
    }
*/
    //@Test(dataProvider = "login-data")
    public void testLoginData(String[] loginData) {
        String username = loginData[0];
        String password = loginData[1];
        loginPage.getTxtUserName().sendKeys(username);
        loginPage.getTxtPassword().sendKeys(password);
        loginPage.getBtnLogin().click();
    }

    @DataProvider(name = "login-data")
    public Object[][] readCSVData() throws Exception {

        String[][] testData;
        //Get the workbook
        Reader fileInputStream = new
                FileReader(CSV_Path);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(fileInputStream);
        int numberOfRecords = 0;
        int numberOfColumns = 0;
        for (CSVRecord record : records) {
            //System.out.println("Reading record line #" + ++numberOfRecords);
            numberOfColumns = record.size();
        }

        testData = new String[numberOfRecords - 1][numberOfColumns];
        System.out.println("numberOfRecords = " + numberOfRecords);
        System.out.println("numberOfColumns = " + numberOfColumns);
        int currentRecord = 0;
        fileInputStream = new FileReader("CSV_Path");
        records = CSVFormat.EXCEL.parse(fileInputStream);
        for (CSVRecord record : records) {
            System.out.println("Reading test data ");
            if (record.getRecordNumber() == 1) {
                System.out.println("record = " + record);
                continue;
            }
            for (int i = 0; i < record.size(); i++) {
                testData[currentRecord][i] = record.get(i);
            }
            currentRecord++;
        }
        return testData;
    }

    @Test
    public void readData() throws IOException {
        Reader fileInputStream = new
                FileReader(CSV_Path);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(fileInputStream);
        int numberOfRecords = 0;
        int numberOfColumns = 0;
        for (CSVRecord record : records) {
            //System.out.println("Reading record line #" + ++numberOfRecords);
            numberOfColumns = record.size();
        }
        System.out.println("Numbers " +numberOfRecords);
    }
}
