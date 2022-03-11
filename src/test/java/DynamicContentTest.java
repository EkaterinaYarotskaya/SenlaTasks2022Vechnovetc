
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicContentTest extends FixedData{

//    @Test
//    public void dynamicCheck(){
//
//       DynamicContentPage dynamicContent= new DynamicContentPage(driver);
//        System.out.println(dynamicContent);
//       //как описал ранее, метода с проверкой в пэйдже быть не должно
//        // Лучше всего будет прописать в пэйдже метод, который будет возвращать List<String>
//        //(как у тебя listOfElementBeforeTheContentChanges) и метод, котоырй будет кликать на кнопку
//        //и далее в тесте
//        // List<String> elementsTextBefore = dynamicContent.getContent();
//        // dynamicContent.clickOnButton;
//        // List<String> elementsTextAfter = dynamicContent.getContent();
//        // и потом сравнивать списки.
//        //         Assertions.assertEquals(listOfElementBeforeTheContentChanges,
//        //                listOfElementAfterTheContentChanges);
//        // упадёт, если коллекции разные. Тебе надо убедиться, что они разные и чтобы в таком случае тест не упал
//        // у тебя же сейчас, если ты посмотришь в дебаге, возвращается 2 пустых списка и сравнивается, значит чтото у тебя работает не так.
//       dynamicContent.checkThePageForDynamicContent();
//    }




}
