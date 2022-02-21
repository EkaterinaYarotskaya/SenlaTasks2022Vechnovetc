import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

public class LoginTest extends FixedData {
    String CORRECT_LOGIN = "tomsmith";
    String CORRECT_PASSWORD = "SuperSecretPassword!";
    String INCORRECT_LOGIN = "login1";
    String INCORRECT_PASSWORD = "password1";
    By userNameField = By.id("username");
    By userPasswordField = By.id("password");

    @Test
    public void successfulLoginWithCorrectCredentials() {
        driver.findElement(userNameField).sendKeys(CORRECT_LOGIN);
        driver.findElement(userPasswordField).sendKeys(CORRECT_PASSWORD);
        driver.findElement(By.tagName("button")).click();
        String actual = driver.findElement(By.className("subheader")).getText();
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void unsuccessfulLoginWithIncorrectLoginAndCorrectPassword() {
        driver.findElement(userNameField).sendKeys(INCORRECT_LOGIN);
        driver.findElement(userPasswordField).sendKeys(CORRECT_PASSWORD);
        driver.findElement(By.tagName("button")).click();
        String actual = driver.findElement(By.id("flash")).getText();
        String expected = "Your username is invalid!\n" + "×";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void unsuccessfulLoginWithCorrectLoginAndIncorrectPassword() {
        driver.findElement(userNameField).sendKeys(CORRECT_LOGIN);
        driver.findElement(userPasswordField).sendKeys(INCORRECT_PASSWORD);
        driver.findElement(By.tagName("button")).click();
        String actual = driver.findElement(By.id("flash")).getText(); //тут ты ищешь по xpath, хотя, по факту поиск идёт любого элемента с
        String expected = "Your password is invalid!\n" + "×";
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void unsuccessfulLoginWithIncorrectLoginAndIncorrectPassword() {
        driver.findElement(userNameField).sendKeys(INCORRECT_LOGIN);
        driver.findElement(userPasswordField).sendKeys(INCORRECT_PASSWORD);
        driver.findElement(By.tagName("button")).click();
        String actual = driver.findElement(By.id("flash")).getText(); //тут ты ищешь по xpath, хотя, по факту поиск идёт любого элемента с
        String expected = "Your username is invalid!\n" + "×";
        Assertions.assertEquals(expected, actual);
    }
}
