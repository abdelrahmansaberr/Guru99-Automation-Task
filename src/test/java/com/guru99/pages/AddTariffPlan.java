package com.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddTariffPlan {

    WebDriver driver;
    WebDriverWait wait;

    public AddTariffPlan(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected By customerIDTextField = By.id("customer_id");
    protected By submitButton = By.name("submit");
    protected By selectTariffPlanRadioButton = By.xpath("//*[@id=\"main\"]/div/form/div[1]/table/tbody/tr/td[1]");
    protected By addTariffPlanButton = By.name("submit");
    protected By successMessage = By.xpath("//h2");

    public void enterCustomerID(String id){
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerIDTextField)).sendKeys(id);

    }

    public void clickidSubmit(){
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public void selectTariffPlan(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectTariffPlanRadioButton)).click();
    }

    public void clickplanSubmit(){
        wait.until(ExpectedConditions.elementToBeClickable(addTariffPlanButton)).click();
    }

    public String getSuccessMessageText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText().trim();
    }
}