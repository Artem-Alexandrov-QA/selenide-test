package tests.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SoftAssertionsTest {
    String example = "public class Tests {\n" +
            "  @Test\n" +
            "  public void test() {\n" +
            "    $(\"#first\").should(visible).click();\n" +
            "    $(\"#second\").should(visible).click();\n" +
            "  }\n" +
            "}";

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void softAssertionsTest() {

        open("https://github.com/");
        $("[placeholder='Search GitHub']").setValue("Selenide").pressEnter();
        $$(".repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $$(".markdown-body ul").first().$(byText("Soft assertions")).click();
        $(".markdown-body>:nth-child(9)").shouldBe(text(example));

//        open("https://github.com/");
//        $("[placeholder='Search GitHub']").setValue("Selenide").pressEnter();
//        $$(".repo-list li").first().$("a").click();
//        $("#wiki-tab").click();
//        $$(".markdown-body ul").first().$(byText("Soft assertions")).click();
//        $("#wiki-body>div>h4").shouldBe(text("3. Using JUnit5 extend test class:"));
//        --- второй тест, не понял
//        что хотели именно в дз, или сам код проверить что он есть, или что есть текст с примером для junit
//        сделал два варианта, сам склоняюсь к первому


    }
}
