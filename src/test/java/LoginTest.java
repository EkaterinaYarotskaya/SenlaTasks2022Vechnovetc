import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginTest extends FixedData {
    String CORRECT_LOGIN = "tomsmith";
    String CORRECT_PASSWORD = "SuperSecretPassword!";
    String INCORRECT_LOGIN = "login1";
    String INCORRECT_PASSWORD = "password1";
    @Test
    public void Test1() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(CORRECT_LOGIN);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(CORRECT_PASSWORD);
        driver.findElement(By.xpath("//button/i[@class='fa fa-2x fa-sign-in']")).click();
        String actual = driver.findElement(By.xpath("//*[@class='subheader']")).getText();
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        Thread.sleep(5000);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void Test2() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(INCORRECT_LOGIN);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(CORRECT_PASSWORD);
        driver.findElement(By.xpath("//button/i[@class='fa fa-2x fa-sign-in']")).click();

        String actual = driver.findElement(By.xpath("//*[contains (text(),' Your username is invalid!')]")).getText();

        String expected ="Your username is invalid!\n"
                + "×";
        Thread.sleep(5000);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void Test3() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(CORRECT_LOGIN);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(INCORRECT_PASSWORD);
        driver.findElement(By.xpath("//button/i[@class='fa fa-2x fa-sign-in']")).click();

       String actual = driver.findElement(By.xpath("//*[contains (text(),'Your password is invalid!')]")).getText();
        String expected = "Your password is invalid!\n" +                "×";
        Thread.sleep(5000);
        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void Test4() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(INCORRECT_LOGIN);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(INCORRECT_PASSWORD);
        driver.findElement(By.xpath("//button/i[@class='fa fa-2x fa-sign-in']")).click();

        String actual = driver.findElement(By.xpath("//*[contains (text(),' Your username is invalid!')]")).getText();

        String expected ="Your username is invalid!\n"
                + "×";
        Thread.sleep(5000);
        Assertions.assertEquals(expected, actual);
    }
}
