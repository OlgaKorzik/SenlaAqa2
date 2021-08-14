package eu.senla;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.Selenide.*;


public class BaseClass {
@BeforeAll
    public void setUp(){
    Configuration.startMaximized = true;
//    LoginPage loginPage = new LoginPage();
//    loginPage.loginOpenPage();
}
@AfterAll
    public void tearDown(){
    closeWebDriver();
}
}
