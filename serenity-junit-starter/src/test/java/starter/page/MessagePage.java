package starter.page;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MessagePage extends DefaultPage {

    private By MSG_LOCATOR = By.xpath(".//div[@id = 'msg_toolbar_button']");
    String PLUS_BUTTON = "msg-button[data-tsid='open_plus_button']";
    String CREATE_CHAT_BUTTON = "msg-menu-item[data-tsid='plus_create_chat']";
    String CREATE_EMPTY_CHAT_BUTTON = "msg-button[data-tsid='finish_create_chat_button']";
    String OPEN_STICKERS_BUTTON = "msg-button[data-tsid='open_smiles_button']";
    String POPULAR_STICKER1 = "msg-assets-sticker[set-id='popular_stickers']";
    String ACTIONS_WITH_MSG_BUTTON = "msg-button[data-tsid='more_message']";
    String DELETE_MSG_BUTTON = "msg-tico[data-tsid='remove_msg_button']";
    String CONFIRM_PRIMARY = "msg-button[data-tsid='confirm-primary']";
    String CHAT_INFO_BUTTON = "msg-button[data-tsid='chat_info_button']";
    String LEAVE_CHAT_BUTTON = "msg-tico[data-tsid='leave-chat-btn']";
    String TEMP_MSG = "msg-message-new[class='__removed']";

    private By MSG_CONTAINER = By.cssSelector("msg-message-new");
    private By ROOT_ID= By.id("msg_layer");

    public void goToMSG() {
        find(MSG_LOCATOR).click();
    }

    private WebElement findShadowDomRoot(WebDriver driver) {
        WebElement root = find(ROOT_ID);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadowDom = (WebElement) js.executeScript("return arguments[0].shadowRoot", root);
        return shadowDom;
    }
    public void checkMsgSent(WebDriver driver) {
        Assert.assertFalse("Message wasn't sent", isElementHere(driver, TEMP_MSG, findShadowDomRoot(driver)));
        System.out.println("Message sent successfully");
    }
    public void checkMsgDeleted(WebDriver driver) {
        Assert.assertTrue("Message wasn't deleted", isElementHere(driver, TEMP_MSG, findShadowDomRoot(driver)));
        System.out.println("Message deleted successfully");
    }

    public void createEmptyChat(WebDriver driver) {
        WebElement shadowDom = findShadowDomRoot(driver);
        clickOnElement(shadowDom, PLUS_BUTTON);
        clickOnElement(shadowDom, CREATE_CHAT_BUTTON);
        clickOnElement(shadowDom, CREATE_EMPTY_CHAT_BUTTON);
    }

    public void sendSticker(WebDriver driver) {
        WebElement shadowDom = findShadowDomRoot(driver);
        clickOnElement(shadowDom, OPEN_STICKERS_BUTTON);
        clickOnElement(shadowDom, POPULAR_STICKER1);
    }

    public void deleteMsg(WebDriver driver) {
        WebElement shadowDom = findShadowDomRoot(driver);
        Actions action = new Actions(driver);
        action.moveToElement(shadowDom.findElement(MSG_CONTAINER)).build().perform();

        clickOnElement(shadowDom, ACTIONS_WITH_MSG_BUTTON);
        clickOnElement(shadowDom, DELETE_MSG_BUTTON);
        clickOnElement(shadowDom, CONFIRM_PRIMARY);
    }

    public void deleteChat(WebDriver driver) {
        WebElement shadowDom = findShadowDomRoot(driver);
        clickOnElement(shadowDom, CHAT_INFO_BUTTON);
        clickOnElement(shadowDom, LEAVE_CHAT_BUTTON);
        clickOnElement(shadowDom, CONFIRM_PRIMARY);
    }
}
