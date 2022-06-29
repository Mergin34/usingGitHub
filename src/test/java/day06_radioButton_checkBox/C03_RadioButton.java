package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
       driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.navigate().to("https://facebook.com");
        driver.findElement(By.xpath("(//button[@value='1'])[3]")).click();
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement famaleButton = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement maleButton = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement costomButton = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
        Thread.sleep(2000);
        if (!maleButton.isSelected()) {
            maleButton.click();

        }
        Thread.sleep(2000);
        famaleButton.click();
        Thread.sleep(2000);
        costomButton.click();
    }
}
