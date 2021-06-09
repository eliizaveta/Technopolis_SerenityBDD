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
import starter.steps.GroupTestSteps;
import starter.steps.LoginPageSteps;

@RunWith(SerenityRunner.class)
@Narrative(text={"Группа тестов на странице групп"})
public class GroupTest {

    @Steps
    GroupTestSteps groupTestSteps;
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
    @Title("Тест на втупление и выход из группы")
    public void GroupTest() {
        groupTestSteps.goToGroups();
        groupTestSteps.joinGroup();
        groupTestSteps.goToNewGroup();
        groupTestSteps.checkJoin(driver);
        groupTestSteps.leaveGroup();
        groupTestSteps.checkLeave(driver);
    }

    @After
    public void Clear() {}
}
