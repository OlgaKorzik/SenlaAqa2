package eu.senla;

import com.codeborne.selenide.SelenideElement;
import eu.senla.utils.IConstant;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class LoginPage {
    SelenideElement loginInput = $(By.id("user-name"));
    SelenideElement passwordInput = $("#password");
    SelenideElement singInButton = $(By.name("login-button"));
    SelenideElement menuButton = $(By.id("react-burger-menu-btn"));
    SelenideElement logout = $(By.id("logout_sidebar_link"));

    public void login() {
        open(IConstant.URL);
        loginInput.sendKeys(IConstant.USERNAME);
        passwordInput.sendKeys(IConstant.PASSWORD);
        singInButton.click();
    }

    public void loginOpenPage(){
        open(IConstant.URL);
    }
    public void logout (){
        menuButton.click();
        logout.click();
    }
}
