
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

public class ExitTest extends FixedData {
    String CORRECT_LOGIN = "tomsmith";
    String CORRECT_PASSWORD = "SuperSecretPassword!";

    @Test
    public void Test1() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(CORRECT_LOGIN);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(CORRECT_PASSWORD);
        driver.findElement(By.xpath("//button/i[@class='fa fa-2x fa-sign-in']")).click();
        driver.findElement(By.xpath("//*[@class='icon-2x icon-signout']")).click();
        String actual = driver.findElement(By.xpath("//*[text()='Login Page']")).getText(); //тут то же самое. Ты нашла элемент, который содержит текст
        // и проверяешь, что он содержит текст.
        System.out.println(actual);
        String expected = "Login Page";
        Thread.sleep(5000);
        Assertions.assertEquals(expected, actual);
    }
}