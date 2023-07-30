package github;

import org.junit.jupiter.api.Test;
import selenide.ForTestBeforeAll;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SolutionsEnterpriseTest extends ForTestBeforeAll {

    @Test
    public void hover() {

        open("https://github.com");

        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        $(".border-bottom").$(byText("Enterprise")).click();
        $(".application-main").shouldHave(text("Build like the best"));
    }
}