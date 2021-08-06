package eu.senla;

import static com.codeborne.selenide.Condition.exist;
public class PageMetods {
    private LoginPage loginPage = new LoginPage();
    private InventoryPage inventoryPage = new InventoryPage();
    private CartPage cartPage = new CartPage();
    private CheckoutPage checkoutPage = new CheckoutPage();
    private CheckoutPageFinish checkoutPageFinish = new CheckoutPageFinish();

    public void addOrder(){
        inventoryPage.addGoodsToCart(5);
        inventoryPage.transitionToCart();
        cartPage.checkoutButton.click();
        checkoutPage.addInformation();
        checkoutPage.continueOrder();
        checkoutPageFinish.finishOrder();
    }
    public String getTextForFinishPage(){
        String element = checkoutPageFinish.finishWord.getText();
        return element;
    }
    public void login(){
        loginPage.loginOpenPage();
        loginPage.login();
    }
    public void logoutPage(){
        loginPage.logout();
    }
    public void loginPageAnaAddGaoods(){
        loginPage.login();
        inventoryPage.addGoodsToCart(5);
        inventoryPage.transitionToCart();
    }
    public void transitionForCheckoutPage(){
        cartPage.checkoutButton.click();
        checkoutPage.addInformation();
        checkoutPage.continueOrder();
    }
    public void cancelOrder(){
        transitionForCheckoutPage();
        checkoutPageFinish.cancel();
    }
    public void deleteOrderForCart(){
        cartPage.removeGoods();
        cartPage.goods.shouldNot(exist);
    }
    public Double sumGoodsOrder(){
        Double sum = checkoutPageFinish.sumOrder();
        return sum;
    }
    public Double sumGoodsOrderForPage(){
        Double sumOfPage = checkoutPageFinish.doubleNamber(checkoutPageFinish.sum);
        return sumOfPage;
    }
}
