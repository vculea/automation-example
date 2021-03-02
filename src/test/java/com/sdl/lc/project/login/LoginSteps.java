package com.sdl.lc.project.login;

import com.sdl.lc.common.LoginView;
import com.sdl.lc.project.TestBase;
import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
public class LoginSteps extends TestBase {
    private final LoginView loginView = new LoginView();

    @Then("I logout from LC")
    public void logout() {
        WebDriverConfig.getDriver().manage().deleteAllCookies();
        WebDriverConfig.getDriver().navigate().refresh();
    }

    @Given("I open url {string}")
    public void iOpenUrl(String url) {
        WebDriverConfig.getDriver().get(url);
    }

    @And("I stop the test")
    public void iStopTheTest() {
        Utils.sleep(1);
    }

    @When("I login with {string} and {string}")
    public void iLoginWithAnd(String email, String password) {
        Utils.sleep(2000);// This sleep is not ok, you have another better idea?
        driver.findElement(By.name(loginView.getEmail())).sendKeys(email);
        driver.findElement(By.name(loginView.getPassword())).sendKeys(password);
        driver.findElement(By.name(loginView.getLogIn())).click();
        Utils.sleep(12000);// This sleep is not ok, you have another better idea?
    }
}