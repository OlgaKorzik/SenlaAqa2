package eu.senla;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.WebDriverRunner.url;
import static eu.senla.utils.IConstant.URLPAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderTest extends BaseClass{
    private PageMetods pageMetods =new PageMetods();

    @BeforeEach
    public void loginAndAddGoods(){
        pageMetods.loginPageAndAddGoods();
    }


    @Test
    @DisplayName("Check to canseling of order")
    public void cancelOrderTest(){
        pageMetods.cancelOrder();
        String urlPage = url();
        assertEquals(URLPAGE,urlPage,"User doesn't logged out");
    }

    @Test
    @DisplayName("Check to delete of goods from cart")
    public void deleteGoodsTest(){
    pageMetods.deleteOrderForCart();
    }

    @Test
    @DisplayName("Check to calculation of the amount in the order")
    public void sumOrderTest(){
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
