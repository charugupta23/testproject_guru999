package testCases.LoginTestsSuit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.TestUtilities;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class TC_001_LoginTests extends TestUtilities {
    LoginPage loginPage;
    HomePage homePage;
 @Test(dataProvider = "login-data")
    public void Test_LoginPage(String userName,String password) throws InterruptedException {
        loginPage = new LoginPage(driver);
        logger.debug("**** Debug Log *****");
        homePage = new HomePage(driver);
        homePage = loginPage.loginSuccess(userName,password);
        takeScreenshot("screen shots");
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle,Util.EXPECT_TITLE,"Title does not match.");
        String pageText = homePage.getLblManagerID().getText();
        String[] parts = pageText.split(":");
        String dynamicText = parts[1];
        assertTrue(dynamicText.substring(1, 5).equals(Util.FIRST_PATTERN));
        String remain = dynamicText.substring(dynamicText.length() - 4);
        assertTrue(remain.matches(Util.SECOND_PATTERN));
        assertEquals("9806", remain,Util.EXPECT_ERROR);
    }
    @DataProvider(name = "login-data")
    public String[][] dataProvider() {
        String[][] data = {
                {"mngr489806","ynAbAze"},
                {"mngr4898061","ynAbAze"},
                {"mngr489806","ynAbAze1"}
        };
        return data;
    }
}


    //@Test(dataProvider = "login-data")
   /* public void testLoginData(String[] loginData) {
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
*/
