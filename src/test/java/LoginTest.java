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

    @Test
    //    Название теста должно отражать суть проверки, например
    //    successfulLoginWithCorrectCredentials()
    public void successfulLoginWithCorrectCredentials() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(CORRECT_LOGIN);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(CORRECT_PASSWORD);
        driver.findElement(By.xpath("//button/i[@class='fa fa-2x fa-sign-in']")).click(); //Локатор, тут было бы достаточно просто By.tagName("button") или
        // с использованием css By.cssSelector("button.radius"), xpath By.xpath("//button[@class='radius']"). Если есть кнопка (тег button) то и нажимай на нее
        String actual = driver.findElement(By.className("subheader")).getText(); //тут ты ищешь по xpath, хотя, по факту поиск идёт любого элемента с
        // классом subheader. Почему тогда не искать по By.className
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        Thread.sleep(5000); // эта команда тут скорее нужна для того, чтобы визуально самому наблюдать за результатом, на тест она никак не влияет,
        //только затягивает общее время выполнения.
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void Test2() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); //неявные ожидания обычно конфигурируются перед запуском тестов, в твоем случае
        //в FixedData. Для единичных случаев используют явные ожидания.
        //https://comaqa.gitbook.io/selenium-webdriver-lectures/selenium-webdriver.-vvedenie/ozhidaniya

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(INCORRECT_LOGIN); //Если у элемента присутствует уникальный id, то поиск осуществлять по нему
        //у строки Username уникальный id='username'
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(CORRECT_PASSWORD); // тут также поиск по id
        driver.findElement(By.xpath("//button/i[@class='fa fa-2x fa-sign-in']")).click();

        String actual = driver.findElement(By.id("flash")).getText(); //тут ты ищешь элемент по тексту
        //и потом проверяешь, есть ли в этом элементе текст. Если элемент найден, то да, текст в нем этот есть. Проверка бессмысленная

        String expected = "Your username is invalid!\n"
                + "×";
        Thread.sleep(5000);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void Test3() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(userNameField).sendKeys(CORRECT_LOGIN); //если элементы дублируются, то их нужно выносить наверх в переменные и
        // затем переиспользовать, пример By userNameField = By.id("username");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(INCORRECT_PASSWORD);
        driver.findElement(By.xpath("//button/i[@class='fa fa-2x fa-sign-in']")).click();

        String actual = driver.findElement(By.xpath("//*[contains (text(),'Your password is invalid!')]")).getText();
        String expected = "Your password is invalid!\n" + "×";
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

        String expected = "Your username is invalid!\n"
                + "×";
        Thread.sleep(5000);
        Assertions.assertEquals(expected, actual);
    }
}
