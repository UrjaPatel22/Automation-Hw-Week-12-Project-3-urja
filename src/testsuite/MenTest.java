package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utilities;

public class MenTest extends Utilities {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

//1. userShouldAddProductSuccessFullyTo ShoppingCart()

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart(){
        //* Mouse Hover on Men Menu

        mouseHoverOnElement(By.xpath("//a[@id='ui-id-5']//span[contains(text(),'Men')]"));
        // * Mouse Hover on Bottoms

        mouseHoverOnElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));

        //* Click on Pants
        mouseHoverClick(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));

//* Mouse Hover on product name‘Cronus Yoga Pant’ and click on size 32.

mouseHoverOnElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/cronus-yoga-pant.html']//span[@class='product-image-container']"));
mouseHoverClick(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));

//Mouse Hover on product name Cronus Yoga Pants’ and click on colourBlack.
        mouseHoverOnElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/cronus-yoga-pant.html']//span[@class='product-image-container']"));
mouseHoverClick(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));

// Mouse Hover on product name Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHoverOnElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/cronus-yoga-pant.html']//span[@class='product-image-container']"));

        mouseHoverClick(By.xpath("//span[contains(text(),'Add to Cart')][1]"));

//* Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’


        String expectedMessage= "You added Cronus Yoga Pant to your shopping cart.";


        String actualMessage=getTextFromElement(By.xpath("//div[@class='message-success success message']"));
        Assert.assertEquals("Error Message displayed",expectedMessage,actualMessage);

//* Click on ‘shopping cart’ Link into message

        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

//* Verify the text ‘Shopping Cart.’

        String expectedMessage1= "Shopping Cart";
        String actualMessage1=getTextFromElement(By.xpath("//span[@class='base']"));
        Assert.assertEquals("Error Message displayed",expectedMessage1,actualMessage1);

//* Verify the product name ‘Cronus Yoga Pant’

        String expectedProductName= "Cronus Yoga Pant";
        String actualProductName=getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        Assert.assertEquals("Error Message displayed",expectedProductName,actualProductName);

//* Verify the product size ‘32’

        String expectedSize= "32";
        String actualSize=getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals("Error Message displayed",expectedSize,actualSize);

//* Verify the product colour ‘Black’
        String expectedColor= "Black";
        String actualColor=getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        Assert.assertEquals("Error Message displayed",expectedColor,actualColor);


}
    @After
    public void tearDown() {

closeBrowser();
    }






}



