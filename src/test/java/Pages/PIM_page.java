package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class PIM_page {
    WebDriver driver;

    public PIM_page(WebDriver ldriver) {
        this.driver = ldriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")
    WebElement pim;
    @FindBy(xpath = "//a[normalize-space()='Add Employee']")
    WebElement addEmployeeBtn;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveBtn;
    @FindBy(xpath = "//a[normalize-space()='Employee List']")
    WebElement employeeList;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")
    WebElement employeeName;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchBtn;
    @FindBy(xpath="//span[@class='oxd-text oxd-text--span']")List<WebElement> element;

    @FindBy(xpath = "//div[@class='oxd-table-card']/div /div[1]") List<WebElement> totalRows;
    @FindBy(xpath = "//div[@class='oxd-table-card'][1]/div/div") List<WebElement> totalCols;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div") List<WebElement> tableHeader;
    //*[@id="app"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]
    //*[@id="app"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]*/


    public void addEmployee(String fname, String lname) throws InterruptedException {
        //Adding a New Employee
        pim.click();
        addEmployeeBtn.click();
        firstName.click();
        firstName.sendKeys(fname);
        lastName.click();
        lastName.sendKeys(lname);
        saveBtn.click();
        Thread.sleep(5000);
    }

    public void searchEmployee(String searchEmployeeName) throws InterruptedException {
        pim.click();
        employeeList.click();
        employeeName.sendKeys(searchEmployeeName);
        searchBtn.click();
        Thread.sleep(5000);

        String totalRecords = element.get(0).getText();
        System.out.println(totalRecords);

        //Searching Employee By Name
        for (int i=2;i< tableHeader.size();i++){
            System.out.print(tableHeader.get(i).getText()+" | ");
        }

        System.out.println("\n"+"--------------------------------------------------");
        for (int i=1;i<=totalRows.size();i++){
            List<WebElement> colsContent = driver.findElements(By.xpath("//div[@class='oxd-table-card']["+ i + "]/div/div"));
            for (int j = 1; j< totalCols.size(); j++){
                System.out.print(colsContent.get(j).getText()+"     |   ");
            }
            System.out.println();
        }
        System.out.println("\n"+"--------------------------------------------------");
    }

    public void printEmployeeList(){

        pim.click();
        employeeList.click();

        String totalRecords = element.get(0).getText();
        System.out.println(totalRecords);

        //Searching Employee By Name
        for (int i=2;i< tableHeader.size();i++){
            System.out.print(tableHeader.get(i).getText()+" | ");
        }

        System.out.println("\n"+"--------------------------------------------------");
        for (int i=1;i<=totalRows.size();i++){
            List<WebElement> colsContent = driver.findElements(By.xpath("//div[@class='oxd-table-card']["+ i + "]/div/div"));
            for (int j = 1; j< totalCols.size(); j++){
                System.out.print(colsContent.get(j).getText() +"     |   ");
            }
            System.out.println();
        }
        System.out.println("\n"+"--------------------------------------------------");
    }
}
