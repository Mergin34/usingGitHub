package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C03_IstenenWebElementSS extends TestBase {
    @Test
    public void webElementSS() throws IOException {
        driver.get("https://www.amamzon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        File fullPagePic = new File("target/screenShot/fullPage.png");
        File temp = sonucYaziElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp, fullPagePic);
    }
}
