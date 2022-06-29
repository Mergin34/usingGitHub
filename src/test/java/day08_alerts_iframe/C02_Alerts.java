package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
   static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    @Test
    public void acceptAlert(){
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        String expectedResultYazisi="You successfully clicked an alert";
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[@id='result']"));
        String actualResultYazisi= sonucYazisi.getText();
        Assert.assertEquals(actualResultYazisi,expectedResultYazisi);
    }
    @Test
    public void dismissAlert(){
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String istenmeyenKelime="successfully";
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[@id='result']"));
        String actualResultYazisi= sonucYazisi.getText();
        Assert.assertFalse(actualResultYazisi.contains(istenmeyenKelime));
    }
    @Test
    public void sendKeysAlert(){
    driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
    driver.switchTo().alert().sendKeys("mergin");
    driver.switchTo().alert().accept();
    WebElement sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
    String sonucYazisiStr=sonucYazisiElementi.getText();
    String girilenIsim="mergin";
    Assert.assertTrue(sonucYazisiStr.contains(girilenIsim));

    }
}
