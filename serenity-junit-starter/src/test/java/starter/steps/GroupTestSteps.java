package starter.steps;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import starter.page.GroupPage;

public class GroupTestSteps {

    GroupPage groupPage;

    @Step("Переходим в группы")
    public void goToGroups() {
        groupPage.goToGroups();
    }

    @Step("Вступаем в группу")
    public void joinGroup() {
        groupPage.joinGroup();
    }

    @Step("Переходим в группу, в которую вступили")
    public void goToNewGroup() {
        groupPage.goToNewGroup();
    }

    @Step("Проверяем вступили ли мы в группу")
    public void checkJoin(WebDriver driver) {
        groupPage.checkJoin(driver);
    }

    @Step("Выходим из группы")
    public void leaveGroup() {
        groupPage.leaveGroup();
    }

    @Step("Проверяем вышли ли мы из группы")
    public void checkLeave(WebDriver driver) {
        groupPage.checkLeave(driver);
    }
}
