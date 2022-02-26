
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicContentTest extends FixedData{

    @Test
    public void dynamicCheck(){

       DynamicContentPage dynamicContent= new DynamicContentPage(driver);
       dynamicContent.checkThePageForDynamicContent();
    }




}
