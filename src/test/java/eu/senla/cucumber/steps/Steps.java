package eu.senla.cucumber.steps;
import eu.senla.CartPage;
import eu.senla.InventoryPage;
import eu.senla.LoginPage;
import eu.senla.utils.IConstant;
import io.cucumber.java.ru.*;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.*;

public class Steps {
    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    CartPage cartPage = new CartPage();

    @Допустим("^открыта страница \"([^\"]*)\"$")
    public void loginPage(String url){
    open(url);
    getWebDriver().manage().window().maximize();
    String urlPage = getWebDriver().getCurrentUrl();
    assertEquals(url,urlPage,"Url don't match");
    }
    @Допустим("^введены логин \"([^\"]*)\" и пароль \"([^\"]*)\"$")
    public void login(String st, String str){
        loginPage.loginInput.setValue(st);
        loginPage.passwordInput.setValue(str);
        loginPage.singInButton.click();
        String urlPage = url();
        assertEquals(IConstant.URLPAGE,urlPage,"User doesn't logged out");
    }
    @Допустим("^выбрано \"([^\"]*)\" первых товара$")
    public void addGoods(String str){
        int number = Integer.parseInt(str);
        inventoryPage.addGoodsToCart(number);
        int size = inventoryPage.removeButton.size();
        assertEquals(number,size,"Order don't add");
    }
    @Допустим("^нажата кнопка корзины$")
    public void clickButtonCart(){
        inventoryPage.cartButton.click();
    }
    @Тогда("^выполнено нажатие на ссылку товара \"([^\"]*)\"$")
    public void clickLinks(String str){
        $(By.xpath("//*[contains(text(), \"" + str + "\")]")).click();
    }
    @Тогда("^в корзине находятся \"([^\"]*)\" товара$")
    public void amountGoodsInCart(String str){
        int amountGoods = Integer.parseInt(str);
        int amountGoodsInCart = cartPage.removeButton.size();
        assertEquals(amountGoods,amountGoodsInCart,"Order don't add in cart");
    }
    @Тогда("^цена товара равна \"([^\"]*)\"$")
    public void getPriceGoods(String price){
        String priceGoods = $(By.className("inventory_details_price")).getText();
        assertTrue(price.contains(priceGoods), "price don't match");
    }

}
