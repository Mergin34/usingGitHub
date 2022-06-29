package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement fileElement = driver.findElement(By.xpath("//input[@id='file-upload']"));
        String differencePart = System.getProperty("user.home");
        String jointPart = "\\Desktop\\text.txt";
        String uploadFile = differencePart + jointPart;
        fileElement.sendKeys(uploadFile);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        WebElement yaziElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yaziElementi.isDisplayed());
    }
}
