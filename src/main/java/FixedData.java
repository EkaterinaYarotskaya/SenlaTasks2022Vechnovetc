import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FixedData {

    protected static WebDriver driver;



    @BeforeAll
    public static void beforeAllTests() {

        System.setProperty("webdriver.chrome.driver",
                "chromedriver_win32\\chromedriver.exe");
    }

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();

    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }
}
