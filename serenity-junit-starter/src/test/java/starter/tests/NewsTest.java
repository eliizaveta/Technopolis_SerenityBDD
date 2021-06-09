package starter.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import starter.steps.LoginPageSteps;
import starter.steps.NewsTestSteps;
import starter.steps.ProfileTestSteps;

import java.util.Random;

@RunWith(SerenityRunner.class)
@Narrative(text={"Группа тестов на странице новостей"})
public class NewsTest {

    Random rnd = new Random(System.currentTimeMillis());
    String NOTE = "NEW NOTE №" + rnd.nextInt(100);

    @Steps
    NewsTestSteps newsTestSteps;
    @Steps
    ProfileTestSteps profileTestSteps;
    @Steps
    LoginPageSteps loginPageSteps;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Before
    public void Init() {
        loginPageSteps.openPage();
        loginPageSteps.doLogin();
    }

    @Test
    @Title("Тест на создание и удаление заметки")
    public void NoteTest() {
        newsTestSteps.createNote(NOTE, driver);
        profileTestSteps.goToProfilePage();
        newsTestSteps.checkCreateNote(NOTE);

    }

    @Test
    @Title("Тест на оценку записи")
    public void LikeTest() {
        newsTestSteps.like();
        newsTestSteps.checkLike();
    }

    @Test
    @Title("Тест на создание и удаление репоста")
    @Pending
    public void RepostTest() {
        newsTestSteps.sharePost(driver);
        profileTestSteps.goToProfilePage();
        newsTestSteps.checkRepost();
    }

    @After
    public void Clear() {
        newsTestSteps.deleteNote(driver);
        newsTestSteps.checkDeleteNote();
    }
}
