package day12_synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.time.Instant;

public class C02_ExplicitlyWait extends TestBase {
    @Test
    public void enableTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement textBoxElement=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBoxElement.isEnabled());
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(textBoxElement));
        WebElement itsEnabledButton=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsEnabledButton.isDisplayed());
        Assert.assertTrue(textBoxElement.isEnabled());
    }
}
