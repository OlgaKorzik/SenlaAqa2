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

public String getElementDouble(SelenideElement selenideElement){
    String [] str = selenideElement.getText().split("\\$");
    return str[1];
}
    
public Double sumOrder(){
    Double sum = priceGoods.stream().map(a->doubleNamber(a)).mapToDouble(i->i).sum();
    return sum;
}
public Double doubleNamber(SelenideElement selenideElement){
    Double namber = Double.parseDouble(getElementDouble(selenideElement));
    return namber;
}
}
