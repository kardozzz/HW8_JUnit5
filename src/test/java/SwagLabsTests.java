import components.AutorizationPage;
import components.CheckoutYourInformationPage;
import components.UserData;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import utils.RandomUtils;

import java.util.List;
import java.util.stream.Stream;

public class SwagLabsTests extends TestBase {
    AutorizationPage autorizationPage = new AutorizationPage();
    CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage();
    UserData userData = new UserData("", "");

    @DisplayName("Удачная авторизация")
    @Tag("Smoke")
    @Test
    @Disabled
    void authorizationAllRowTests() {
        autorizationPage.pageOpen()
                .setLogin(autorizationPage.getLoginFromPage())
                .setPassword(autorizationPage.getPasswordFromPage())
                .useLoginButton();
    }

    @DisplayName("Проверка обязательности поля - password")
    @Tag("Negative")
    @Test
    @Disabled
    void authorizationFailedPasswordTests() {
        autorizationPage.pageOpen()
                .setLogin(autorizationPage.getLoginFromPage())
                .useLoginButton()
                .checkErrorFromPassword();
    }

    @DisplayName("Проверка обязательности поля - username")
    @Tag("Negative")
    @Test
    @Disabled
    void authorizationFailedUserNameTests() {
        autorizationPage.pageOpen()
                .setPassword(autorizationPage.getPasswordFromPage())
                .useLoginButton()
                .checkErrorFromUsername();
    }

    @Tag("Smoke!")
    @CsvFileSource(resources = "/test_data/authorizationParamAllRow.csv")
    @ParameterizedTest(name = "Удачная авторизация под пользователем {0} c паролем {1}.")
    void authorizationParamAllRowTests(String loginName, String userPassword) {
        autorizationPage.pageOpen()
                .setLogin(loginName)
                .setPassword(userPassword)
                .useLoginButton()
                .checkCompleteAuthorizations();
    }

    @Tag("Smoke!")
    @ValueSource(strings = {
            "standard_user"})
    @ParameterizedTest(name = "Удачная авторизация под пользователем {0} c паролем {1}.")
    void authorizationOtherParamAllRowTests(String loginName) {
        autorizationPage.pageOpen()
                .setLogin(loginName)
                .setPassword(autorizationPage.getPasswordFromPage())
                .useLoginButton()
                .checkCompleteAuthorizations();
    }
        static Stream<Arguments> authorizationMetHodParamAllRowTests() {
            return Stream.of(
                    Arguments.of("standard_user","secret_sauce"));
        }


    @MethodSource("authorizationMetHodParamAllRowTests")
    @ParameterizedTest
    void authorizationMetHodParamAllRowTests(String username, String password) {
        autorizationPage.pageOpen()
                .setLogin(username)
                .setPassword(password)
                .useLoginButton()
                .checkCompleteAuthorizations();
    }


    @Tag("Smoke")
    @Disabled
    @CsvFileSource(resources = "/test_data/authorizationParamAllRow.csv")
    @ParameterizedTest(name = "Удачная авторизация под пользователем {0} без пароля.")
    void authorizationFailedParamAllRowTests(String loginName) {
        autorizationPage.pageOpen()
                .setLogin(loginName)
                .useLoginButton();
    }

    @DisplayName("Проверка обязательности поля - password")
    @Tag("Negative")
    @Test
    @Disabled
    void authorizationParamFailedPasswordTests() {
        autorizationPage.pageOpen()
                .setLogin(autorizationPage.getLoginFromPage())
                .useLoginButton()
                .checkErrorFromPassword();
    }

    @DisplayName("Проверка обязательности поля - username")
    @Tag("Negative")
    @Test
    @Disabled
    void authorizationParamFailedUserNameTests() {
        autorizationPage.pageOpen()
                .setPassword(autorizationPage.getPasswordFromPage())
                .useLoginButton()
                .checkErrorFromUsername();
    }
}
