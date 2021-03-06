package starter.page;

import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupPage extends DefaultPage {

    private By GROUPS_LOCATOR = By.xpath(".//div[contains(text(), 'Группы')]");
    private By JOIN_BUTTON = By.xpath(".//a[@class='button-pro group-join_btn __small __sec']");
    private By ALL_BUTTON = By.xpath(".//a[@class='portlet_h_ac al']");
    private By GROUP_NAME = By.xpath(".//a[@class='o two-lines']");
    private By BUTTON = By.xpath(".//span[@class='dropdown_ac button-pro __with-arrow __arrow-svg __sec __wide']");
    private By LEAVE_BUTTON = By.xpath(".//div[@class='dropdown_n']");
    String CHECK_LOCATOR = ".//a[@class='button-pro __wide']";

    public GroupPage goToGroups() {
        find(GROUPS_LOCATOR).click();
        return this;
    }

    public void joinGroup() {
        find(JOIN_BUTTON).click();
    }

    public GroupPage goToNewGroup() {
        find(ALL_BUTTON).click();
        find(GROUP_NAME).click();
        return this;
    }

    public void leaveGroup() {
        find(BUTTON).click();
        find(LEAVE_BUTTON).click();
    }

    public void checkJoin(WebDriver driver) {
        Assert.assertTrue("i am not in group", isElementHere(driver, CHECK_LOCATOR));
        System.out.println("Join in group successfully");
    }
    public void checkLeave(WebDriver driver) {
        Assert.assertFalse("I did not leave", isElementHere(driver, CHECK_LOCATOR));
        System.out.println("Leave from group successfully");
    }

}
