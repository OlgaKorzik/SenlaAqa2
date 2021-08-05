package eu.senla;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class CartPage {
    SelenideElement checkoutButton = $(By.id("checkout"));
    ElementsCollection removeButton = $$(By.xpath("//button[text () = 'Remove']"));
    SelenideElement goods = $("#cart_item");

    public void removeGoods (){
        for(SelenideElement remove : removeButton){
            removeButton.get(0).click();
        }
    }


}
