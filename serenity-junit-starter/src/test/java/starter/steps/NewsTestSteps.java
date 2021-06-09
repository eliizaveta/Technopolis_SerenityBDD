package starter.steps;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import starter.page.LoginPage;
import starter.page.NewsPage;

public class NewsTestSteps {

    LoginPage loginPage;
    NewsPage newsPage;

    @Step("Открываем страницу одноклассников")
    public void openPage() {
        loginPage.open();
    }

    @Step("Логинимся")
    public void doLogin() {
        loginPage.doLogin();
    }

    @Step("Создаем заметку")
    public void createNote(String NOTE, WebDriver driver) {
        newsPage.createNote(NOTE, driver);
    }

    @Step("Переходим на страницу профиля")
    public void goToProfilePage() {
        newsPage.goToProfilePage();
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
