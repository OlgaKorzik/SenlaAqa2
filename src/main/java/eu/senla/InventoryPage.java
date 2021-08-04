package eu.senla;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class InventoryPage {
    SelenideElement cartButton = $("#shopping_cart_container > a");
    ElementsCollection addToCartButton = $$(By.xpath("//button[text () = 'Add to cart']"));
    ElementsCollection removeButton = $$(By.xpath("//button[text () = 'Remove']"));

     public void addGoodsToCart (int g){
         if(addToCartButton.size()>g) {
             for (int i = 0; i < g; i++) {
                 addToCartButton.get(0).click();
             }
         } else {
             transitionToCart();
         }
     }
     public void transitionToCart(){
         cartButton.click();
     }
}
