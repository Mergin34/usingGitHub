package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C01_MevanFirstClass {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://amazon.com");
        driver.close();
    }
}
