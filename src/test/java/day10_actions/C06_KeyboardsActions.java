package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardsActions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.navigate().to("https://www.facebook.com");
        driver.findElement(By.xpath("(//button[@value='1'])[3]")).click();
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        WebElement nameElement=driver.findElement(By.name("firstname"));
        Actions actions=new Actions(driver);
        actions.click(nameElement)
                .sendKeys("Hussein")
                .sendKeys(Keys.TAB)
                .sendKeys("Dey")
                .sendKeys(Keys.TAB)
                .sendKeys("husseindey@algeria.com")
                .sendKeys(Keys.TAB)
                .sendKeys("husseindey@algeria.com")
                .sendKeys(Keys.TAB)
                .sendKeys("huseyin225.")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("20")
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
