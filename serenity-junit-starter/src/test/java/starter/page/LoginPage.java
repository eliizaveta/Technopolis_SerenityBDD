package starter.page;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://ok.ru/")
public class LoginPage extends DefaultPage {

    private By LOGIN_LOCATOR = By.xpath(".//input[@id='field_email']");
    private By PASSWORD_LOCATOR = By.xpath(".//input[@id='field_password']");
    private String SIGN_IN_LOCATOR = ".//input[@class = 'button-pro __wide']";
    private String login = "technopolisbot1";
    private String password = "technopolis16";

    public LoginPage doLogin() {
        find(LOGIN_LOCATOR).sendKeys(login);
        find(PASSWORD_LOCATOR).sendKeys(password);
        clickOnElement(SIGN_IN_LOCATOR);
        return this;
    }
}
