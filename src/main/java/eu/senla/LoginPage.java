package eu.senla;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static eu.senla.utils.IConstant.*;


public class LoginPage {
    public SelenideElement loginInput = $(By.id("user-name"));
    public SelenideElement passwordInput = $("#password");
    public SelenideElement singInButton = $(By.name("login-button"));
    SelenideElement menuButton = $(By.id("react-burger-menu-btn"));
    SelenideElement logout = $(By.id("logout_sidebar_link"));

    @Step("Set login and password")
    public void login() {
        loginInput.sendKeys(USERNAME);
        passwordInput.sendKeys(PASSWORD);
        singInButton.click();
    }
    @Step("Open login page")
    public void loginOpenPage(){
        open(URL);
    }
    @Step("Logout from user")
    public void logout (){
        menuButton.click();
        logout.click();
    }
}
