package starter.page;


import org.openqa.selenium.By;

public class ProfilePage extends DefaultPage {

    String PROFILE_LOCATOR = ".//div[@class='tico ellip']";
    String PROFILE_EDIT_LINK = ".//div[@class='user-profile_edit-link']";
    String PERSONAL_DATA_EDIT = ".//div[@class='user-profile_i']//a[@class='user-profile_lk-o']";
    String CURRENT_CITY_LOCATOR = ".//input[@id='field_citySugg_SearchInput']";
    String CONFIRM_BUTTON = ".//input[contains(@class, 'yes')]";
    String CITY_INPUT_LOCATOR = ".//div[@id='citySugg_InputContainer']";
    String FIRST_CITY = ".//div[@class='ellip']";
    String MAIN_PAGE_LOCATOR = ".//div[@id='topPanelLeftCorner']";

    public ProfilePage goToMainPage(){
        clickOnElement(MAIN_PAGE_LOCATOR);
        return this;
    }

    public ProfilePage goToProfilePage() {
        clickOnElement(PROFILE_LOCATOR);
        return this;
    }

    public void goToEdit(){clickOnElement(PROFILE_EDIT_LINK);}

    public ProfilePage goToPersonalDataEdit(){
        clickOnElement(PERSONAL_DATA_EDIT);
        return this;
    }

    public void changeCurrentCity(String newCity) {
        find(By.xpath(CURRENT_CITY_LOCATOR)).clear();
        find(By.xpath(CURRENT_CITY_LOCATOR)).sendKeys(newCity);
        clickOnElement(CITY_INPUT_LOCATOR);
        clickOnElement(FIRST_CITY);
        clickOnElement(CONFIRM_BUTTON);
    }
}
