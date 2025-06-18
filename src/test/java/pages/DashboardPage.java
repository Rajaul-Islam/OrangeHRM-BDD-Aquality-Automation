package pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class DashboardPage extends Form {
    public DashboardPage(){
        super(By.className("oxd-topbar-header-breadcrumb-module"), "Dashboard Page");
    }
}
