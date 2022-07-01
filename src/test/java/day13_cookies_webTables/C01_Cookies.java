package day13_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void cookiesTest() {
        driver.navigate().to("https://www.amazon.com");
        Set<Cookie> cookiesSet=driver.manage().getCookies();
        System.out.println(cookiesSet);
        int count=1;
        for (Cookie each:cookiesSet
             ) {
            System.out.println(count + ".ci cookie : " +each);
            System.out.println("name  : " +each.getName());
            System.out.println("value  : " +each.getValue());
            count++;
        }
        int cookieSayisi=cookiesSet.size();
        Assert.assertTrue(cookieSayisi>5);
        for (Cookie each: cookiesSet
             ) {
            if (each.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",each.getValue());
            }
        }
        Cookie cookie=new Cookie("ne sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        count=1;
        cookiesSet=driver.manage().getCookies();
        for (Cookie each:cookiesSet
        ) {
            System.out.println(count + ".ci cookie : " +each);
            count++;
        }
        Assert.assertTrue(cookiesSet.contains(cookie));
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookiesSet.contains("skin"));
        driver.manage().deleteAllCookies();
        cookiesSet=driver.manage().getCookies();
        Assert.assertTrue(cookiesSet.isEmpty());

    }
}
