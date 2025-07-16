package com.wizeline.steps;

import com.wizeline.pages.LoginPage;
import com.wizeline.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("I open the login page")
    public void iOpenTheLoginPage() {
        loginPage = new LoginPage(DriverManager.getDriver());  // Obtener el WebDriver desde DriverManager
        loginPage.openLoginPage();
    }

    @When("I enter the username {string} and password {string}")
    public void iEnterTheUsernameAndPassword(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should see the login page title")
    public void iShouldSeeTheLoginPageTitle() {
        assertTrue(loginPage.isLoginPageDisplayed());
    }

    @Then("I should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String errorMessage) {
        assertTrue(loginPage.getErrorMessage().contains(errorMessage));
    }
}
