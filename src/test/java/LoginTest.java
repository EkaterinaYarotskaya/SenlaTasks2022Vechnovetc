import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginTest extends FixedData {
    @Test
    public void Test() {
        driver.findElement(By.xpath("//*[@id=\"login_name\"]")).sendKeys("login");
        ;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        String expected = "Логин: ";
//        Assertions.assertEquals(expected,actual);
    }
}
