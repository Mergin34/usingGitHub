package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void KeyboardActions2() {
        driver.get("https://html.com/tags/iframe/");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement iframeElement=driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframeElement);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
        WebElement YTP=driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(YTP.isDisplayed());
    }
}
