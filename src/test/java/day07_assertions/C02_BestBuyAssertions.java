package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BestBuyAssertions {
   static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
    @Test
    public void test02(){
        String istenmeyenWord="Rest";
        String title=driver.getTitle();
        Assert.assertFalse( title.contains(istenmeyenWord));
    }
    @Test
    public void test03(){
        WebElement logoTest=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoTest.isDisplayed());
    }
    @Test
    public void test04(){
        WebElement frLinkTest=driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(frLinkTest.isDisplayed());
    }
}
