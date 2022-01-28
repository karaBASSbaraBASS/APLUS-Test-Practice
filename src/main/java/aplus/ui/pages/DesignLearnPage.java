package aplus.ui.pages;

import aplus.ui.base.BasePage;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

public class DesignLearnPage extends BasePage {
    private final By designLogoHeader = By.xpath("//div[contains(@class,'header-text')]");
    private final By designLogoDiscountAnimation = By.xpath("//img[@alt='animation number 20']");
    private final By designLogoDiscountButton = By.xpath("//a[@id='main-content']");
    private final By designLogoClientsSlider = By.xpath("//div[@class='slider-online-logo']");
    private final By designLogoAdvantages = By.xpath("//div[@class='logo-online-features']");


    public void checkDesignNecessaryFields() {
        verifyElementExistsAndVisible(designLogoHeader).shouldHave(Condition.text("Get your logo instantly for as little as"));
        verifyElementExistsAndVisible(designLogoDiscountAnimation);
        verifyElementExistsAndVisible(designLogoDiscountButton);
        verifyElementExistsAndVisible(designLogoClientsSlider);
        verifyElementExistsAndVisible(designLogoAdvantages);
    }
}
