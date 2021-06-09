package starter.steps;

import net.thucydides.core.annotations.Step;
import starter.page.ProfilePage;

public class ProfileTestSteps {

    ProfilePage profilePage;

    @Step
    public void goToProfilePage() {
        profilePage.goToProfilePage();
    }

    @Step("Переходим в настройки профиля")
    public void goToProfileEdit(){
        profilePage.goToEdit();
        profilePage.goToPersonalDataEdit();
    }

    @Step("Изменяем город")
    public void changeCurrentCity(String newCity){
        profilePage.changeCurrentCity(newCity);
        profilePage.goToMainPage();
    }
}
