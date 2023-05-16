package com.demo.nopcommerce.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    WebDriver driver;
    Properties prop;
    FileInputStream file;

    public WebDriver initialiseDriver(String browsernamr){
        if(browsernamr.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browsernamr.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else if (browsernamr.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else {
            System.out.println("Browser not match...");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        return driver;
    }
    public Properties initialiesProperties(){

        prop = new Properties();
        try{
             file = new FileInputStream("C:\\Users\\poorn\\IdeaProjects\\POM_Registration_Framework\\src\\test\\TestData\\config.properties");
            prop.load(file);
        }catch(FileNotFoundException e){
            System.out.println("Config file is not found.......");
        }catch (IOException e){
            System.out.println("Properties could not found .....");
        }
        return prop;
    }
}
