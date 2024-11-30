package Pages;

import Utilities.BrowserFactory;
import Utilities.ConfigDataProviders;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;
    public ConfigDataProviders config;

    @BeforeClass
    public void setUp(){
        config = new ConfigDataProviders();
        driver = BrowserFactory.startApplication(driver,config.getBrowser(), config.getStagingUrl());
    }

    @AfterClass
    public void tearDown(){
        BrowserFactory.quitBrowser(driver);
    }
}
