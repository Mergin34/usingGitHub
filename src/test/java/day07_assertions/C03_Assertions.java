package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationpractice.com/index.php");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        WebElement signInButton = driver.findElement(By.xpath("//a[@class='login']"));
        signInButton.click();
        WebElement emailButton = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        emailButton.sendKeys("mergingmail.com"+ Keys.ENTER);
        WebElement invalidEmail = driver.findElement(By.xpath("//ol[*='Invalid email address.']"));
        Assert.assertTrue(invalidEmail.isDisplayed());
    }
}
