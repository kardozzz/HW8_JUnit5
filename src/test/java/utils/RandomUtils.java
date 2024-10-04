package utils;

import com.github.javafaker.Faker;

public class RandomUtils {
    private static final Faker faker = new Faker();

    public static String getRandomLogin() {
        return faker.options().option("standard_user", "locked_out_user", "problem_user",
                "performance_glitch_user", "error_user", "visual_user");
    }
    public static String getRandomFirstName(){
        return faker.name().firstName();
    }
    public static String getRandomLastName(){
        return faker.name().lastName();
    }
}
