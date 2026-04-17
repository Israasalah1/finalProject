package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.ArrayList;

public class EyouthTests extends BaseTest {

    @Test
    public void searchTest() {

        HomePage home = new HomePage(driver);

        home.search("كيف تنضم الي البنك");

        Assert.assertTrue(driver.getPageSource().contains("البنك"));
    }

    @Test
    public void openCourseTest() throws Exception {

        HomePage home = new HomePage(driver);
        CoursesPage courses = new CoursesPage(driver);

        home.openAllCourses();

        Thread.sleep(2000);

        courses.openFirstCourse();

        Thread.sleep(2000);

        Assert.assertTrue(driver.getPageSource().contains("الدورة"));
    }

    @Test
    public void openRegisterTest() throws Exception {

        HomePage home = new HomePage(driver);

        home.openRegister();

        Thread.sleep(2000);

        Assert.assertTrue(driver.getPageSource().contains("إنشاء"));
    }

    @Test
    public void loginInvalidTest() throws Exception {

        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.openLogin();

        Thread.sleep(2500);

        login.login("test@test.com","123456");

        Thread.sleep(1500);

        login.clickLogin();

        Assert.assertTrue(driver.getPageSource().contains("خطأ"));
    }

    @Test
    public void loginEmptyTest() throws Exception {

        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        home.openLogin();

        Thread.sleep(2500);

        login.clickLogin();

        Assert.assertTrue(driver.getPageSource().contains("مطلوب"));
    }

    @Test
    public void facebookTest(){

        HomePage home = new HomePage(driver);

        home.clickFacebook();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
    }

    @Test
    public void linkedinTest(){

        HomePage home = new HomePage(driver);

        home.clickLinkedin();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        Assert.assertTrue(driver.getCurrentUrl().contains("linkedin"));
    }
}