package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com");
        WebElement signInButton=driver.findElement(By.xpath("//button[@class='signin btn btn-info']"));
        signInButton.click();
        WebElement userNameButton=driver.findElement(By.xpath("//input[@name='user_login']"));
        WebElement passwordButton=driver.findElement(By.xpath("//input[@name='user_password']"));
        WebElement signInAccess=driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        userNameButton.sendKeys("username");
        passwordButton.sendKeys("password");
        signInAccess.click();
        driver.navigate().back();
        driver.findElement(By.xpath("//a[@id='online-banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        WebElement amountButton=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        amountButton.sendKeys("1500");
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("2020-05-23");
        driver.findElement(By.id("pay_saved_payees")).click();
        WebElement paymentS=driver.findElement(By.xpath("//span[@title='$ 1500 payed to payee sprint']"));

        if (paymentS.isDisplayed()){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.close();

    }
}
