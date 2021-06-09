package starter.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import starter.steps.MessageTestSteps;

@RunWith(SerenityRunner.class)
@Narrative(text={"Группа тестов на странице сообщений"})
public class MessageTest {

    @Steps
    MessageTestSteps steps;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    @Title("Тест на отправку и удаление сообщения")
    @Ignore
    public void MessageTest() {
        steps.openPage();
        steps.doLogin();
        steps.goToMSG();
        steps.createEmptyChat(driver);
        steps.sendSticker(driver);
        steps.checkMsgSent(driver);
        steps.deleteMsg(driver);
        steps.checkMsgDeleted(driver);
        steps.deleteChat(driver);
    }
}
