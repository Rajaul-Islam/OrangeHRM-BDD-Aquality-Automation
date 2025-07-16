package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DashboardPage extends Form {
    private final ILabel userProfile = getElementFactory().getLabel(By.className("oxd-userdropdown-img"), "user profile image");

    public DashboardPage() {
        super(By.className("oxd-topbar-header-breadcrumb-module"), "Dashboard Page");
    }

    @Step("Verify user loin successfully and check user in the dashboard page")
    public Boolean isUserProfileDisplayed(){
        return userProfile.state().waitForDisplayed();
    }
}