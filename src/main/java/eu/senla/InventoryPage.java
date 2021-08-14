package eu.senla;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class InventoryPage {
    public SelenideElement cartButton = $("#shopping_cart_container > a");
    public ElementsCollection addToCartButton = $$(By.xpath("//button[text () = 'Add to cart']"));
    public ElementsCollection removeButton = $$(By.xpath("//button[text () = 'Remove']"));

    @Step("Add goods to cart")
     public void addGoodsToCart (int amount){
         if(addToCartButton.size()>amount) {
             for (int i = 0; i < amount; i++) {
                 addToCartButton.get(0).click();
             }
         } else {
             transitionToCart();
         }
     }
     @Step("Click on the cart button")
     public void transitionToCart(){
         cartButton.click();
     }
}
