package eu.senla;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.WebDriverRunner.url;
import static eu.senla.utils.IConstant.URLPAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderTest extends BaseClass{
    private PageMethods pageMethods =new PageMethods();

    @BeforeEach
    public void loginAndAddGoods(){
        pageMethods.loginPageAndAddGoods();
    }

    @Feature( "Order")
    @Story("Cancel order")
    @Severity(SeverityLevel.MINOR)
    @Description("Cancel order test")
    @Test
    @DisplayName("Check to canseling of order")
    public void cancelOrderTest(){
        pageMethods.cancelOrder();
        String urlPage = url();
        assertEquals(URLPAGE,urlPage,"User doesn't logged out");
    }

    @Feature( "Order")
    @Story("Delete order")
    @Severity(SeverityLevel.MINOR)
    @Description("Delete goods test")
    @Test
    @DisplayName("Check to delete of goods from cart")
    public void deleteGoodsTest(){
    pageMethods.deleteOrderForCart();
    }

    @Feature( "Order")
    @Story("Sum order")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Sum order test")
    @Test
    @DisplayName("Check to calculation of the amount in the order")
    public void sumOrderTest(){
        pageMethods.transitionForCheckoutPage();
        Double sum = pageMethods.sumGoodsOrder();
        Double sumOfPage = pageMethods.sumGoodsOrderForPage();
        assertEquals(sum ,sumOfPage,"Incorrect amount calculated");
    }


    @AfterEach
    public void logout(){
        pageMethods.logoutPage();
    }
}
