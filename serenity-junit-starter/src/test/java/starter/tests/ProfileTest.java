package starter.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import starter.steps.ProfileTestSteps;

@RunWith(SerenityRunner.class)
@Narrative(text={"Группа тестов на странице профиля"})
public class ProfileTest {

    String NEW_CITY_1 = "Санкт-Петербург, Россия";
    String NEW_CITY_2 = "Москва, Россия";
    String NEW_CITY_3 = "Технополис";

    @Steps
    ProfileTestSteps steps;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    @Title("Тест на изменение города на Санкт-Петербург")
    public void ProfileTest1() {
        steps.openPage();
        steps.doLogin();
        steps.goToProfileEdit();
        steps.changeCurrentCity(NEW_CITY_1);

    }

    @Test
    @Title("Тест на изменение города на Москву")
    public void ProfileTest2() {
        steps.openPage();
        steps.doLogin();
        steps.goToProfileEdit();
        steps.changeCurrentCity(NEW_CITY_2);

    }

    @Test
    @Title("Изменение города на Технополис, тест с ошибкой")
    public void ProfileTest3() {
        steps.openPage();
        steps.doLogin();
        steps.goToProfileEdit();
        steps.changeCurrentCity(NEW_CITY_3);
    }
}
