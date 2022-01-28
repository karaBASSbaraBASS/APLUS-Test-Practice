package aplus.ui.pages;

import aplus.ui.base.BasePage;
import org.openqa.selenium.By;

public class CustomEmailLearnPage extends BasePage {
    private final By addEmailToCart = By.xpath("//button[contains(@aria-label,'add product')]");
    private final By addEmailHeader = By.xpath("//h1[@class='header-text']");
    private final By addEmailBusinessPlans = By.xpath("//section[contains(@class,'business-email-plans')]");
    private final By addEmailAllPlans = By.xpath("//section[contains(@class,'business-email-all-plans')]");
    private final By addEmailAdvantages = By.xpath("//section[contains(@class,'business-email-box')]");
    private final By addEmailMoreInfo = By.xpath("//section[contains(@class,'business-email-info')]");
    private final By addEmailTestimonials = By.xpath("//div[contains(@class,'comment-slider-wrap')]");

    public DailyDealsLearnPage CheckCustomEmailNecessaryFields() {
        verifyElementExistsAndVisible(addEmailToCart);
        verifyElementExistsAndVisible(addEmailHeader);
        verifyElementExistsAndVisible(addEmailBusinessPlans);
        verifyElementExistsAndVisible(addEmailAllPlans);
        verifyElementExistsAndVisible(addEmailAdvantages);
        verifyElementExistsAndVisible(addEmailMoreInfo);
        verifyElementExistsAndVisible(addEmailTestimonials);
        return new DailyDealsLearnPage();
    }
}
