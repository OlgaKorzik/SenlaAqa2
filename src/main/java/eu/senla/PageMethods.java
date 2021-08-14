package eu.senla;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static eu.senla.utils.IConstant.*;

public class PageMethods {
    private LoginPage loginPage = new LoginPage();
    private InventoryPage inventoryPage = new InventoryPage();
    private CartPage cartPage = new CartPage();
    private CheckoutPage checkoutPage = new CheckoutPage();
    private CheckoutPageFinish checkoutPageFinish = new CheckoutPageFinish();

    @Step("Add order")
    public void addOrder(){
        inventoryPage.addGoodsToCart(5);
        inventoryPage.transitionToCart();
        cartPage.checkoutButton.click();
        checkoutPage.addInformation();
        checkoutPage.continueOrder();
        checkoutPageFinish.finishOrder();
    }
    @Step("Get text from finish page")
    public String getTextForFinishPage(){
        return checkoutPageFinish.finishWord.getText();
    }
    @Step("Login from page")
    public void login(){
        loginPage.loginOpenPage();
        loginPage.login(USERNAME,PASSWORD);
    }
    public void logoutPage(){
        loginPage.logout();
    }

    @Step("Login from page and add goods")
    public void loginPageAndAddGoods(){
        login();
        inventoryPage.addGoodsToCart(5);
        inventoryPage.transitionToCart();
    }
    @Step("Transition for checkout page")
    public void transitionForCheckoutPage(){
        cartPage.checkoutButton.click();
        checkoutPage.addInformation();
        checkoutPage.continueOrder();
    }
    @Step("Cancel order")
    public void cancelOrder(){
        transitionForCheckoutPage();
        checkoutPageFinish.cancel();
    }
    @Step("Delete goods of cart")
    public void deleteOrderForCart(){
        cartPage.removeGoods();
        cartPage.goods.shouldNot(exist);
    }
    public Double sumGoodsOrder(){
        return checkoutPageFinish.sumOrder();
    }

    public Double sumGoodsOrderForPage(){
        return checkoutPageFinish.doubleNamber(checkoutPageFinish.sum);
    }
}
