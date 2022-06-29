package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {
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
    public void iframe() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement baslikElementi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.isEnabled());
        System.out.println(baslikElementi.getText());
        WebElement iframe=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement textbox=driver.findElement(By.xpath("//p"));
        textbox.clear();
        textbox.sendKeys("Merhaba Dunya");
        driver.switchTo().defaultContent();
        WebElement linkText=driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkText.isDisplayed());
        System.out.println(linkText.getText());
        Thread.sleep(3000);


    }
}
