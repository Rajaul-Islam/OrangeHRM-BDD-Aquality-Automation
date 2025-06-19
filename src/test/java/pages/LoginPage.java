package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import constants.LocatorConstants;
import org.openqa.selenium.By;

import static constants.LocatorConstants.PRECISE_TEXT_XPATH;

public class LoginPage extends Form {
    public LoginPage() {
        super(By.cssSelector(".orangehrm-login-title"), "Login Page");
    }

    public final ITextBox usernameTextBox = getElementFactory().getTextBox(By.name("username"), "Username TextBox");
    public final ITextBox passwordTextBox = getElementFactory().getTextBox(By.name("password"), "Password TextBox");
    public final IButton loginButton = getElementFactory().getButton(By.cssSelector("button[type='submit']"), "Login Button");
    public final ILabel invalidCredentialsLabel = getElementFactory().getLabel(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH,"Invalid credentials")), "Invalid Credentials Label");
    public final ILabel emptyTextFieldErrorLabel = getElementFactory().getLabel(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH,"Required")), "Empty Text Field Error Label");
    public void enterUsername(String username) {
        usernameTextBox.clearAndType(username);
    }

    public void emptyUsername() {
        usernameTextBox.clearAndType("");
    }

    public void enterPassword(String password) {
        passwordTextBox.clearAndType(password);
    }

    public void emptyPassword(String password) {
        passwordTextBox.clearAndType(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getErrorMessageText() {
        return invalidCredentialsLabel.getText();
    }

    public String getEmptyTextFieldErrorMessage() {
        return emptyTextFieldErrorLabel.getText();
    }

    public boolean emptyTextFieldErrorMessage() {
        return emptyTextFieldErrorLabel.state().isDisplayed();}
}
