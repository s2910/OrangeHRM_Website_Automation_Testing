package Pages;

import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.image.Kernel;

public class Leave_Page {
    WebDriver driver;
    public Leave_Page(WebDriver ldriver){
        this.driver=ldriver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Leave']") WebElement leaveMenu;
    @FindBy(xpath = "//a[normalize-space()='Apply']") WebElement applyMenu;
    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']") WebElement leaveType ;
    @FindBy(xpath = "//*[contains(text(),'CAN')]") WebElement leaveTypeOption;
    @FindBy(xpath = "//div[@class='oxd-date-input']/input") WebElement fromDate;
    @FindBy(tagName = "textarea") WebElement comments;
    @FindBy(xpath = "//button[@type='submit']") WebElement applyBtn;


    public void applyLeave(String f_date,String comment) throws InterruptedException {
        leaveMenu.click();
        applyMenu.click();
        leaveType.click(); //DropDown
        leaveTypeOption.click();
        fromDate.sendKeys(f_date);
        comments.sendKeys(comment);
        applyBtn.click();
    }
}
