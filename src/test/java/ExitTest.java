
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

public class ExitTest extends FixedData {
    String CORRECT_LOGIN = "login";
    String CORRECT_PASSWORD = "password";
    @Test
    public void Test1() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//*[text()='Вход']")).click();
        driver.findElement(By.xpath("//*[@id=\"login_name\"]")).sendKeys(CORRECT_LOGIN);
        driver.findElement(By.xpath("//*[@name='login_password']")).sendKeys(CORRECT_PASSWORD);
        driver.findElement(By.xpath("//*[text()=\"Войти\"]")).click();
        driver.findElement(By.xpath("//*[@class='thide lexit']")).click();
        String actual = driver.findElement(By.xpath("//*[@onclick=\"change('test')\"]")).getText();
        String expected = "Вход";
        Thread.sleep(5000);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void Test2() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//*[text()='Вход']")).click();
        driver.findElement(By.xpath("//*[@id=\"login_name\"]")).sendKeys(CORRECT_LOGIN);
        driver.findElement(By.xpath("//*[@name='login_password']")).sendKeys(CORRECT_PASSWORD);
        driver.findElement(By.xpath("//*[text()=\"Войти\"]")).click();
        driver.findElement(By.xpath("//*[@class='thide lexit']")).click();
        String actual = driver.findElement(By.xpath("//*[@onclick=\"change('test')\"]")).getText();
        String expected = "Выход";
        Thread.sleep(5000);
        Assertions.assertNotEquals(expected, actual);

    }
}