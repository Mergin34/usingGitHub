package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C02_fulPageScreenShot extends TestBase {
    @Test
    public void fullPage() throws IOException {
        driver.navigate().to("https://www.bestbuy.com");
        TakesScreenshot ts = (TakesScreenshot) driver;
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);
        File fullPagePic = new File("target/screenShot/fullPage" + tarih + ".png");
        File priortyFile = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(priortyFile, fullPagePic);
    }
}
