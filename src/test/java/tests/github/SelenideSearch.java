package tests.github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSearch {
    @BeforeAll
    static void beforeAll (){
        Configuration.startMaximized = true;
    }

    @Test
    void shouldFindSelenideRepositoryPage() {

        open("https://github.com/");
        $("[placeholder='Search GitHub']").setValue("Selenide").pressEnter();
        $$(".repo-list li").first().$("a").click();
        $(".mr-2.flex-self-stretch").should(text("selenide"));
        sleep(5000);
    }
}
