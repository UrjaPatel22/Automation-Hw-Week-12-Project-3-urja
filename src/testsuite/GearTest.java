package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utilities;

public class GearTest extends Utilities {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


//    userShouldAddProductSuccessFullyToShoppingCart()

@Test
public void userShouldAddProductSuccessFullyToShoppingCart(){

        //Mouse Hover on Gear Menu

    mouseHoverOnElement(By.xpath("//a[@id='ui-id-6']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));

//* Click on Bags


    mouseHoverClick(By.xpath("//span[normalize-space()='Bags']"));

    //* Click on Product Name ‘Overnight Duffle’
    clickOnElement(By.xpath("//img[@alt='Overnight Duffle']"));

    //* Verify the text ‘Overnight Duffle’

    String expectedMessage1= "Overnight Duffle";
    String actualMessage1=getTextFromElement(By.xpath("//span[contains(text(),'Overnight Duffle')]"));
    Assert.assertEquals("Error Message displayed",expectedMessage1,actualMessage1);

    //Change Qty 3
    WebElement element = driver.findElement(By.xpath("//input[@id='qty']"));
element.clear();
sendTextToElement(By.xpath("//input[@id='qty']"),"3");



//* Click on ‘Add to Cart’ Button.

    clickOnElement(By.xpath("//span[normalize-space()='Add to Cart']"));


    // Verify the text You added Overnight Duffle to your shopping cart.
    String expectedBag= "You added Overnight Duffle to your shopping cart.";
    String actualBag=getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
    Assert.assertEquals("Error Message displayed",expectedBag,actualBag);

//Click on ‘shopping cart’ Link into message

    clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

    //* Verify the product name ‘Overnight Duffle’


    String expectedName= "Overnight Duffle";
    String actualName=getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
    Assert.assertEquals("Error Message displayed",expectedName,actualName);


// Verify Qty 3

    WebElement element12 = driver.findElement(By.cssSelector(".input-text.qty"));
    String actualQty=  element12.getAttribute("value");
    String expectedQty= "3";
    Assert.assertEquals("Error Message displayed",expectedQty,actualQty);


//* Verify the product price ‘$135.00’

    String expectedPrice= "$135.00";
    String actualPrice=getTextFromElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"));
    Assert.assertEquals("Error Message displayed",expectedPrice,actualPrice);
//Change Qty to ‘5’

    WebElement element2 = driver.findElement(By.cssSelector(".input-text.qty"));
    element2.clear();

sendTextToElement(By.cssSelector(".input-text.qty"),"5");




//* Click on ‘Update Shopping Cart’ button


clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));



  //  * Verify the product price ‘$225.00’

    String expectedPrice1= "$225.00";
    String actualPrice1=getTextFromElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$225.00']"));
    Assert.assertEquals("Error Message displayed",expectedPrice1,actualPrice1);

}





    @After
    public void tearDown() {

closeBrowser();
    }
}