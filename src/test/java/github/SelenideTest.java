package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {
    @Test
    void shouldFindSoftAssertionPageOnSelenideWiki() {
        // открыть страницу selenide
        open("https://github.com/selenide/selenide");
        // перейти в раздел Wiki проекта
        $("[data-content=\"Wiki\"]").click();
        //раскрыть полный список страниц
        $(".js-wiki-more-pages-link").click();
        // убедиться, что в списке страниц (Pages) есть страница SoftAssertions
         $("#wiki-pages-box").$("ul")
                 .shouldHave(text("SoftAssertions")).shouldBe(visible);
         // можно сразу перейти на страницу SoftAssertion $(byText("SoftAssertions")).click();
         // и перенести часть поиска кода JUnit в текущий тест
         // но тогда непонятно, зачем требование проверить, что страница есть в списке.
         // ведь если её можно открыть, значит она есть. Поэтому разделила на два независимых теста
    }

    @Test
    void shouldFindJUnit5ExampleOnSoftAssertionPage() {
        // открыть страницу SoftAssertions
        open("https://github.com/selenide/selenide/wiki/SoftAssertions");
        //проверить что внутри есть пример кода для JUnit5
        $(".page").shouldHave(text("Using JUnit5 extend test class"))
                .shouldBe(visible);
    }
}
