package eu.senla;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CheckoutPageFinish {
  SelenideElement finishButton = $(By.id("finish"));
  SelenideElement sum = $("#summary_subtotal_label");
  ElementsCollection priceGoods = $$("#inventory_item_price");
  SelenideElement finishWord = $("#checkout_complete_container > h2");
  SelenideElement cancel = $(By.id("cancel"));

public void finishOrder(){
    finishButton.click();
}
public void cancel(){
    cancel.click();
}
public Double sumOrder(){
    List<Double> sumList = (List<Double>) priceGoods.stream().map(i -> i.getText())
            .mapToDouble(j->Double.parseDouble(j));
    Double sum = sumList.stream().mapToDouble(a -> a).sum();
    return sum;
}
}
