package day10_actions;

import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseFirstClass extends TestBase {
    @Test
    public void test01(){
        driver.navigate().to("https://www.amazon.com");
    }
}
