package starter.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import starter.steps.GroupTestSteps;

@RunWith(SerenityRunner.class)
@Narrative(text={"Группа тестов на странице групп"})
public class GroupTest {

    @Steps
    GroupTestSteps steps;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    @Title("Тест на втупление и выход из группы")
    public void GroupTest() {
        steps.openPage();
        steps.doLogin();
        steps.goToGroups();
        steps.joinGroup();
        steps.goToNewGroup();
        steps.checkJoin(driver);
        steps.leaveGroup();
        steps.checkLeave(driver);
    }
}
