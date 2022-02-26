import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DynamicContentPage implements PageObject {
    protected String pageURL = "http://the-internet.herokuapp.com/dynamic_content?with_content=static";
    protected WebDriver driver;
    @FindBy(className = "div.large-centered>div.row")
    private List<WebElement> listElement;

    public DynamicContentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkThePageForDynamicContent() {
        driver.get(pageURL);
        List<String> listOfElementBeforeTheContentChanges = new ArrayList<>();
        List<String> listOfElementAfterTheContentChanges = new ArrayList<>();

        listElement.forEach(a -> {
            listOfElementBeforeTheContentChanges.add(a.findElement(By.tagName("img")).getAttribute("src"));

            listOfElementBeforeTheContentChanges.add(a.findElement(By.className("large-2")).getText());

        });
        System.out.println(listOfElementBeforeTheContentChanges.toString());

        driver.findElement(By.cssSelector("#content > div > p:nth-child(3) > a")).click();
        listElement.forEach(a -> {
            listOfElementAfterTheContentChanges.add(a.findElement(By.tagName("img")).getAttribute("src"));
            listOfElementAfterTheContentChanges.add(a.findElement(By.className("large-10")).getText());

        });
        System.out.println(listOfElementAfterTheContentChanges.toString());

        Assertions.assertEquals(listOfElementBeforeTheContentChanges,
                listOfElementAfterTheContentChanges);

        System.out.println("Without dynamic content");
    }

}
