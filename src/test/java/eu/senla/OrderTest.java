package eu.senla;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderTest extends BaseClass{
    private LoginPage loginPage = new LoginPage();
    private InventoryPage inventoryPage = new InventoryPage();
    private CartPage cartPage = new CartPage();
    private CheckoutPage checkoutPage = new CheckoutPage();
    private CheckoutPageFinish checkoutPageFinish = new CheckoutPageFinish();

    @BeforeEach
    public void loginAndAddGoods(){
        loginPage.login();
        inventoryPage.addGoodsToCart(5);
        inventoryPage.transitionToCart();
    }

    @Test
    @DisplayName("Check to canseling of order")
    public void cancelOrder(){
        cartPage.checkoutButton.click();
        checkoutPage.addInformation();
        checkoutPage.continueOrder();
        checkoutPageFinish.cancel();
        String urlPage = url();
        assertEquals(IConstant.URLPAGE,urlPage,"User doesn't logged out");
    }
    @Test
    @DisplayName("Check to delete of goods from cart")
    public void deleteGoods(){
    cartPage.removeGoods();
    cartPage.goods.shouldNot(exist);
    }

    @Test
    @DisplayName("Check to calculation of the amount in the order")
    public void sumOrder(){
        cartPage.checkoutButton.click();
        checkoutPage.addInformation();
        checkoutPage.continueOrder();
   Double sum = checkoutPageFinish.sumOrder();
    }


    @AfterEach
    public void logout(){
        loginPage.logout();
    }
}
