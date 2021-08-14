package eu.senla;

import io.qameta.allure.*;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static eu.senla.utils.IConstant.URLPAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest extends BaseClass{
    private PageMethods pageMethods =new PageMethods();

    @Feature("Login")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Login test")
    @DisplayName("Check to login on the page")
    @Test
public void loginTest(){
            pageMethods.login();
            String urlPage = url();
            assertEquals(URLPAGE,urlPage,"User doesn't logged out");
    }
}
