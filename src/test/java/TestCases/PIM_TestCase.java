package TestCases;

import Pages.BaseTest;
import Pages.LoginPage;
import Pages.PIM_page;
import Utilities.ReadExcelFile;
import org.testng.annotations.Test;

public class PIM_TestCase extends BaseTest {
    String fileName = System.getProperty("user.dir")+"\\TestData\\Employee_Names.xlsx";
    @Test(priority = 1)
    void addEmployeeTestCase() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        String username = "Admin";
        String password = "admin123";
        lp.loginPortal(username,password);

        PIM_page pimPage = new PIM_page(driver);
        String fname = ReadExcelFile.getCellValue(fileName,"EmployeesName",1,0);
        String lname = ReadExcelFile.getCellValue(fileName,"EmployeesName",1,1);
        pimPage.addEmployee(fname,lname);
        lp.logout();
    }

    @Test(priority = 2)
    void searchEmployeeTestCase() throws InterruptedException {

        //Login
        LoginPage lp = new LoginPage(driver);
        String username = "Admin";
        String password = "admin123";
        lp.loginPortal(username,password);

        //EmployeeName
        PIM_page pimPage = new PIM_page(driver);
        String searchEmployeeName = ReadExcelFile.getCellValue(fileName,"EmployeesName",1,0) +" "+ ReadExcelFile.getCellValue(fileName,"EmployeesName",1,1);
        pimPage.searchEmployee(searchEmployeeName);

        //Logout
        lp.logout();
    }

    @Test(priority = 3)
    void printEmployeeListTestCase(){
        LoginPage lp = new LoginPage(driver);
        String username = "Admin";
        String password = "admin123";
        lp.loginPortal(username,password);

        PIM_page pimPage = new PIM_page(driver);
        pimPage.printEmployeeList();
    }
}
