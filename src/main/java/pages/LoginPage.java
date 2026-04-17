package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By email = By.id("email");
    By password = By.xpath("//input[@type='password']");
    By loginBtn = By.xpath("(//button[@type='submit'])[1]");

    public void login(String mail, String pass) {
        driver.findElement(email).sendKeys(mail);
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {

        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].click();",
                driver.findElement(loginBtn));
    }
}