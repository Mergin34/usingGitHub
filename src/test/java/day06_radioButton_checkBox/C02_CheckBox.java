package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CheckBox {
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
        //driver.close();
    }

    @Test
    public void test01() {
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBoxButtonOne=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBoxButtonTwo=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        if (! checkBoxButtonOne.isSelected()){
            checkBoxButtonOne.click();
        }
        if (! checkBoxButtonTwo.isSelected()){
            checkBoxButtonTwo.click();
        }
    }
}
