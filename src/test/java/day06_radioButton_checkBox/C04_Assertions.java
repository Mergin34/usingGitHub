package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        driver.navigate().to("https://amazon.com");
/*
        if (driver.getCurrentUrl().equals("https://facebook.com")) {
            System.out.println("Url test Passed");
        } else {
            System.out.println("Url test Failed");
        }
*/
        String expectedUrl="https://facebook.com";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
