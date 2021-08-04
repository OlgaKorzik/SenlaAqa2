package eu.senla;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddOrderTest extends BaseClass{
    private LoginPage loginPage = new LoginPage();
    private InventoryPage inventoryPage = new InventoryPage();
    private CartPage cartPage = new CartPage();
    private CheckoutPage checkoutPage = new CheckoutPage();
    private CheckoutPageFinish checkoutPageFinish = new CheckoutPageFinish();

@BeforeEach
    public void login(){
    loginPage.login();
}
@Test
@DisplayName("Check to adding of new order")
    public void addNewOrder(){
       inventoryPage.addGoodsToCart(5);
       inventoryPage.transitionToCart();
       cartPage.checkoutButton.click();
       checkoutPage.addInformation();
       checkoutPage.continueOrder();
       checkoutPageFinish.finishOrder();
       String element = checkoutPageFinish.finishWord.getText();
       assertEquals("THANK YOU FOR YOUR ORDER",element, "Order don't add");

}
}
