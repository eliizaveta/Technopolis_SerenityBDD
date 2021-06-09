package starter.steps;

import net.thucydides.core.annotations.Step;
import starter.page.LoginPage;

public class LoginPageSteps {

    LoginPage loginPage;

    @Step("Переходим на страницу одноклассников")
    public void openPage() {
        loginPage.open();
    }

    @Step("Логинимся")
    public void doLogin() {
        loginPage.doLogin();
    }
}
