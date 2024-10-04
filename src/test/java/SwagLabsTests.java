import components.AutorizationPage;
import components.CheckoutYourInformationPage;
import components.UserData;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

public class SwagLabsTests extends TestBase {
    AutorizationPage autorizationPage = new AutorizationPage();
    CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage();
    UserData userData = autorizationPage.getUserData();

    String firstName = RandomUtils.getRandomFirstName();
    String lastName = RandomUtils.getRandomLastName();

    @Test
    void authorizationTests() {
        autorizationPage.pageOpen();
                        autorizationPage.removeBanner()
                        .setLogin(userData.getUsername())
                        .setPassword(userData.getPassword())
                        .useLoginButton();


    }
}
