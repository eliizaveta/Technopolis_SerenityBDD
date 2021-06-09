package starter.page;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ProfilePage extends PageObject {

    private By PROFILE_LOCATOR = By.xpath(".//div[@class='tico ellip']");
    private By PROFILE_EDIT_LINK = By.xpath(".//div[@class='user-profile_edit-link']");
    private By PERSONAL_DATA_EDIT = By.xpath(".//div[@class='user-profile_i']//a[@class='user-profile_lk-o']");
    private By CURRENT_CITY_LOCATOR = By.xpath(".//input[@id='field_citySugg_SearchInput']");
    private By CONFIRM_BUTTON = By.xpath(".//input[contains(@class, 'yes')]");
    private By CITY_INPUT_LOCATOR = By.xpath(".//div[@id='citySugg_InputContainer']");
    private By FIRST_CITY = By.xpath(".//div[@class='ellip']");
    private By MAIN_PAGE_LOCATOR = By.xpath(".//div[@id='topPanelLeftCorner']");

    public void goToMainPage(){
        find(MAIN_PAGE_LOCATOR).click();
    }

    public void goToProfilePage() {
        find(PROFILE_LOCATOR).click();
    }

    public void goToEdit(){
        find(PROFILE_EDIT_LINK).click();
    }

    public void goToPersonalDataEdit(){
        find(PERSONAL_DATA_EDIT).click();
    }

    public void changeCurrentCity(String newCity) {
        find(CURRENT_CITY_LOCATOR).clear();
        find(CURRENT_CITY_LOCATOR).sendKeys(newCity);
        find(CITY_INPUT_LOCATOR).click();
        find(FIRST_CITY).click();
        find(CONFIRM_BUTTON).click();
    }
}
