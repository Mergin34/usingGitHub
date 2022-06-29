package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri= driver.getWindowHandle();
        String searchingWord="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(searchingWord));
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com/");
        String ikinciSayfaHandleDegeri=driver.getWindowHandle();
        String actualTitle=driver.getTitle();
        String wantsTitle="Best Buy";
        Assert.assertTrue(actualTitle.contains(wantsTitle));
        driver.switchTo().window(ilkSayfaHandleDegeri);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);
        WebElement javaSearhResult=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actual=javaSearhResult.getText();
        String expected="Java";
        Assert.assertTrue(actual.contains(expected));
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        WebElement logoElement=driver.findElement(By.xpath("//img[@class='logo']"));
        Assert.assertTrue(logoElement.isDisplayed());

    }
}
