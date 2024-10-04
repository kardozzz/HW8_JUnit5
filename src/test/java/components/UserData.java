package components;

public class UserData {
    private String username;
    private String password;

    // Конструктор
    public UserData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Геттер для логина
    public String getUsername() {
        return username;
    }

    // Геттер для пароля
    public String getPassword() {
        return password;
    }
}
