package starter.page;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MessagePage extends PageObject {

    private By MSG_LOCATOR = By.xpath(".//div[@id = 'msg_toolbar_button']");
    private By PLUS_BUTTON = By.cssSelector("msg-button[data-tsid='open_plus_button']");
    private By CREATE_CHAT_BUTTON = By.cssSelector("msg-menu-item[data-tsid='plus_create_chat']");
    private By CREATE_EMPTY_CHAT_BUTTON = By.cssSelector("msg-button[data-tsid='finish_create_chat_button']");
    private By OPEN_STICKERS_BUTTON = By.cssSelector("msg-button[data-tsid='open_smiles_button']");
    private By POPULAR_STICKER1 = By.cssSelector("msg-assets-sticker[set-id='popular_stickers']");
    private By MSG_CONTAINER = By.cssSelector("msg-message-new");
    private By ACTIONS_WITH_MSG_BUTTON = By.cssSelector("msg-button[data-tsid='more_message']");
    private By DELETE_MSG_BUTTON = By.cssSelector("msg-tico[data-tsid='remove_msg_button']");
    private By CONFIRM_PRIMARY = By.cssSelector("msg-button[data-tsid='confirm-primary']");
    private By CHAT_INFO_BUTTON = By.cssSelector("msg-button[data-tsid='chat_info_button']");
    private By LEAVE_CHAT_BUTTON = By.cssSelector("msg-tico[data-tsid='leave-chat-btn']");
    private By ROOT_ID= By.id("msg_layer");
    private By TEMP_MSG = By.cssSelector("msg-message-new[class='__removed']");

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
        System.out.println(isMsgHere(driver));
        Assert.assertFalse("Message wasn't sent", isMsgHere(driver));
        System.out.println("Message sent successfully");
    }
    public void checkMsgDeleted(WebDriver driver) {
        Assert.assertTrue("Message wasn't deleted", isMsgHere(driver));
        System.out.println("Message deleted successfully");
    }

    private boolean isMsgHere(WebDriver driver){
        WebElement shadowDom = findShadowDomRoot(driver);
        try{
            shadowDom.findElement(TEMP_MSG);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public void clickOnElement(WebElement shadowDom, By css) {
        shadowDom.findElement(css).click();
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
