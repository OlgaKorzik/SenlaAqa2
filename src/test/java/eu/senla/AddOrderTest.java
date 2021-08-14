package eu.senla;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddOrderTest extends BaseClass{
    private PageMethods pageMethods =new PageMethods();

@BeforeEach
    public void login(){
   pageMethods.login();
}

@Feature("Order")
@Story("Add order")
@Severity(SeverityLevel.CRITICAL)
@Description("Add order test")
@Test
@DisplayName("Check to adding of new order")
    public void addNewOrderTest(){
       pageMethods.addOrder();
       String element = pageMethods.getTextForFinishPage();
       assertEquals("THANK YOU FOR YOUR ORDER",element, "Order don't add");

}
}
