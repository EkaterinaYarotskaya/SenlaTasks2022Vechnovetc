import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DynamicContentPage implements PageObject {

    protected WebDriver driver;
    protected List<String> listOfElementBeforeTheContentChanges = new ArrayList<>();
    protected List<String> listOfElementAfterTheContentChanges = new ArrayList<>();

    protected List<WebElement> elementList;


    public DynamicContentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ArrayList<String> safeDateBeforeContentChanges() {
        elementList = driver.findElements(By.cssSelector("#content>.row"));

        elementList.forEach(a -> {
            listOfElementBeforeTheContentChanges.add(a.findElement(By.tagName("img")).getAttribute("src"));

            listOfElementBeforeTheContentChanges.add(a.findElement(By.className("large-10")).getText());//кривой локатор, посмотри в дебаге и в консоли, что тут ты получаешь ничего
        });
        for (WebElement obj : elementList) {
            String strLinkText = obj.getText();
            System.out.println(strLinkText);
        }

        return (ArrayList<String>) listOfElementBeforeTheContentChanges;
    }

    public void click() {
        driver.findElement(By.cssSelector("#content > div > p:nth-child(3) > a")).click();
    }

    public ArrayList<String> safeDateAfterContentChanges() {
        elementList = driver.findElements(By.cssSelector("#content>.row"));
        elementList.forEach(a -> {
            listOfElementAfterTheContentChanges.add(a.findElement(By.tagName("img")).getAttribute("src"));
            listOfElementAfterTheContentChanges.add(a.findElement(By.className("large-10")).getText());

        });
        for (WebElement obj : elementList) {
            String strLinkText = obj.getText();
            System.out.println(strLinkText);

        }
        return (ArrayList<String>) listOfElementBeforeTheContentChanges;
    }

    public boolean isDynamicContentPresent() {
        boolean dynamicIsPresent = false;
        for (int i = 0; i < listOfElementBeforeTheContentChanges.size(); i++) {
            if (!listOfElementBeforeTheContentChanges.get(i).equals(listOfElementAfterTheContentChanges.get(i))) {
                dynamicIsPresent = true;
                break;
            }
        }
        return dynamicIsPresent;
    }
}





