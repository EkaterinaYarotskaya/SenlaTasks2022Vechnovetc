import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DynamicContentPage implements PageObject {

    private WebDriver driver;

    public DynamicContentPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "p a")
    WebElement click_here;

    //этот метод дубликат safeDateAfterContentChanges. Так если они выполняют одинаковую функцию, то дубликат не нужен
    //один удалиv, другой обзовём типо saveContentData (удалил и обозвал)
    public List<String> saveContentData() {
        //ели каждый раз нам нужен чистый список при вызове метода, то лучше список создавать в самом методе.
        //иначе при повторном вызове метода мы будем использоавть список с данными, полученными при первом вызове.
        List<String> listOfContent;

        listOfContent = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(By.cssSelector("#content>.row"));

        elementList.forEach(a -> {
            listOfContent.add(a.findElement(By.tagName("img")).getAttribute("src"));
            listOfContent.add(a.findElement(By.cssSelector("#content>.row >.large-10")).getText());//кривой локатор, посмотри в дебаге и в консоли, что тут ты получаешь ничего
        });

        for (WebElement obj : elementList) {
            String strLinkText = obj.getText();
            System.out.println(strLinkText);
        }
        return listOfContent;
    }

    public void clickOnClickHereLink() {

        click_here.click();
    }
}





