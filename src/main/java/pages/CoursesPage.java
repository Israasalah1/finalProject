package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursesPage {

    WebDriver driver;

    public CoursesPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstCourse =
            By.xpath("(//a[contains(@href,'course')])[1]");

    public void openFirstCourse() {
        driver.findElement(firstCourse).click();
    }
}