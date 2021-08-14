package eu.senla;

import io.qameta.allure.*;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static com.codeborne.selenide.WebDriverRunner.url;
import static eu.senla.utils.IConstant.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(Parameterized.class)
public class ParamsLoginTest extends BaseClass{
    private LoginPage loginPage = new LoginPage();

    @Feature("Login parameterized")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Login parameterized test")
    @DisplayName("Check to login on the page")
    @ParameterizedTest
    @ValueSource(strings = {"locked_out_user","problem_user", "performance_glitch_user" })
    public void loginTest(String login){
        loginPage.loginOpenPage();
        loginPage.login(login, PASSWORD);
        String urlPage = url();
        assertEquals(URLPAGE,urlPage,"User doesn't logged out");
    }

}
