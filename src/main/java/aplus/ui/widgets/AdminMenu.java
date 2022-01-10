package aplus.ui.widgets;

import aplus.ui.base.BasePage;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

public class AdminMenu extends BasePage {

    private final By headerLogo = By.cssSelector("[class='header-logo-desktop']");
    private final By mainMenuBlock = By.id("main-menu");
    private final By loginButton = By.cssSelector("[class='button hollow info uppercase']");
    private final By getStartedBanner = By.cssSelector("[class='small-12 columns small-text-center medium-text-left']");
    private final By getStartedButton = By.cssSelector("[class='button secondary large js-ga-click-event']");

    public AdminMenu verifyAdminMenuContentIsDisplayed() {
        verifyElementExistsAndVisible(headerLogo);
        verifyElementExistsAndVisible(mainMenuBlock);
        verifyElementExistsAndVisible(loginButton).shouldHave(Condition.text("Login"));
        verifyElementExistsAndVisible(getStartedBanner);
        verifyElementExistsAndVisible(getStartedButton).shouldHave(Condition.text("Get started"));
        return new AdminMenu();
    }
}
