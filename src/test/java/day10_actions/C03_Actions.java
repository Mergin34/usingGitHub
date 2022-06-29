package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_Actions extends TestBase {
    @Test
    public void mouseActions1(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions=new Actions(driver);
        WebElement lineElement=driver.findElement(By.id("hot-spot"));
        actions.contextClick(lineElement).perform();
        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        driver.switchTo().alert().accept();
        String ilkSayfaWHDegeri=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@target='_blank']")).click();
        Set<String> handleSeti =driver.getWindowHandles();
        String ikinciSayfaWHDegeri = "";
        System.out.println(handleSeti);

        for (String each : handleSeti
        ) {
            if (!each.equals(ilkSayfaWHDegeri)) {
                ikinciSayfaWHDegeri = each;
            }
        }
        driver.switchTo().window(ikinciSayfaWHDegeri);
        WebElement ESD=driver.findElement(By.xpath("//h1"));
        String expectedS="Elemental Selenium";
        String actualS=ESD.getText();
        Assert.assertEquals(expectedS,actualS);

    }
}
