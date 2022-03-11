import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

//public class DynamicContentPage implements PageObject {
//    protected String pageURL = "http://the-internet.herokuapp.com/dynamic_content?with_content=static";
//    protected WebDriver driver;
//    //это что за аппендикс. Это из паттерна PageFactory, это сейчас не работает и нафиг не нужно
////    @FindBy(className = "div.large-centered>div.row") - это не className, а css
//    private List<WebElement> listElement;
//
//    public DynamicContentPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//
//    public void checkThePageForDynamicContent() {
//        driver.get(pageURL);
//        List<String> listOfElementBeforeTheContentChanges = new ArrayList<>();
//        List<String> listOfElementAfterTheContentChanges = new ArrayList<>();
//
//        //и следовательно тут ты получала пустой список и работала с пустотой
//        //далее ты получала второй пустой список и работала с пустотой
//        //затем ты сравнивала два пустых списка и они были одинаковы
//        //проверки ничего не проверили, толку нету никакого)) Исправлять))
//
//        List<WebElement> elementList = driver.findElements(By.cssSelector("div.large-centered>div.row"));
//
//        elementList.forEach(a -> {
//            listOfElementBeforeTheContentChanges.add(a.findElement(By.tagName("img")).getAttribute("src"));
//
//            listOfElementBeforeTheContentChanges.add(a.findElement(By.className("large-2")).getText());//кривой локатор, посмотри в дебаге и в консоли, что тут ты получаешь ничего
//
//        });
//        //метод toString серым выделен, он тут лишний. При передаче объекта в метод, где требуется String, toString вызывается автоматически
//        System.out.println(listOfElementBeforeTheContentChanges.toString());
//
//        driver.findElement(By.cssSelector("#content > div > p:nth-child(3) > a")).click();
//        listElement.forEach(a -> {
//            listOfElementAfterTheContentChanges.add(a.findElement(By.tagName("img")).getAttribute("src"));
//            listOfElementAfterTheContentChanges.add(a.findElement(By.className("large-10")).getText());
//
//        });
//        System.out.println(listOfElementAfterTheContentChanges.toString());
//
//        Assertions.assertEquals(listOfElementBeforeTheContentChanges,
//                listOfElementAfterTheContentChanges);
//
//        System.out.println("Without dynamic content");
//    }
//
//}
