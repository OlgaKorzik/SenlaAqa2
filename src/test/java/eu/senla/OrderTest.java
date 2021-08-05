package eu.senla;
import eu.senla.utils.IConstant;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderTest extends BaseClass{
    private PageMetods pageMetods =new PageMetods();

    @BeforeEach
    public void loginAndAddGoods(){
        pageMetods.loginPageAnaAddGaoods();
    }

    @Test
    @DisplayName("Check to canseling of order")
    public void cancelOrder(){
        pageMetods.cancelOrder();
        String urlPage = url();
        assertEquals(IConstant.URLPAGE,urlPage,"User doesn't logged out");
    }
    @Test
    @DisplayName("Check to delete of goods from cart")
    public void deleteGoods(){
    pageMetods.deleteOrderForCart();
    }

    @Test
    @DisplayName("Check to calculation of the amount in the order")
    public void sumOrder(){
        pageMetods.transitionForCheckoutPage();
        Double sum = pageMetods.sumGoodsOrder();
        Double sumOfPage = pageMetods.sumGoodsOrderForPage();
        assertEquals(sum ,sumOfPage,"Incorrect amount calculated");
    }


    @AfterEach
    public void logout(){
        pageMetods.logoutPage();
    }
}
