package aplus.ui.pages;

import aplus.ui.base.BasePage;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

public class SiteLockSecurityLearnPage  extends BasePage {
    private final By siteLockSecurityHeaderText = By.xpath("//div[@class='header-text']");
    private final By siteLockSecurityAddToCartButton = By.xpath("//button[@aria-label='add product']");
    public void checkSiteLockSecurityNecessaryFields() {
        verifyElementExistsAndVisible(siteLockSecurityHeaderText);
        verifyElementExistsAndVisible(siteLockSecurityAddToCartButton);
    }
}
