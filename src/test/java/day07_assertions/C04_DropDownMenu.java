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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select options=new Select(ddm);
        options.selectByVisibleText("Books");
        //options.selectByIndex(5);
        //options.selectByValue("search-alias=stripbooks");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java"+Keys.ENTER);
        WebElement javaResult=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        String resultView=javaResult.getText();
        String searchingWord="java";
        Assert.assertTrue(resultView.contains(searchingWord));
    }
}
