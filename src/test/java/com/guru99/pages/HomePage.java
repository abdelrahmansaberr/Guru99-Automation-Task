package com.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected By sideMenuBtn = By.xpath("//a[@href='#menu']");
    protected By sidePanel = By.id("menu");
    protected By addCustomerTask = By.xpath("//nav[@id='menu']//a[text()='Add Customer']");
    protected By addTariffTask = By.xpath("//nav[@id='menu']//a[text()='Add Tariff Plan to Customer']");

    public void openSideMenu(){
        WebElement menuBtn = wait.until(ExpectedConditions.elementToBeClickable(sideMenuBtn));
        menuBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(sidePanel));
    }

    public void clickAddCustomerTask(){
        openSideMenu();
        wait.until(ExpectedConditions.elementToBeClickable(addCustomerTask)).click();
    }

    public void clickAddTariffTask(){
        openSideMenu();
        wait.until(ExpectedConditions.elementToBeClickable(addTariffTask)).click();
    }
}