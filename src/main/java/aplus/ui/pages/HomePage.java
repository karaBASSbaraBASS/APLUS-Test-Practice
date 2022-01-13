package aplus.ui.pages;

import aplus.ui.base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final By headerSection = By.xpath("//section[contains(@class, 'top-bar-section')]");
    private final By promoBannerCTAButton = By.xpath("//div[@id='panel1']//a[text()='Get started']");
    private final By promoPanel = By.xpath("//div[@id='panel1']");
    private final By searchForADomainField = By.xpath("//input[@id='enter_domain']");
    private final By DailyDealsLearnMore = By.xpath("//a[contains(@aria-label,'Learn more about daily deals')]");
    private final By DailyDealsBuyNow = By.xpath("//button[contains(@aria-label,'Buy now product with coupon')]");
    private final By CreateWebsiteLearnMore = By.xpath("//a[contains(@aria-label,'Learn more about Website Creator Pro')]");
    private final By CustomEmailLearnMore = By.xpath("//a[contains(@aria-label,'Learn more about Business Emails')]");
    private final By DesignLearnMore = By.xpath("//a[contains(@aria-label,'Learn more about Logo Design')]");
    private final By SiteLockSecurityLearnMore = By.xpath("//a[contains(@aria-label,'Learn more about SiteLock Security')]");
    private final By TestimonialsLeftButton = By.xpath("//div[contains(@class,'owl-carousel')]//div[@class='left-arrow']");
    private final By TestimonialsRightButton = By.xpath("//div[contains(@class,'owl-carousel')]//div[@class='right-arrow']");
    private final By footerSection = By.xpath("//div[@id='footer']");

    public HomePage checkForMandatoryBlocksHomePage(){
        verifyElementExistsAndVisible(headerSection);
        verifyElementExistsAndVisible(promoBannerCTAButton);
        verifyElementExistsAndVisible(promoPanel);
        verifyElementExistsAndVisible(searchForADomainField);
        verifyElementExistsAndVisible(DailyDealsLearnMore);
        verifyElementExistsAndVisible(DailyDealsBuyNow);
        verifyElementExistsAndVisible(CreateWebsiteLearnMore);
        verifyElementExistsAndVisible(CustomEmailLearnMore);
        verifyElementExistsAndVisible(DesignLearnMore);
        verifyElementExistsAndVisible(SiteLockSecurityLearnMore);
        verifyElementExistsAndVisible(TestimonialsLeftButton);
        verifyElementExistsAndVisible(TestimonialsRightButton);
        verifyElementExistsAndVisible(footerSection);
        return new HomePage();
    }
}
