package eu.senla;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CheckoutPage {
    SelenideElement firstName = $(By.id("first-name"));
    SelenideElement lastName = $(By.id("last-name"));
    SelenideElement zipCode = $(By.id("postal-code"));
    SelenideElement continueButton = $(By.id("continue"));

    public void addInformation(){
        firstName.sendKeys("Ivan");
        lastName.sendKeys("Ivanov");
        zipCode.sendKeys("12345");
    }
    public void continueOrder(){
        continueButton.click();
    }


}
