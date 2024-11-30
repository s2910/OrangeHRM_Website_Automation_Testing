package TestCases;

import Pages.BaseTest;
import Pages.LoginPage;
import org.testng.annotations.Test;

import java.util.Base64;

public class Leave_Tests extends BaseTest {

    @Test(priority = 1)
    public void applyLeave(){
        LoginPage lp = new LoginPage(driver);
        String username = "Admin";
        String password = "admin123";
        lp.loginPortal(username,password);

        lp.logout();

     }
}
