package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.StubMethod;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_DropDown {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        WebElement ddm = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Option 2");

        List<WebElement> allDropDList = select.getOptions();
        for (WebElement each : allDropDList
        ) {
            System.out.println(each.getText());
        }

        int dropDown= allDropDList.size();
        if (dropDown==4){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
