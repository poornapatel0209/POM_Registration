import com.demo.nopcommerce.Base.BasePage;
import com.demo.nopcommerce.Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class RegisterTestPage {
    WebDriver driver;
    BasePage basePage;
    Properties prop = new Properties();
    RegisterPage registerPage;
@BeforeMethod
    public void openBrowser(){
        basePage=new BasePage();
        prop = basePage.initialiesProperties();
        String webEngine = prop.getProperty("browser");
        driver = basePage.initialiseDriver(webEngine);
        driver.get(prop.getProperty("url"));
        registerPage = new RegisterPage(driver);
    }
    @Test
    public void registerTest(){
        registerPage.clickOnRegisterLink();
        registerPage.getPageTitle();
        registerPage.doRegisteration(prop.getProperty("Firstname"),prop.getProperty("Lastname"),prop.getProperty("Email"),prop.getProperty("Password"),prop.getProperty("ConformPassword"));

    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
