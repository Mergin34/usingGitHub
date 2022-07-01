package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {
    @Test
    public void webTableTest() {
    girisYap();
    List<WebElement> sutunBasliklariListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("sutun sayisi : " +sutunBasliklariListesi.size());
        WebElement tumBody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());
        List<WebElement> satirlarListesi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println(satirlarListesi.size());
        for (WebElement each: satirlarListesi
             ) {
            System.out.println(each.getText());
        }
        List<WebElement> cellList=driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each:cellList
             ) {
            System.out.println(each.getText());
        }
        List<WebElement> basliklarListesi=driver.findElements(By.xpath("//thead//th[1]//th"));
        int emailSutunNo=0;
        for (int i = 0; i <basliklarListesi.size() ; i++) {
            if  (basliklarListesi.get(i).getText().equals("BirthDate")){
                emailSutunNo=i;
            }
        }
        List<WebElement> emailSutunList=
                driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        for (WebElement each:emailSutunList
             ) {
            System.out.println(each.getText());
        }
    }
    public void girisYap(){
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions= new Actions(driver);
        WebElement username=driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
    }

}
