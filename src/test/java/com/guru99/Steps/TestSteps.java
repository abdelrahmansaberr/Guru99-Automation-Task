package com.guru99.Steps;

import com.guru99.pages.AddCustomer;
import com.guru99.pages.AddTariffPlan;
import com.guru99.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class TestSteps {

    private static WebDriver driver;
    private static String savedCustomerId;

    AddCustomer addCustomer;
    AddTariffPlan addTariffPlan;
    HomePage homePage;

    public void initPages() {
        homePage = new HomePage(driver);
        addCustomer = new AddCustomer(driver);
        addTariffPlan = new AddTariffPlan(driver);
    }

    @Before
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        initPages();
    }

    // Test Case 1: Successfully create a new customer

    @Given("the user on the home page")
    public void the_user_on_the_home_page() {
        driver.get("https://demo.guru99.com/telecom");
    }

    @When("the user clicks on Add Customer from the side menu")
    public void the_user_clicks_on_Add_Customer_from_the_side_menu() {
        homePage.clickAddCustomerTask();
    }

    @And("the user checks the background button")
    public void the_user_checks_the_background_button() {
        addCustomer.BGcheck();
    }

    @And("fills out the customer form")
    public void fills_out_the_customer_form() {
        addCustomer.fillCustomerFields("abdelrahman", "saber", "abdo@test.com", "cairo", "01110550022");
    }

    @And("clicks the customer submit button")
    public void clicks_the_customer_submit_button() {
        addCustomer.submitCustomer();
    }

    @Then("customer ID should be generated and captured")
    public void customer_id_should_be_generated_and_captured() {
        savedCustomerId = addCustomer.getCustomerID();
    }

    // Test Case 2: Assign a tariff plan to the generated customer ID

    @Given("the user on homepage")
    public void the_user_on_homepage() {
        driver.get("https://demo.guru99.com/telecom");
    }

    @When("the user clicks on Add Tariff Plan to Customer from the side menu")
    public void user_adds_tariff_plan_to_customer_from_the_side_menu() {
        homePage.clickAddTariffTask();
    }

    @And("enters the saved Customer ID")
    public void enters_the_saved_customer_id() {
        addTariffPlan.enterCustomerID(savedCustomerId);
    }

    @And("clicks the ID submit button")
    public void clicks_the_id_submit_button() {
        addTariffPlan.clickidSubmit();
    }

    @And("selects a tariff plan radio button")
    public void selects_a_tariff_plan_radio_button() {
        addTariffPlan.selectTariffPlan();
    }

    @And("clicks the plan submit button")
    public void clicks_the_plan_submit_button() {
        addTariffPlan.clickplanSubmit();
    }

    @Then("the confirmation message Congratulation Tariff Plan Assigned should appear")
    public void the_confirmation_message_Congratulation_Tariff_Plan_Assigned_should_appear() {
        String actualMessage = addTariffPlan.getSuccessMessageText();
        Assert.assertEquals(actualMessage, "Congratulation Tariff Plan assigned");
    }

    @After
    public void afterTest() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @And("scroll down the page")
    public void scrollDownThePage() {

    }
}