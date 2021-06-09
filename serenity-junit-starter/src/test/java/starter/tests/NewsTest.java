package starter.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import starter.steps.NewsTestSteps;

import java.util.Random;

@RunWith(SerenityRunner.class)
@Narrative(text={"Группа тестов на странице новостей"})
public class NewsTest {

    Random rnd = new Random(System.currentTimeMillis());
    String NOTE = "NEW NOTE №" + rnd.nextInt(100);

    @Steps
    NewsTestSteps steps;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    @Title("Тест на создание и удаление заметки")
    public void NoteTest() {
        steps.openPage();
        steps.doLogin();
        steps.createNote(NOTE, driver);
        steps.goToProfilePage();
        steps.checkCreateNote(NOTE);
        steps.deleteNote(driver);
        steps.checkDeleteNote();
    }

    @Test
    @Title("Тест на оценку записи")
    public void LikeTest() {
        steps.openPage();
        steps.doLogin();
        steps.like();
        steps.checkLike();
    }

    @Test
    @Title("Тест на создание и удаление репоста")
    @Pending
    public void RepostTest() {
        steps.openPage();
        steps.doLogin();
        steps.sharePost(driver);
        steps.goToProfilePage();
        steps.checkRepost();
        steps.deleteNote(driver);
    }
}
