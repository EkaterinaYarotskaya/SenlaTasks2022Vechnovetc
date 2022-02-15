import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import java.time.Duration;

public class LoginTest extends FixedData {
    String CORRECT_LOGIN = "login";
    String CORRECT_PASSWORD = "password";
    String INCORRECT_LOGIN = "login1";
    String INCORRECT_PASSWORD = "password1";
    @Test
    public void Test1() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[text()='Вход']")).click();
        driver.findElement(By.xpath("//*[@id=\"login_name\"]")).sendKeys(CORRECT_LOGIN);
        driver.findElement(By.xpath("//*[@name='login_password']")).sendKeys(CORRECT_PASSWORD);
        driver.findElement(By.xpath("//*[text()=\"Войти\"]")).click();

        String actual = driver.findElement(By.xpath("//*[text()='Выход']")).getText();
        String expected = "Выход";
        Thread.sleep(5000);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void Test2() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[text()='Вход']")).click();
        driver.findElement(By.xpath("//*[@id=\"login_name\"]")).sendKeys(INCORRECT_LOGIN);
        driver.findElement(By.xpath("//*[@name='login_password']")).sendKeys(INCORRECT_PASSWORD);
        driver.findElement(By.xpath("//*[text()=\"Войти\"]")).click();

        String actual = driver.findElement(By.xpath("//*[text()='Ошибка авторизации']")).getText();
        String expected = "Ошибка авторизации";
        Thread.sleep(5000);
        Assertions.assertEquals(expected, actual);

    }
}
