package eu.senla;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class CartPage {
    SelenideElement checkoutButton = $(By.id("checkout"));
    ElementsCollection removeButton = $$(By.xpath("//button[text () = 'Remove']"));
    ElementsCollection priceGoods = $$("#inventory_item_price");
    SelenideElement cartContainer = $("#shopping_cart_container > a > span");
    SelenideElement goods = $("#cart_item");

    public void removeGoods (){
        for(SelenideElement remove : removeButton){
            removeButton.get(0).click();
        }
    }


}
