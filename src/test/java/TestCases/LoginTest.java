package TestCases;

import Pages.BaseTest;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    void loginwithValidCredentials() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        String username = "Admin";
        String password = "admin123";
        lp.loginPortal(username,password);

        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"OrangeHRM","Login Successful");
        Thread.sleep(2000);
        lp.logout();
    }

    @Test(priority = 2)
    void loginwihInvalidCredentials(){
        LoginPage lp = new LoginPage(driver);
        String username = "Admin";
        String password = "123";//wrong password
        lp.loginPortal(username,password);

        String msg_expected = "Invalid credentials";
        String msg_actual = lp.getInvalidText();

        Assert.assertEquals(msg_actual,msg_expected,"Login was not Successful");
    }
}
