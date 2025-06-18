package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class LoginPage extends Form {
    public LoginPage() {
        super(By.cssSelector(".orangehrm-login-title"), "Login Page");
    }

    public final ITextBox usernameTextBox = getElementFactory().getTextBox(By.name("username"), "Username TextBox");
    public final ITextBox passwordTextBox = getElementFactory().getTextBox(By.name("password"), "Password TextBox");
    public final IButton loginButton = getElementFactory().getButton(By.cssSelector("button[type='submit']"), "Login Button");

    public void enterUsername(String username) {
        usernameTextBox.clearAndType(username);
    }

    public void enterPassword(String password) {
        passwordTextBox.clearAndType(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
