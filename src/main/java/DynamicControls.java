import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.not;

public class DynamicControls implements PageObject {
    private WebDriver driver;
    private final By CHECK_BOX = By.id("checkbox");

    @FindBy(css = "#checkbox-example > button")
    WebElement REMOVE_BUTTON;
    //название норм пиши, например successDeleteCheckboxMessage место IT_IS_GONE
    private final By IT_IS_GONE = By.id("message");
    private final By INPUT_FIELD = By.cssSelector("#input-example > input[type=text]");
    private final By ENABLE_DISABLE_BUTTON = By.cssSelector("#input-example>button");
    //тоже, названия переменных должны быть понятными
    private final By GET_MESSAGE = By.cssSelector("#input-example>#message");


    public DynamicControls(WebDriver driver) {
        this.driver = driver;
        //эта строка для pageFactory, прочитай про паттерн
        //        @FindBy(css = "#checkbox-example > button")
        //        WebElement REMOVE_BUTTON;
        // в аннотации указываешь локатор для вэбэлемента и далее можешь вызывать его, как в методе clickOnRemoveOrAddButton()
        // В метод передается драйвер и класс с вэбэлементами внутри.
        // Плюс этого подхода в том, что выглядит все красивше и понятнее и самое главное
        // Поиск элемента на странице начинается только тогда, когда ты к нему обращаешься.
        PageFactory.initElements(driver, this);
    }

    //непонятное название метода. isCheckboxPresent
    public boolean isCheckBox() {
        int size = driver.findElements(CHECK_BOX).size();
        return size > 0;
    }

    //какой мы текст тут получаем? Название метода не понятное)
    public String getText() {
        WebElement element = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(IT_IS_GONE)));
        //можно сразу в return передавать return element.getText();
        String text = element.getText();
        return text;
    }

    public void clickOnRemoveOrAddButton() {
        REMOVE_BUTTON.click();
    }

    //для клика кнопки можешь сразу использовать ожидания в методе клика, как в примере
    //нажали на кнопку и ждем наступления события

//    public DynamicControls clickToRemoveOrAddCheckboxButton() {
//        if(isCheckboxPresent()) {
//            removeOrAddCheckboxButton.click();
//            new WebDriverWait(driver, 10)
//                    .until(ExpectedConditions.stalenessOf(driver.findElement(checkBox)));
//        } else {
//            removeOrAddCheckboxButton.click();
//            new WebDriverWait(driver, 10)
//                    .until(ExpectedConditions.presenceOfElementLocated(checkBox));
//        }
//        return this;
//    }
//
//    public boolean isCheckboxPresent() {
//        return driver.findElements(checkBox).size() > 0;
//    }
//
//    public DynamicControls clickEnableOrDisableTextFieldButton() {
//        if(textField.isEnabled()) {
//            enableOrDisableButton.click();
//            new WebDriverWait(driver, 10)
//                    .until(not(ExpectedConditions.elementToBeClickable(textField)));
//        } else {
//            enableOrDisableButton.click();
//            new WebDriverWait(driver, 10)
//                    .until(ExpectedConditions.elementToBeClickable(textField));
//        }
//        return this;
//    }

    public String getTextEnableOrDisable() {
        WebElement element = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(GET_MESSAGE)));
        String text = element.getText();
        return text;
    }

    public boolean addTextOnField() {
        //название переменной не нормальное
//        boolean isFieldEnabled;
        boolean b;
        // для проверки актиности поля есть метод isEnabled()
        // ты можешь увидеть на странице этого сайта в дереве этого элемента стоит параметр disabled
        // когда поле активное, то он исчезает
        // <input type="text" style="width: 30%;" disabled>
        if (getTextEnableOrDisable().equals("It's enabled!")) {
            b = true;

            driver.findElement(INPUT_FIELD).sendKeys("123");

        } else {
            b = false;
        }
        return b;
    }

    public void clickOnEnableOrDisableButton() {
        driver.findElement(ENABLE_DISABLE_BUTTON).click();
    }

    //опять название метода, локаторы тоже переобзови. Тут ты указываешь неявное ожидание, конфигурируя вебдрайвер
    //неявные ожидания конфигурятся в самом начале, перед запуском теста, после создания объекта драйвера
    // для единичных случаев используй явные ожидания, которые описал в примерах методов выше
    public boolean presentElementOnWeb() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        int size = driver.findElements(GET_MESSAGE).size();
        return size > 0;
    }
}
