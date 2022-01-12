package aplus.ui.widgets;

import aplus.ui.Variables;
import aplus.ui.base.BasePage;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.openqa.selenium.Keys.ENTER;

public class AdminMenu extends BasePage {

    private final By headerLogo = By.cssSelector("[class='header-logo-desktop']");
    private final By mainMenuBlock = By.id("main-menu");
    private final By loginButton = By.cssSelector("[class='button hollow info uppercase']");

    private final By domainDropdownButton = By.cssSelector("[id='main-menu'] > ul > li:nth-child(1)");
    private final By domainSearchLink = By.cssSelector("[id='main-menu'] > ul > li:nth-child(1) > ul > li:nth-child(3) > a");
    private final By domainNameRegistrationPageTitle = By.cssSelector("h1[class='sr-only']");
    private final By enterDomainInput = By.cssSelector("[id='enter_domain']");
    private final By domainIsNotAvailableResult = By.cssSelector("[class='is-not-available text-center']");
    private final By loginModalWindow = By.cssSelector("[class='reveal-modal large modal-login-popup open']");
    private final By domainNameInput = By.cssSelector("[id='id_login_username']");
    private final By passwordInput = By.cssSelector("[id='id_login_password']");
    private final By signInButton = By.cssSelector("[class='button small js_login_button']");
    private final By controlPanelMainContent = By.cssSelector("[id='homeMainContent']");

    public AdminMenu verifyAdminMenuContentIsDisplayed() {
        verifyElementExistsAndVisible(headerLogo);
        verifyElementExistsAndVisible(mainMenuBlock);
        verifyElementExistsAndVisible(loginButton).shouldHave(Condition.text("Login"));
        return new AdminMenu();
    }

    public AdminMenu verifyNewDomainSearchFlow() {
        verifyElementExistsAndVisible(mainMenuBlock);
        verifyElementExistsAndVisible(domainDropdownButton).hover();
        verifyElementExistsAndVisible(domainSearchLink).hover().click();
        verifyElementExistsAndVisible(domainNameRegistrationPageTitle).shouldHave(Condition.text("Domain Name Registration"));
        verifyElementExistsAndVisible(enterDomainInput);
        $(enterDomainInput).sendKeys("abc.com", ENTER);
        verifyElementExistsAndVisible(domainIsNotAvailableResult).shouldHave(Condition.text("Sorry, "));
        verifyElementExistsAndVisible(headerLogo).click();
        return new AdminMenu();
    }

    public AdminMenu verifyLoginIsSuccessful() {
        verifyElementExistsAndVisible(loginButton).hover().click();
        verifyElementExistsAndVisible(loginModalWindow);
        $(domainNameInput).sendKeys(Variables.domainName, ENTER);
        $(passwordInput).sendKeys(Variables.password);
        verifyElementExistsAndVisible(signInButton).hover().click();
        switchTo().window(1);
        verifyElementExistsAndVisible(controlPanelMainContent);
        return new AdminMenu();
    }
}