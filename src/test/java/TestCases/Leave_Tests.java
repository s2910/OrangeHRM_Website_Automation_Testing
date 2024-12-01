package TestCases;

import Pages.BaseTest;
import Pages.Leave_Page;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class Leave_Tests extends BaseTest {

    @Test(priority = 1)
    public void applyLeaveTestCase() throws InterruptedException {
        //Login To Your Account
        LoginPage lp = new LoginPage(driver);
        String username = "Admin";
        String password = "admin123";
        lp.loginPortal(username,password);

        //Apply Leave
        Leave_Page leavePage = new Leave_Page(driver);
        String f_Date = "2024-11-12";
        String comment = "Leave for personal reasons";
        leavePage.applyLeave(f_Date,comment);

        //Logout From Your Account
        lp.logout();

     }
}