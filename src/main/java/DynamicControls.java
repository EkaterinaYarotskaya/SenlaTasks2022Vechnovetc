import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControls implements PageObject {
    protected WebDriver driver;
    private final By CHECK_BOX = By.id("checkbox");
    private final By REMOVE_BUTTON = By.cssSelector("#checkbox-example > button");
    private final By IT_IS_GONE = By.id("message");
    private final By INPUT_FIELD = By.cssSelector("#input-example > input[type=text]");
    private final By ENABLE_DISABLE_BUTTON = By.cssSelector("#input-example>button");
    private final By GET_MESSAGE = By.cssSelector("#input-example>#message");


    public DynamicControls(WebDriver driver) {
        this.driver = driver;

    }

    public boolean isCheckBox() {
        int size = driver.findElements(CHECK_BOX).size();
        return size > 0;
    }

    public String getText() {
        WebElement element = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(IT_IS_GONE)));
        String text = element.getText();
        return text;
    }
    public void clickOnRemoveOrAddButton() {

        driver.findElement(REMOVE_BUTTON).click();
    }

    public String getTextEnableOrDisable() {
        WebElement element = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(GET_MESSAGE)));
        String text = element.getText();
        return text;
    }
    public boolean addTextOnField() {
        boolean b;
        if (getTextEnableOrDisable().equals("It's enabled!")) {
            b = true;

            driver.findElement(INPUT_FIELD).sendKeys("123");

        } else {
            b = false;
        }
        return b;
    }
    public void clickOnEnableOrDisable() {
        driver.findElement(ENABLE_DISABLE_BUTTON).click();
    }
    public boolean presentElementOnWeb() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        int size = driver.findElements(GET_MESSAGE).size();
        return size > 0;
    }
}
