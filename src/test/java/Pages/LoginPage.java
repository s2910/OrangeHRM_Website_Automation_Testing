package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver ldriver){
        this.driver=ldriver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@placeholder='Username']") WebElement uname;
    @FindBy(xpath = "//input[@placeholder='Password']") WebElement pass;
    @FindBy(xpath = "//button[@type='submit']") WebElement loginBtn;
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']") WebElement userMenu ;
    @FindBy(xpath = "//a[normalize-space()='Logout']") WebElement logoutClick;
    @FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement InvalidMessage;

    public void loginPortal(String username,String password){
        uname.sendKeys(username);
        pass.sendKeys(password);
        loginBtn.click();
    }

    public void logout(){
        userMenu.click();
        logoutClick.click();
    }

    public String getInvalidText(){
        return(InvalidMessage.getText());
    }
}

