package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//*[text()='dummy.txt.txt']")).click();
        Thread.sleep(5000);
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\dummy.txt.txt";
        String arananDosyaYolu=farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));
    }
}
