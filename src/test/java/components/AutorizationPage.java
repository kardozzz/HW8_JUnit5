package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AutorizationPage {
    final SelenideElement loginInput = $("input[data-test='username']"),
            passwordInput = $("input[data-test='password']"),
            loginButtonUse = $("input[data-test='login-button']"),
    // Элементы, содержащие информацию о логинах и пароле
    loginCredentials = $("div.login_credentials"),
            passwordInfo = $("div.login_password");

    // Открыть страницу авторизации
    public AutorizationPage pageOpen() {
        open("/");
        return this;
    }

    // Удалить баннер и футер
    public AutorizationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()"); // удаляет баннер
        executeJavaScript("$('footer').remove()"); // удаляет футер
        return this;
    }

    // Установить логин
    public AutorizationPage setLogin(String value){
        loginInput.setValue(value);
        return this;
    }

    // Установить пароль
    public AutorizationPage setPassword(String password){
        passwordInput.setValue(password);
        return this;
    }

    // Нажать кнопку логина
    public AutorizationPage useLoginButton(){
        loginButtonUse.click();
        return this;
    }

    // Извлечь логин (например, первый из списка)
    public String getLoginFromPage() {
        String credentialsText = loginCredentials.getText();
        // Предполагается, что логины перечислены построчно после заголовка
        // Например:
        // Accepted usernames are:
        // standard_user
        // locked_out_user
        // problem_user
        // performance_glitch_user
        String[] lines = credentialsText.split("\n");
        // Пропускаем первую строку и берем первый логин
        if (lines.length > 1) {
            return lines[1].trim();
        }
        throw new RuntimeException("Не удалось найти логин на странице");
    }

    // Извлечь пароль
    public String getPasswordFromPage() {
        String passwordText = passwordInfo.getText();
        // Предполагается, что пароль указан после двоеточия
        // Например: Password for all users is: secret_sauce
        String[] parts = passwordText.split("is:");
        if (parts.length > 1) {
            return parts[1].trim();
        }
        throw new RuntimeException("Не удалось найти пароль на странице");
    }

    // Метод для получения данных пользователя
    public UserData getUserData() {
        String username = getLoginFromPage();
        String password = getPasswordFromPage();
        return new UserData(username, password);
    }
}
