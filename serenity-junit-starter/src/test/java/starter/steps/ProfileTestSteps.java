package starter.steps;

import net.thucydides.core.annotations.Step;
import starter.page.LoginPage;
import starter.page.ProfilePage;

public class ProfileTestSteps {

    LoginPage loginPage;
    ProfilePage profilePage;

    @Step("Открываем страницу одноклассников")
    public void openPage() {
        loginPage.open();
    }

    @Step("Логинимся")
    public void doLogin() {
        loginPage.doLogin();
    }

    @Step("Переходим в настройки профиля")
    public void goToProfileEdit(){
        profilePage.goToProfilePage();
        profilePage.goToEdit();
        profilePage.goToPersonalDataEdit();
    }

    @Step("Изменяем город")
    public void changeCurrentCity(String newCity){
        profilePage.changeCurrentCity(newCity);
        profilePage.goToMainPage();
    }
}
