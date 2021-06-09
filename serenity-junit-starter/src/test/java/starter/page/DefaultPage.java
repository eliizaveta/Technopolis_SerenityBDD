package starter.page;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DefaultPage extends PageObject {

    public boolean isElementHere(String LOCATOR) {
        try{
            find(LOCATOR);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    public boolean isElementHere(WebDriver driver, String XPATH){
        try{
            driver.findElement(By.xpath(XPATH));
            return false;
        } catch (Exception e) {
            return true;
        }
    }
    public boolean isElementHere(WebDriver driver, String CSS_SELECTOR, WebElement shadowDom){
        try{
            shadowDom.findElement(By.cssSelector(CSS_SELECTOR));
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    public void clickOnElement(String XPATH){
        find(By.xpath(XPATH)).click();
    }
    public void clickOnElement(WebElement shadowDom, String CSS_SELECTOR) {
        shadowDom.findElement(By.cssSelector(CSS_SELECTOR)).click();
    }
}
