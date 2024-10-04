package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class AutorizationPage {
    final SelenideElement loginInput = $("input[data-test='username']"),
            passwordInput = $("input[data-test='password']"),
            loginButtonUse = $("input[data-test='login-button']"),

    loginCredentials = $("div.login_credentials"),
            passwordInfo = $("div.login_password");


    public AutorizationPage pageOpen() {
        open("/");
        return this;
    }


    public AutorizationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()"); // удаляет баннер
        executeJavaScript("$('footer').remove()"); // удаляет футер
        return this;
    }


    public AutorizationPage setLogin(String value) {
        loginInput.setValue(value);
        return this;
    }


    public AutorizationPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }


    public AutorizationPage useLoginButton() {
        loginButtonUse.click();
        return this;
    }


    public String getLoginFromPage() {
        String credentialsText = loginCredentials.getText();

        String[] lines = credentialsText.split("\n");
        // Пропускаем первую строку и берем первый логин
        if (lines.length > 1) {
            return lines[1].trim();
        }
        throw new RuntimeException("Не удалось найти логин на странице");
    }


    public String getPasswordFromPage() {
        String passwordText = passwordInfo.getText();
        String[] parts = passwordText.split("is:");
        if (parts.length > 1) {
            return parts[1].trim();
        }
        throw new RuntimeException("Не удалось найти пароль на странице");
    }


    public UserData getUserData() {
        String username = getLoginFromPage();
        String password = getPasswordFromPage();
        return new UserData(username, password);
    }
}
