package eu.senla;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CheckoutPageFinish {
  SelenideElement finishButton = $(By.id("finish"));
  SelenideElement sum = $("#checkout_summary_container > div > div.summary_info > div.summary_subtotal_label");
  ElementsCollection priceGoods = $$(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div/div/div/div/div"));
  SelenideElement finishWord = $("#checkout_complete_container > h2");
  SelenideElement cancel = $(By.id("cancel"));

public void finishOrder(){
    finishButton.click();
}
public void cancel(){
    cancel.click();
}

public String getElementDouble(SelenideElement selenideElement, int i){
    String str = selenideElement.getText().substring(i);
    return str;
}
    
public Double sumOrder(){
    Double sum = 0.0;
    for (int i=0; i<priceGoods.size(); i++){
        Double n= doubleNamber(priceGoods.get(i),1);
        sum+=n;
    }
    return sum;
}
public Double doubleNamber(SelenideElement selenideElement, int i){
    Double namber = Double.parseDouble(getElementDouble(selenideElement, i));
    return namber;
}
}
