package starter.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPage extends PageObject {

    private By NOTE_LOCATOR = By.xpath(".//div[@class='pf-head_itx']");
    private By NOTE_BOX_LOCATOR = By.xpath(".//div[contains(@class, 'posting_itx emoji-tx')]");
    private By POSTING_BUTTON = By.xpath(".//div[@class='posting_submit button-pro']");
    private By DELETED_NOTE = By.xpath(".//span[@class='delete-stub_info tico']");
    private By LIKE_LOCATOR = By.xpath(".//span[@class='widget_cnt controls-list_lk js-klass js-klass-action h-mod']");
    private By LIKE_REACT = By.xpath(".//span[@class='widget_tx __react-like']");
    private By SHARE_BUTTON = By.xpath(".//button[@data-type='RESHARE']");
    private By SHARE_NOW_BUTTON = By.xpath(".//span[contains(text(), 'Поделиться сейчас')]");
    private By REPOST_LOCATOR = By.xpath(".//div[@class='feed js-video-scope h-mod']");
    private By PROFILE_LOCATOR = By.xpath(".//div[@class='tico ellip']");
    private By LIST_OF_ABILITIES_BUTTON = By.xpath(".//div[@class='feed_menu_ic']");
    private By DELETE_BUTTON = By.xpath(".//div[@id='hook_Block_ShortcutMenu']//i[contains(@class,'delete')]");
    private By NOTES_LIST = By.xpath(".//a[contains(text(), 'Заметки')]");

    public void goToProfilePage() {
        find(PROFILE_LOCATOR).click();
    }

    public void sharePost(WebDriver driver) {
        find(SHARE_BUTTON).click();
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(SHARE_NOW_BUTTON));
        find(SHARE_NOW_BUTTON).click();
    }

    public void checkRepost() {
        Assert.assertTrue("You didn,t repost smth", isRepostHere());
        System.out.println("Repost sent successfully");
    }

    private boolean isRepostHere() {
        try{
            find(REPOST_LOCATOR);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public void like() {
        find(LIKE_LOCATOR).click();
    }

    public void checkLike() {
        Assert.assertTrue("You didn,t like smth", isLikeHere());
        System.out.println("Like added successfully");
    }

    private boolean isLikeHere() {
        try{
            find(LIKE_REACT);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public void createNote(String NOTE, WebDriver driver){
        find(NOTE_LOCATOR).click();
        find(NOTE_BOX_LOCATOR).sendKeys(NOTE);
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(POSTING_BUTTON));
        find(POSTING_BUTTON).click();
    }

    public void deleteNote(WebDriver driver) {
        Actions action = new Actions(driver);
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.presenceOfElementLocated(NOTES_LIST));
        find(NOTES_LIST).click();
        action.moveToElement(find(LIST_OF_ABILITIES_BUTTON)).build().perform();
        find(DELETE_BUTTON).click();
    }

    public void checkCreateNote(String note) {
        Assert.assertTrue("You didn,t note smth", isNoteCreated(note));
        System.out.println("Note created successfully");
    }

    public void checkDeleteNote() {
        Assert.assertTrue("You didn,t delete note", isNoteDeleted());
        System.out.println("Note deleted successfully");
    }

    private boolean isNoteCreated(String note) {
        try{
            find(".//div[text()='"+ note +"']");
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    private boolean isNoteDeleted() {
        try{
            find(DELETED_NOTE);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
