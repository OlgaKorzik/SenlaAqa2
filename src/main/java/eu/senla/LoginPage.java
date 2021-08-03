package eu.senla;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class LoginPage {
    SelenideElement loginInput = $(By.id("user-name"));
    SelenideElement passwordInput = $("#password");
    SelenideElement singInButton = $(By.name("login-button"));

    void login() {
        open(IConstant.URL);
        loginInput.sendKeys(IConstant.USERNAME);
        passwordInput.sendKeys(IConstant.PASSWORD);
        singInButton.click();
    }

    void loginOpenPage(){
        open(IConstant.URL);
    }
}
