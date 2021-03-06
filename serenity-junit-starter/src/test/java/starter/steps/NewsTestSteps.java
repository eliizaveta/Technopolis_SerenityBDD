package starter.steps;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import starter.page.NewsPage;

public class NewsTestSteps {

    NewsPage newsPage;

    @Step("Создаем заметку")
    public void createNote(String NOTE, WebDriver driver) {
        newsPage.createNote(NOTE, driver);
    }

    @Step("Проверяем создалась ли заметка {0}")
    public void checkCreateNote(String NOTE) {
        newsPage.checkCreateNote(NOTE);
    }

    @Step("Удаляем заметку")
    public void deleteNote(WebDriver driver) {
        newsPage.deleteNote(driver);
    }

    @Step("Проверяем удалилась ли заметка")
    public void checkDeleteNote() {
        newsPage.checkDeleteNote();
    }

    @Step("Ставим лайк на запись")
    public void like() {
        newsPage.like();
    }

    @Step("Проверяем наличие лайка на записи")
    public void checkLike() {
        newsPage.checkLike();
    }

    @Step("Делимся записью на своей странице")
    public void sharePost(WebDriver driver) {
        newsPage.sharePost(driver);
    }

    @Step("Проверяем репост")
    public void checkRepost() {
        newsPage.checkRepost();
    }
}
