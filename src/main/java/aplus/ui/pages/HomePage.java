package aplus.ui.pages;

import aplus.ui.base.BasePage;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {
//    private WebDriver driver;
//    public HomePage(WebDriver driver){
//        this.driver = driver;
//    }

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

    private final By PromoPanelHostingButton = By.xpath("//a[contains(@aria-label,'Open Professional Cloud Hosting Slide')]");
    private final By PromoPanelEmailButton = By.xpath("//a[contains(@aria-label,'Open Business Email slide')]");
    private final By PromoPanelLogoButton = By.xpath("//a[contains(@aria-label,'Open Professional Logo slide')]");
    private final By PromoPanelStoreButton = By.xpath("//a[contains(@aria-label,'Open Online Store slide')]");

    private final By PromoPanelActiveTitleHeader = By.xpath("//div[contains(@class,'active')]//h2[@class='hero-tab-box-title']");
    private final By PromoPanelHostingTitleHeader = By.xpath("//div[contains(@class,'prof-hosting')]//h2[@class='hero-tab-box-title']");
    private final By PromoPanelEmailTitleHeader = By.xpath("//div[contains(@class,'business-email')]//h2[@class='hero-tab-box-title']");
    private final By PromoPanelLogoTitleHeader = By.xpath("//div[contains(@class,'prof-logo')]//h2[@class='hero-tab-box-title']");
    private final By PromoPanelStoreTitleHeader = By.xpath("//div[contains(@class,'online-store')]//h2[@class='hero-tab-box-title']");

    //div[contains(@class,'hosting-content-hptt')]  --- active
    //div[contains(@class,'active')]//h2[@class='hero-tab-box-title']


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
    public HomePage ClickEmailButtonAndCheckTitle(){
        verifyElementExistsAndVisible(PromoPanelEmailButton).click();
        checkBannerText(PromoPanelActiveTitleHeader, PromoPanelEmailTitleHeader);
        return new HomePage();
    }
    public HomePage ClickLogoButtonAndCheckTitle(){
        verifyElementExistsAndVisible(PromoPanelLogoButton).click();
        checkBannerText(PromoPanelActiveTitleHeader, PromoPanelLogoTitleHeader);
        return new HomePage();
    }
    public HomePage ClickStoreButtonAndCheckTitle(){
        verifyElementExistsAndVisible(PromoPanelStoreButton).click();
        checkBannerText(PromoPanelActiveTitleHeader, PromoPanelStoreTitleHeader);
        return new HomePage();
    }
    public HomePage ClickHostingButtonAndCheckTitle(){
        verifyElementExistsAndVisible(PromoPanelHostingButton).click();
        checkBannerText(PromoPanelActiveTitleHeader, PromoPanelHostingTitleHeader);
        return new HomePage();
    }

    public HomePage checkDefaultBannerText(){
        checkBannerText(PromoPanelActiveTitleHeader, PromoPanelHostingTitleHeader);
        return new HomePage();
    }

    private HomePage checkBannerText(By activeBannerTitleLocator, By bannerTitleLocator){
        String bannerTitle = verifyElementExistsAndVisible(bannerTitleLocator).getText();
        verifyElementExistsAndVisible(activeBannerTitleLocator).shouldHave(Condition.text(bannerTitle));
        return new HomePage();
    }
}
