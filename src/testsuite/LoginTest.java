package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.time.Duration;

/**
 * 1. userShouldNavigateToLoginPageSuccessfully()
 * click on the ‘Sign In’ link
 * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage()
 * click on the ‘Sign In’ link
 * Enter the invalid username
 * Enter the invalid password
 * Click on the ‘Sign in’ button
 * Verify the error message ‘Invalid email or password.
 */
public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a")).click();

        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/article/h2")).getText();
        Assert.assertEquals(expectedText, actualText);
    }


    @Test
    public void verifyTheErrorMessage() {

        driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a")).click();
        driver.findElement(By.id("user[email]")).sendKeys("abc@gmail.com");
        driver.findElement(By.name("user[password]")).sendKeys("123456");

        driver.findElement(By.className("button")).click();

        String expectedText = "Invalid email or password.";
        String actualText = driver.findElement(By.xpath("//*[@id=\"notice\"]/ul/li")).getText();
        Assert.assertEquals(expectedText, actualText);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
