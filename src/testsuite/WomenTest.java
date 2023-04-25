package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utilities {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    //1. verifyTheSortByProductNameFilter







    @Test
    public void verifyTheSortByProductNameFilter() {

        //* Mouse Hover on Women Menu
        mouseHoverOnElement(By.xpath("//a[@class='level-top ui-corner-all'][@id='ui-id-4']"));

        //* Mouse Hover on Tops
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-9']"));

        //* Click on Jackets
        mouseHoverClick(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        //* Select Sort By filter “Product Name”


        WebElement dropDown =driver.findElement(By.className("sorter-options"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Product Name");

//  * Verify the products name display in alphabetical order
        List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@class='product details product-item-details']//strong[@class='product name product-item-name']"));

        ArrayList<String> actualList = new ArrayList<>();
        for (WebElement element : listOfElements) {
            actualList.add(element.getText());
        }
        System.out.println(actualList);

        ArrayList<String> expectedList = new ArrayList<>();
        for (WebElement element : listOfElements) {
            expectedList.add(element.getText());
        }

        Collections.sort(expectedList);
        System.out.println(expectedList);
        Assert.assertEquals("Not matching", expectedList, actualList);


    }


//    2. verifyTheSortByPriceFilter






    @Test
    public void verifyTheSortByPriceFilter(){
        //* Mouse Hover on Women Menu
        mouseHoverOnElement(By.xpath("//a[@class='level-top ui-corner-all'][@id='ui-id-4']"));

        //* Mouse Hover on Tops
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-9']"));

        //* Click on Jackets
        mouseHoverClick(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));
        //* Select Sort By filter “Price”

        WebElement dropDown =driver.findElement(By.className("sorter-options"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Price");

        //* Verify the products price display in Low to High


        List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@class='product details product-item-details']//div[@class='price-box price-final_price']"));



        ArrayList<String> actualList = new ArrayList<>();
        for (WebElement element : listOfElements) {
            actualList.add(element.getText());
        }
        System.out.println(actualList);

        ArrayList<String> expectedList = new ArrayList<>();
        for (WebElement element : listOfElements) {
            expectedList.add(element.getText());
        }

        Collections.sort(expectedList);
        System.out.println(expectedList);
        Assert.assertEquals("Not matching", expectedList, actualList);



    }


    @After
    public void tearDown() {

closeBrowser();
    }





}
