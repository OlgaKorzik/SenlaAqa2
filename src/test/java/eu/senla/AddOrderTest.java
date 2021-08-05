package eu.senla;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddOrderTest extends BaseClass{
    private PageMetods pageMetods =new PageMetods();

@BeforeEach
    public void login(){
   pageMetods.login();
}
@Test
@DisplayName("Check to adding of new order")
    public void addNewOrder(){
       pageMetods.addOrder();
       String element = pageMetods.getTextForFinishPage();
       assertEquals("THANK YOU FOR YOUR ORDER",element, "Order don't add");

}
}
