package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    By loginBtn = By.xpath("//a[contains(@href,'login')] | //button[contains(@href,'login')]");
    By registerBtn = By.xpath("//a[contains(@href,'register') or contains(@href,'signup')]");
    By allCourses = By.xpath("//a[contains(@href,'/courses')]");
    By searchBox = By.xpath("//input[contains(@placeholder,'بحث')]");

    By facebook = By.xpath("//a[contains(@href,'facebook')]");
    By linkedin = By.xpath("//a[contains(@href,'linkedin')]");
    By youtube = By.xpath("//a[contains(@href,'youtube')]");

    public void openLogin(){
        driver.findElement(loginBtn).click();
    }

    public void openRegister(){
        driver.findElement(registerBtn).click();
    }

    public void openAllCourses(){
        driver.findElement(allCourses).click();
    }

    public void search(String text){
        driver.findElement(searchBox).sendKeys(text);
    }

    public void clickFacebook(){
        scroll();
        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].click();",
                driver.findElement(facebook));
    }

    public void clickLinkedin(){
        scroll();
        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].click();",
                driver.findElement(linkedin));
    }

    public void clickYoutube(){
        scroll();
        ((JavascriptExecutor)driver).executeScript(
                "arguments[0].click();",
                driver.findElement(youtube));
    }

    private void scroll(){
        ((JavascriptExecutor)driver)
                .executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
}