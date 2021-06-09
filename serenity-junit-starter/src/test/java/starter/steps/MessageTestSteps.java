package starter.steps;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import starter.page.LoginPage;
import starter.page.MessagePage;

public class MessageTestSteps {

    LoginPage loginPage;
    MessagePage messagePage;

    @Step("Переходим на страницу одноклассников")
    public void openPage() {
        loginPage.open();
    }

    @Step("Логинимся")
    public void doLogin() {
        loginPage.doLogin();
    }

    @Step("Переходим в раздел сообщений")
    public void goToMSG(){messagePage.goToMSG();}

    @Step("Создаем пустой чат")
    public void createEmptyChat(WebDriver driver){messagePage.createEmptyChat(driver);}

    @Step("Отправляем сообщение со стикером")
    public void sendSticker(WebDriver driver){messagePage.sendSticker(driver);}

    @Step("Проверяем отправление сообщения")
    public void checkMsgSent(WebDriver driver){messagePage.checkMsgSent(driver);}

    @Step("Удаляем сообщение")
    public void deleteMsg(WebDriver driver){messagePage.deleteMsg(driver);}

    @Step("Проверяем удалилось ли сообщение")
    public void checkMsgDeleted(WebDriver driver){messagePage.checkMsgDeleted(driver);}

    @Step("Удаляем чат")
    public void deleteChat(WebDriver driver){messagePage.deleteChat(driver);}
}
