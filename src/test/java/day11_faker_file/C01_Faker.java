package day11_faker_file;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.navigate().to("https://www.facebook.com");
        driver.findElement(By.xpath("(//button[@value='1'])[3]")).click();
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        WebElement nameElement=driver.findElement(By.name("firstname"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String fakeMail=faker.internet().emailAddress();
        actions.click(nameElement)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeMail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeMail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("22")
                .sendKeys(Keys.TAB)
                .sendKeys("Oca")
                .sendKeys(Keys.TAB)
                .sendKeys("1939")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        Thread.sleep(3000);
    }
}