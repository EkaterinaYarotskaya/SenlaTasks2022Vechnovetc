import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class FixedData {
   private    String pageURL = "https://kinogoo.by/#";
   WebDriver driver;
    @BeforeAll
    public   void beforeAllTests() {
        System.setProperty("webdriver.chrome.driver",
                "E:\\myProject\\chromedriver_win32\\chromedriver.exe");         }
    @BeforeEach
    public   void beforeEach() {
        driver=new ChromeDriver();
        driver.get(pageURL);    }
    @AfterEach
    public   void afterEach() {
        driver.quit();
    }
}
