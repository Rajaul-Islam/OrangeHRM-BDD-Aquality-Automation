package hooks;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.EnvDataReader;

import static io.qameta.allure.Allure.step;

public class Hooks {
    private Browser browser = AqualityServices.getBrowser();

    @Before
    public void setUp() {
        browser.maximize();
        step("Open the application in browser");
        browser.goTo(EnvDataReader.getEnvData().getHost());
    }

    @After
    public void tearDown() {
        if (browser.isStarted()) {
            step("Close the browser");
            browser.quit();
        }
    }
}