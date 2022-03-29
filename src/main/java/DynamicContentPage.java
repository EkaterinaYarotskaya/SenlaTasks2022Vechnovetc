import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DynamicContentPage implements PageObject {

    private WebDriver driver;
    private List<String> listOfContent;

    public DynamicContentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //это не нужно, это для пэйджфактори.
    }

    //этот метод дубликат safeDateAfterContentChanges. Так если они выполняют одинаковую функцию, то дубликат не нужен
    //один удалиv, другой обзовём типо saveContentData (удалил и обозвал)
    public List<String> saveContentData() {
        //ели каждый раз нам нужен чистый список при вызове метода, то лучше список создавать в самом методе.
        //иначе при повторном вызове метода мы будем использоавть список с данными, полученными при первом вызове.
        DynamicContentPage contentPage = new DynamicContentPage(driver);
        contentPage.saveContentData();
        contentPage.saveContentData();
        listOfContent = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(By.cssSelector("#content>.row"));

        elementList.forEach(a -> {
            listOfContent.add(a.findElement(By.tagName("img")).getAttribute("src"));
            listOfContent.add(a.findElement(By.className("large-10")).getText());//кривой локатор, посмотри в дебаге и в консоли, что тут ты получаешь ничего
        });
        //циклом можно пройтись как в 30 строке
        //
//        elementList.forEach(element -> System.out.println(element.getText()));
        for (WebElement obj : elementList) {
            String strLinkText = obj.getText();
            System.out.println(strLinkText);
        }
        //исправил, в 25й строке возвращаемый параметр был Arraylist. Нужно указывать интерфейс для юольшей гибкости программы
        //теперь можем возвращать и LikedList и ArrayList и нет необходимости приведения типов, как ты писала в скобках
        // return (ArrayList<String) listOfElementBeforeTheContentChanges;
        return listOfContent;
    }

    //что за метод? непонятное название. Должно быть понятно на что кликать типо clickOnClickHereLink
    public void click() {
        //длинный селектор, так короче By.cssSelector("p a"))
        driver.findElement(By.cssSelector("#content > div > p:nth-child(3) > a")).click();
    }

    //Так не очень. Ты в тесте должна получить некоторые данные и выполнить их сравнение
    //можно сделать вспомогательный класс и закинуть туда твой метод сравнения списков, но лучше выполнить как я уже поправил в тесте
//    public boolean isDynamicContentPresent() {
//        boolean dynamicIsPresent = false;
//        for (int i = 0; i < listOfContent.size(); i++) {
//            if (!listOfContent.get(i).equals(listOfElementAfterTheContentChanges.get(i))) {
//                dynamicIsPresent = true;
//                break;
//            }
//        }
//        return dynamicIsPresent;
//    }
}





