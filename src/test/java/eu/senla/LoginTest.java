package eu.senla;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest extends BaseClass{
private LoginPage loginPage = new LoginPage();

    @Test
public void loginTest(){
            loginPage.loginOpenPage();
            loginPage.login();
            String urlPage = url();
            assertEquals(IConstant.URLPAGE,urlPage,"User doesn't logged out");
    }
}
