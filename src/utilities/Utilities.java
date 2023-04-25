package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Utilities extends BaseTest {

    public void mouseHoverOnElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

public void mouseHoverClick(By by) {
    Actions actions = new Actions(driver);
    actions.moveToElement(driver.findElement(by)).click().build().perform();
}

    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }


    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public void clickOnElement(By by){
        driver.findElement(by).click();
    }







}




