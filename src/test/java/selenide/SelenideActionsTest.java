package selenide;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class SelenideActionsTest extends ForTestBeforeAll {

    private static String baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";


    //не работает
    @Test
    void dragAndDropActions() {
        open(baseUrl);
        SelenideElement a = $("column-a");
        SelenideElement b = $("#column-b");
        actions().clickAndHold(a).moveToElement(b).release().build().perform();
        //проверка что элементы аоменялись местами
        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
    }

    //работает
    @Test
    void dragAndDropActionSelenide() {
        open(baseUrl);
        //перемещение прямоугольника из колонки А в колонку B
        $("#column-a").dragAndDrop(to($("#column-b")));
        //проверка что элементы поменялись
        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
    }
}
