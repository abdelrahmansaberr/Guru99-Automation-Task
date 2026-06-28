package com.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomer {
    WebDriver driver;

    public AddCustomer(WebDriver driver) {
        this.driver = driver;
    }

    protected By doneBtn = By.xpath("//label[@for='done']");
    protected By firstName = By.id("fname");
    protected By lastName = By.id("lname");
    protected By email = By.id("email");
    protected By addressField = By.name("addr");
    protected By phone = By.id("telephoneno");
    protected By submit = By.name("submit");
    protected By customerID = By.xpath("//*[@id='main']//h3");

    public void BGcheck(){
        driver.findElement(doneBtn).click();
    }

    public void fillCustomerFields(String fname, String lname, String mail, String addrs, String mobile){
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(addressField).sendKeys(addrs);
        driver.findElement(phone).sendKeys(mobile);
    }

    public void submitCustomer(){
        driver.findElement(submit).click();
    }

    public String getCustomerID(){
        return driver.findElement(customerID).getText().trim();
    }
}