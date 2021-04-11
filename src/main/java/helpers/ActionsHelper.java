package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsHelper {

    public static void selectValueDropdownAndWait(WebDriver driver, String webElementLocator, String textToSearch, String textToWaitFor){
        WebElement webElement = driver.findElement(By.xpath(webElementLocator));
        webElement.sendKeys(textToSearch);
        webElement.sendKeys(Keys.RETURN);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//*[text() = '%s']", textToWaitFor))));
    }

    public static void waitForNotificationMessage(WebDriver driver, String projectName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//p[text() = 'Successfully created your project ']//a[text() = '%s']", projectName))));
    }
}
