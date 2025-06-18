package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginPageSteps {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashBoardpage = new DashboardPage();
//    Given I open the OrangeHRM login page
//
//    Scenario: TC_Login_01 - Verify successful login with valid credentials
//    When I enter username "Admin"
//    And I enter password "admin123"
//    And I click the login button
//    Then I should see the dashboard page
    @Given("I open the OrangeHRM login page$")
    public void openLoginPage() {
        Assert.assertTrue(loginPage.state().waitForDisplayed(), "Login page is not displayed");
    }
    @When("I enter username {string}")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
    }
    @And("I enter password {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }
    @And("I click the login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }
    @Then("I should see the dashboard page")
    public void verifyDashboardPage() {
        Assert.assertTrue(dashBoardpage.state().waitForDisplayed(), "Dashboard page is not displayed");
    }
}
