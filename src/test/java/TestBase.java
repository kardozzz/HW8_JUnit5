import com.codeborne.selenide.Configuration;


import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void setup() {

        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://www.saucedemo.com";
        Configuration.browser = "chrome";

    }
    @AfterEach
    void teardown() {
        WebDriverRunner.closeWindow();
    }

}
