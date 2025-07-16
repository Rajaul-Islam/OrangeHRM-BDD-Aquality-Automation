package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends Form {
    private static final By pageTitle = By.cssSelector(".orangehrm-login-title");
    private final ITextBox usernameTextbox = getElementFactory().getTextBox(By.cssSelector("[name='username']"), "Username TextBox");
    private final ITextBox passwordTextbox = getElementFactory().getTextBox(By.cssSelector("input[name='password']"), "Password text box");
    private final ILabel requiredTextField = getElementFactory().getLabel(By.xpath("//span[text()='Required']"), "required error Text");
    private final IButton submitButton = getElementFactory().getButton(By.cssSelector("button[type='submit']"), "Submit button");
    private final ILabel invalidErrorField = getElementFactory().getLabel(By.xpath("//p[text()='Invalid credentials']"), "Invalid credential label");

    public LoginPage() {
        super(pageTitle, "Login Page");
    }

    @Step("Enter user valid usernaem")
    public void enterUsername(String username) {
        usernameTextbox.clearAndType(username);
    }

    @Step("Remain username empty")
    public void emptyUsername() {
        usernameTextbox.clearAndType("");
    }

    @Step("Enter valid password")
    public void enterPassword(String password) {
        passwordTextbox.clearAndType(password);
    }

    @Step("Remain password filed empty")
    public void emptyPassword(String password) {
        passwordTextbox.clearAndType(password);
    }

    @Step("Click on login button")
    public void clickLoginButton() {
        submitButton.click();
    }

    @Step("Ge the error message for invalid user")
    public String getErrorMessageText() {
        return invalidErrorField.getText();
    }

    @Step("Get the error message for empty username")
    public String getEmptyTextFieldErrorMessage() {
        return requiredTextField.getText();
    }

    @Step("Get the error message for empty password")
    public boolean emptyTextFieldErrorMessage() {
        return requiredTextField.state().isDisplayed();
    }
}
