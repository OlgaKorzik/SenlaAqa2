package eu.senla;

import eu.senla.utils.IConstant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest extends BaseClass{
    private PageMetods pageMetods =new PageMetods();

    @Test
public void loginTest(){
            pageMetods.login();
            String urlPage = url();
            assertEquals(IConstant.URLPAGE,urlPage,"User doesn't logged out");
    }
}
