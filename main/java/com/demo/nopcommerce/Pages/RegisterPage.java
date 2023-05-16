package com.demo.nopcommerce.Pages;

import com.demo.nopcommerce.Utilities.Constant;
import com.demo.nopcommerce.Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver driver;

    Utils utils;

    By registerLink = By.className("ico-register");
    By Firstname = By.id("FirstName");
    By Lastname = By.id("LastName");

    By Email = By.id("Email");
    By Password = By.id("Password");
    By ConformPassword = By.id("ConfirmPassword");
    By RegisterButton = By.className("button-1 register-next-step-button");


    public RegisterPage(WebDriver driver){
        this.driver = driver;
        utils = new Utils(driver);
    }

    public void clickOnRegisterLink(){
        utils.doClick(RegisterLink);
    }

    public String getPageTitle(){
        return utils.waitForTitlePresent(5, Constant.REGISTER_PAGE_TITLE);
    }

    public void doRegisteration(String Firstname, String Lastname, String Email, String Password, String ConformPassword){
        utils.doSendkey(By.id(Firstname),Firstname);
        utils.doSendkey(By.id(Lastname),Lastname);
        utils.doSendkey(By.id(Email),Email);
        utils.doSendkey(By.id(Password),Password);
        utils.doSendkey(By.id(ConformPassword),ConformPassword);
        utils.doClick(RegisterButton);
    }
}
