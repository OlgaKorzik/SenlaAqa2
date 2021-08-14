package eu.senla;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static eu.senla.utils.Evidence.*;

public class CheckoutPage {
    SelenideElement firstName = $(By.id("first-name"));
    SelenideElement lastName = $(By.id("last-name"));
    SelenideElement zipCode = $(By.id("postal-code"));
    SelenideElement continueButton = $(By.id("continue"));

    @Step("Adding information to a form")
    public void addInformation(){
        firstName.sendKeys(FIRSTNAME);
        lastName.sendKeys(LASTNAME);
        zipCode.sendKeys(ZIPCODE);
    }
    @Step("Click on the continue button")
    public void continueOrder(){
        continueButton.click();
    }


}
