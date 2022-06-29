package day12_synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {
    @Test
    public void waitTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        WebElement itsGoneElement=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGoneElement.isDisplayed());
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        WebElement itsBackElement=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackElement.isDisplayed());

    }

    @Test
    public void explicitlyWaitTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
       //WebElement itsGoneElement=driver.findElement(By.xpath("//p[@id='message']"));
       //wait.until(ExpectedConditions.visibilityOf(itsGoneElement));
       //Assert.assertTrue(itsGoneElement.isDisplayed());

        WebElement itsGoneElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsGoneElement.isDisplayed());
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        WebElement itsBackElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(itsBackElement.isDisplayed());
    }
}
