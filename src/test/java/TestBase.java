import com.codeborne.selenide.Configuration;


import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforceAll() {

        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://www.saucedemo.com";
        Configuration.browser = "chrome";

    }
//    @AfterEach
//    void closeDriver() {
//        WebDriverRunner.closeWindow();
//    }

}
