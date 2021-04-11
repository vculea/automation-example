package com.sdl.lc.project.login;

import com.sdl.lc.pages.LoginView;
import com.sdl.lc.project.TestBase;
import com.sdl.selenium.web.utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class LoginSteps extends TestBase {
    private final LoginView loginView = new LoginView();

    @Then("I logout from LC")
    public void logout() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @Given("I open url {string}")
    public void iOpenUrl(String url) {
        driver.get(url);
    }

    @And("I stop the test")
    public void iStopTheTest() {
        Utils.sleep(1);
    }

    @When("I login with {string} and {string}")
    public void iLoginWithAnd(String email, String password) {
        driver.findElement(By.name(loginView.getEmail())).sendKeys(email);
        driver.findElement(By.name(loginView.getPassword())).sendKeys(password);
        driver.findElement(By.name(loginView.getLogIn())).click();
    }
}