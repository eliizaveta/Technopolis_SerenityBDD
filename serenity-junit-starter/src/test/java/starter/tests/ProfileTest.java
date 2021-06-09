package starter.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import starter.steps.LoginPageSteps;
import starter.steps.ProfileTestSteps;

@RunWith(SerenityRunner.class)
@Narrative(text={"Группа тестов на странице профиля"})
public class ProfileTest {

    String NEW_CITY_1 = "Санкт-Петербург, Россия";
    String NEW_CITY_2 = "Москва, Россия";
    String NEW_CITY_3 = "Технополис";

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
    @Title("Тест на изменение города на Санкт-Петербург")
    public void ProfileTest1() {
        profileTestSteps.goToProfilePage();
        profileTestSteps.goToProfileEdit();
        profileTestSteps.changeCurrentCity(NEW_CITY_1);

    }

    @Test
    @Title("Тест на изменение города на Москву")
    public void ProfileTest2() {
        profileTestSteps.goToProfilePage();
        profileTestSteps.goToProfileEdit();
        profileTestSteps.changeCurrentCity(NEW_CITY_2);

    }

    @Test
    @Title("Изменение города на Технополис, тест с ошибкой")
    public void ProfileTest3() {
        profileTestSteps.goToProfilePage();
        profileTestSteps.goToProfileEdit();
        profileTestSteps.changeCurrentCity(NEW_CITY_3);
    }

    @After
    public void Clear() {}
}
