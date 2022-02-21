
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

public class ExitTest extends FixedData {
    String CORRECT_LOGIN = "tomsmith";
    String CORRECT_PASSWORD = "SuperSecretPassword!";

    @Test
    public void logoutTest() {
        driver.findElement(By.id("username")).sendKeys(CORRECT_LOGIN);
        driver.findElement(By.id("password")).sendKeys(CORRECT_PASSWORD);
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.cssSelector("a.button.secondary")).click();
        String actual = driver.findElement(By.cssSelector("#content > div > h2")).getText();
        System.out.println(actual);
        String expected = "Login Page";
        Assertions.assertEquals(expected, actual);
    }
}