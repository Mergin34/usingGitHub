package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void cookiesTest() {
        driver.navigate().to("https://www.amazon.com");
        Set<Cookie> cookiesList=driver.manage().getCookies();
    }
}
