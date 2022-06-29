package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_windowHandles {
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
        driver.quit();
    }

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement arananElement = driver.findElement(By.xpath("//h3"));
        String expectedYazi = "Opening a new window";
        String actualYazi = arananElement.getText();
        Assert.assertEquals(expectedYazi, actualYazi);
        String arananTitle = "The Internet";
        String pageTitle = driver.getTitle();
        Assert.assertEquals(arananTitle, pageTitle);
        String ilkSayfaHandleDegeri = driver.getWindowHandle();
        System.out.println(ilkSayfaHandleDegeri);
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windowHandleSeti = driver.getWindowHandles();
        System.out.println(windowHandleSeti);
        String ikinciSayfaWindowHandleDegeri = "";
        for (String each : windowHandleSeti
        ) {
            if (!each.equals(ilkSayfaHandleDegeri)) {
                ikinciSayfaWindowHandleDegeri = each;
            }
        }
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);
        String expectedNW = "New Window";
        String actualNW = driver.getTitle();
        Assert.assertEquals(expectedNW, actualNW);
        WebElement NWElement = driver.findElement(By.xpath("//h3"));
        String expectedNW2 = "New Window";
        String actualNW2 = NWElement.getText();
        Assert.assertEquals(expectedNW2, actualNW2);
        driver.switchTo().window(ilkSayfaHandleDegeri);
        arananTitle = "The Internet";
        pageTitle = driver.getTitle();
        Assert.assertEquals(arananTitle, pageTitle);


    }
}
