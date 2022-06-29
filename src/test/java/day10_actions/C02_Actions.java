package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.navigate().to("https://www.amazon.com");

        Actions actions=new Actions(driver);
        WebElement accountListElement=driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountListElement).perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();


    }
}
