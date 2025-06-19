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

    @When("I leave the username field empty")
    public void leaveUsernameEmpty() {
        loginPage.emptyUsername();
    }

    @And("I enter password {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("I leave the password field empty")
    public void leavePasswordEmpty() {
        loginPage.emptyPassword("");
    }

    @And("I click the login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the dashboard page")
    public void verifyDashboardPage() {
        Assert.assertTrue(dashBoardpage.state().waitForDisplayed(), "Dashboard page is not displayed");
    }

    @Then("I should see an error message {string}")
    public void verifyErrorMessage(String expectedError) {
        String actualError = loginPage.getErrorMessageText();
        Assert.assertEquals(actualError.trim(), expectedError, "Error message does not match");
    }

    @Then("I should see an empty text field error message with {string} text")
    public void verifyEmptyTextFieldErrorMessage(String expectedError) {
        String actualError = loginPage.getEmptyTextFieldErrorMessage();
        System.out.println("Actual: [" + actualError + "], Expected: [" + expectedError + "]");
        Assert.assertEquals(actualError.trim(), expectedError.trim(), "Empty text field error message does not match");
    }
}
