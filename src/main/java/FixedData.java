import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FixedData implements PageObject {

    protected WebDriver driver;
    protected static FileInputStream fis;
    protected static Properties property;

    @BeforeAll
    public static   void beforeAllTests() {
        System.setProperty("webdriver.chrome.driver",
                "chromedriver_win32\\chromedriver.exe");

        property = new Properties();
        try {
            fis = new FileInputStream("src/main/properties/config.properties");
            property.load(fis);

        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }
    @BeforeEach
    public  void beforeEachTests() {
    driver = new ChromeDriver();}

    @AfterEach
    public void afterEach() {
        driver.quit();
    }
}
