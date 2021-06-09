package starter.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPage extends DefaultPage {


    String LIST_OF_ABILITIES_BUTTON = ".//div[@class='feed_menu_ic']";
    String NOTE_BOX_LOCATOR = ".//div[contains(@class, 'posting_itx emoji-tx')]";
    String NOTE_LOCATOR = ".//div[@class='pf-head_itx']";
    String POSTING_BUTTON = ".//div[@class='posting_submit button-pro']";
    String LIKE_LOCATOR = ".//span[@class='widget_cnt controls-list_lk js-klass js-klass-action h-mod']";
    String SHARE_BUTTON = ".//button[@data-type='RESHARE']";
    String SHARE_NOW_BUTTON = ".//span[contains(text(), 'Поделиться сейчас')]";
    String DELETE_BUTTON = ".//div[@id='hook_Block_ShortcutMenu']//i[contains(@class,'delete')]";
    String NOTES_LIST = ".//a[contains(text(), 'Заметки')]";
    String REPOST_LOCATOR = ".//div[@class='feed js-video-scope h-mod']";
    String LIKE_REACT = ".//span[@class='widget_tx __react-like']";
    String DELETED_NOTE = ".//span[@class='delete-stub_info tico']";


    public void sharePost(WebDriver driver) {
        clickOnElement(SHARE_BUTTON);
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.xpath(SHARE_NOW_BUTTON)));
        clickOnElement(SHARE_NOW_BUTTON);
    }

    public void checkRepost() {
        Assert.assertTrue("You didn,t repost smth", isElementHere(REPOST_LOCATOR));
        System.out.println("Repost sent successfully");
    }


    public void like() {
        clickOnElement(LIKE_LOCATOR);
    }

    public void checkLike() {
        Assert.assertTrue("You didn,t like smth", isElementHere(LIKE_REACT));
        System.out.println("Like added successfully");
    }


    public void createNote(String NOTE, WebDriver driver){
        clickOnElement(NOTE_LOCATOR);
        find(By.xpath(NOTE_BOX_LOCATOR)).sendKeys(NOTE);
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.xpath(POSTING_BUTTON)));
        clickOnElement(POSTING_BUTTON);
    }

    public void deleteNote(WebDriver driver) {
        Actions action = new Actions(driver);
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.xpath(NOTES_LIST)));
        clickOnElement(NOTES_LIST);
        action.moveToElement(find(By.xpath(LIST_OF_ABILITIES_BUTTON))).build().perform();
        clickOnElement(DELETE_BUTTON);
    }

    public void checkCreateNote(String note) {
        Assert.assertTrue("You didn,t note smth", isElementHere(".//div[text()='"+ note +"']"));
        System.out.println("Note created successfully");
    }

    public void checkDeleteNote() {
        Assert.assertTrue("You didn,t delete note", isElementHere(DELETED_NOTE));
        System.out.println("Note deleted successfully");
    }
}
