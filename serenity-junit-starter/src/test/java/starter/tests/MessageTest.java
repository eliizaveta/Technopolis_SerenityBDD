package starter.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import starter.steps.LoginPageSteps;
import starter.steps.MessageTestSteps;

@RunWith(SerenityRunner.class)
@Narrative(text={"Группа тестов на странице сообщений"})
public class MessageTest {

    @Steps
    MessageTestSteps messageTestSteps;
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
    @Title("Тест на отправку и удаление сообщения")
    @Ignore
    public void MessageTest() {
        messageTestSteps.goToMSG();
        messageTestSteps.createEmptyChat(driver);
        messageTestSteps.sendSticker(driver);
        messageTestSteps.checkMsgSent(driver);
        messageTestSteps.deleteMsg(driver);
        messageTestSteps.checkMsgDeleted(driver);
    }

    @After
    public void Clear() {
        messageTestSteps.deleteChat(driver);
    }
}
