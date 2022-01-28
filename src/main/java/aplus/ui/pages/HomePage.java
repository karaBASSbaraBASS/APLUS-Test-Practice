package aplus.ui.pages;

import aplus.ui.base.BasePage;
import aplus.ui.widgets.CarouselTests;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.Keys.*;


public class HomePage extends BasePage {

    private final By pageTitle = By.xpath("//title");
    private final By acceptCookiesButton = By.xpath("//button[@id='onetrust-accept-btn-handler']");

    private final By headerSection = By.xpath("//section[contains(@class, 'top-bar-section')]");
    private final By promoBannerCTAButton = By.xpath("//div[@id='panel1']//a[text()='Get started']");
    private final By promoPanel = By.xpath("//div[@id='panel1']");
    private final By searchForADomainField = By.xpath("//input[@id='enter_domain']");
    //AWESOME DAILY DEALS
    private final By dailyDealsLearnMore = By.xpath("//a[contains(@aria-label,'Learn more about daily deals')]");
    private final By dailyDealsBuyNow = By.xpath("//button[contains(@aria-label,'Buy now product with coupon')]");
    private final By dailyDealsLeftPart = By.xpath("//div[contains(@class,'awesome-daily-deals-left')]");
    private final By dailyDealsLeftPartTitle = By.xpath("//div[contains(@class,'awesome-daily-deals-left')]//ul/li/div");
    private final By dailyDealsCountdownTimer = By.xpath("//div[contains(@class,'dealsCountdownTimer')]");
    private final By awesomeDailyDealsText = By.cssSelector("[class='awesome-daily-deals-text']");
    //Create your own website
    private final By createWebsiteLearnMore = By.xpath("//a[contains(@aria-label,'Learn more about Website Creator Pro')]");
    private final By createWebsiteSlider = By.xpath("//div[contains(@class,'product-slider-wrap')]//div[@class='small-12 large-8 columns']");
    private final By createWebsiteSliderWrapper = By.xpath("//div[contains(@class,'product-slider-wrap')][1]//div[@class='owl-wrapper']");
    private final By createWebsiteSliderFirstDot = By.xpath("//div[contains(@class,'product-slider-wrap')][1]//div[@class='owl-page'][1]");
    private final By createWebsiteSliderActiveDot = By.xpath("//div[contains(@class,'product-slider-wrap')][1]//div[@class='owl-page active']");
    //Create custom email
    private final By customEmailLearnMore = By.xpath("//a[contains(@aria-label,'Learn more about Business Emails')]");
    private final By customEmailTitle = By.xpath("//*[contains(text(),'Custom email')]");

    private final By designLearnMore = By.xpath("//a[contains(@aria-label,'Learn more about Logo Design')]");
    private final By designLogoBannerImage = By.xpath("//img[@alt='The Brandname']");

    private final By siteLockSecurityLearnMore = By.xpath("//a[contains(@aria-label,'Learn more about SiteLock Security')]");
    private final By siteLockBannerImage = By.xpath("//img[@alt='Sitelock Logo']");

    private final By testimonialsLeftButton = By.xpath("//div[contains(@class,'owl-carousel')]//div[@class='left-arrow']");
    private final By testimonialsRightButton = By.xpath("//div[contains(@class,'owl-carousel')]//div[@class='right-arrow']");
    private final By footerSection = By.xpath("//div[@id='footer']");

    private final By promoPanelHostingButton = By.xpath("//a[contains(@aria-label,'Open Professional Cloud Hosting Slide')]");
    private final By promoPanelEmailButton = By.xpath("//a[contains(@aria-label,'Open Business Email slide')]");
    private final By promoPanelLogoButton = By.xpath("//a[contains(@aria-label,'Open Professional Logo slide')]");
    private final By promoPanelStoreButton = By.xpath("//a[contains(@aria-label,'Open Online Store slide')]");

    private final By promoPanelActiveTitleHeader = By.xpath("//div[contains(@class,'active')]//h2[@class='hero-tab-box-title']");
    private final By promoPanelHostingTitleHeader = By.xpath("//div[contains(@class,'prof-hosting')]//h2[@class='hero-tab-box-title']");
    private final By promoPanelEmailTitleHeader = By.xpath("//div[contains(@class,'business-email')]//h2[@class='hero-tab-box-title']");
    private final By promoPanelLogoTitleHeader = By.xpath("//div[contains(@class,'prof-logo')]//h2[@class='hero-tab-box-title']");
    private final By promoPanelStoreTitleHeader = By.xpath("//div[contains(@class,'online-store')]//h2[@class='hero-tab-box-title']");

    private final By searchForANewDomainErrorMessage = By.xpath("//div[contains(@class,'formErrorContent')]");

    private final By findDomainInputBlock = By.xpath("//div[contains(@class,'homepage-blue-box')]");
    private final By searchForANewDomainInput = By.xpath("//input[@id='enter_domain']");
    private final By searchForANewDomainSearchButton = By.xpath("//button[contains(@class,'button js_search_domain_find_btn')]");

    private final By addDomainToCartButton = By.xpath("//div[contains(@class,'is-available-domain')]//button[contains(@class,'add-dom-but')]");


    public void checkForMandatoryBlocksHomePage(){
        verifyElementExistsAndVisible(headerSection);
        verifyElementExistsAndVisible(promoBannerCTAButton);
        verifyElementExistsAndVisible(promoPanel);
        verifyElementExistsAndVisible(searchForADomainField);
        verifyElementExistsAndVisible(dailyDealsLearnMore);
        verifyElementExistsAndVisible(dailyDealsBuyNow);
        verifyElementExistsAndVisible(createWebsiteLearnMore);
        verifyElementExistsAndVisible(customEmailLearnMore);
        verifyElementExistsAndVisible(designLearnMore);
        verifyElementExistsAndVisible(siteLockSecurityLearnMore);
        verifyElementExistsAndVisible(testimonialsLeftButton);
        verifyElementExistsAndVisible(testimonialsRightButton);
        verifyElementExistsAndVisible(footerSection);
    }
    public HomePage clickEmailButtonAndCheckTitle(){
        verifyElementExistsAndVisible(promoPanelEmailButton).click();
        checkBannerText(promoPanelActiveTitleHeader, promoPanelEmailTitleHeader);
        return new HomePage();
    }
    public HomePage clickLogoButtonAndCheckTitle(){
        verifyElementExistsAndVisible(promoPanelLogoButton).click();
        checkBannerText(promoPanelActiveTitleHeader, promoPanelLogoTitleHeader);
        return new HomePage();
    }
    public HomePage clickStoreButtonAndCheckTitle(){
        verifyElementExistsAndVisible(promoPanelStoreButton).click();
        checkBannerText(promoPanelActiveTitleHeader, promoPanelStoreTitleHeader);
        return new HomePage();
    }
    public HomePage clickHostingButtonAndCheckTitle(){
        verifyElementExistsAndVisible(promoPanelHostingButton).click();
        checkBannerText(promoPanelActiveTitleHeader, promoPanelHostingTitleHeader);
        return new HomePage();
    }

    public HomePage checkTitlePage(String titleToCheck){
        $(pageTitle).shouldHave(Condition.text(titleToCheck));
        return new HomePage();
    }

    public HomePage checkDefaultBannerText(){
        checkBannerText(promoPanelActiveTitleHeader, promoPanelHostingTitleHeader);
        return new HomePage();
    }

    private HomePage checkBannerText(By activeBannerTitleLocator, By bannerTitleLocator){
        String bannerTitle = verifyElementExistsAndVisible(bannerTitleLocator).getText();
        verifyElementExistsAndVisible(activeBannerTitleLocator).shouldHave(Condition.text(bannerTitle));
        return new HomePage();
    }

    public HomePage checkErrorMessage(String errorMessage){
        verifyElementExistsAndVisible(searchForANewDomainErrorMessage).shouldHave(Condition.text(errorMessage));
        return new HomePage();
    }

    public HomePage clickSearchDomainButton(){
        verifyElementExistsAndVisible(searchForANewDomainSearchButton).click();
        return new HomePage();
    }

    public HomePage insertDomainName(String domainName){
        scrollToElement(findDomainInputBlock);
        $(searchForANewDomainInput).sendKeys(chord(CONTROL,"a"), BACK_SPACE); //valueOff;
        $(searchForANewDomainInput).sendKeys(domainName, ENTER);
        return new HomePage();
    }

    public DomainNameSearchPage addDomainToCart(){
        verifyElementExistsAndVisible(addDomainToCartButton).hover().click();
        return new DomainNameSearchPage();
    }

    /**
     * Verifies that the element exists and visible on the page.
     *
     * @param locator - page element locator.
     * @param offset - page distasnce above element in pixels.
     * scrollToElementByOffset(dailyDealsLearnMore, -200).click();
     */
    private WebElement scrollToElementByOffset(By locator, int offset) {
        WebElement element = WebDriverRunner.getWebDriver().findElement(locator);
        JavascriptExecutor jse = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        jse.executeScript("window.scrollTo(" + element.getLocation().getX() + "," + (element.getLocation().getY()
                + offset) + ");");
        return element;
    }

    public HomePage acceptCoockies(){
        $(acceptCookiesButton).click();
        return new HomePage();
    }

    private void discountExistingRegexChecker(String textToCheck) {
        String pattern = "(.*)(\\d%)(.*)";
        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);
        // Now create matcher object.
        Matcher m = r.matcher(textToCheck);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
        }else {
            System.out.println("NO MATCH");
        }
    }

    public DailyDealsLearnPage checkAndClickDailyDealsLearnMore(){
        //verify presence of the elements
        verifyElementExistsAndVisible(dailyDealsLeftPart);
        String dailyDealsTitle = verifyElementExistsAndVisible(dailyDealsLeftPartTitle).getText();
        discountExistingRegexChecker(dailyDealsTitle);
        verifyElementExistsAndVisible(dailyDealsCountdownTimer);
        verifyElementExistsAndVisible(awesomeDailyDealsText);
        verifyElementExistsAndVisible(dailyDealsLearnMore);
        verifyElementExistsAndVisible(dailyDealsBuyNow);
        //perform learnMore click
        verifyElementExistsAndVisible(dailyDealsLearnMore).hover().click();
        return new DailyDealsLearnPage();
    }
    public HomePage checkNecessaryBlocksInCreateWebsiteSection(){
        verifyElementExistsAndVisible(createWebsiteSlider);
        verifyElementExistsAndVisible(createWebsiteLearnMore);
        return new HomePage();
    }
    public CarouselTests createWebsiteCarouselTest(){
        String selectorToDotsElements = "//div[contains(@class,'product-slider-wrap')][1]//div[contains(@class,'owl-page')]";
        CarouselTests сarouselTests = new CarouselTests();
        сarouselTests.carouselShouldChangeSlideIfDotIsClicked(selectorToDotsElements);
        сarouselTests.carouselShouldChangeSlideInAutoMode(selectorToDotsElements, createWebsiteSliderActiveDot);
        return new CarouselTests();
    }
    public CustomEmailLearnPage checkAndClickCustomEmailLearnMore(){
        //verify presence of the elements
        verifyElementExistsAndVisible(customEmailTitle);
        //perform learnMore click
        verifyElementExistsAndVisible(customEmailLearnMore).hover().click();
        return new CustomEmailLearnPage();
    }


    public DesignLearnPage checkAndClickObserveDesignLearnMore() {
        //verify presence of the elements
        verifyElementExistsAndVisible(designLogoBannerImage);
        //perform learnMore click
        verifyElementExistsAndVisible(designLearnMore).hover().click();
        return new DesignLearnPage();
    }

    public SiteLockSecurityLearnPage checkAndClickObserveSiteLockSecurityLearnMore() {
        //verify presence of the elements
        verifyElementExistsAndVisible(siteLockBannerImage);
        //perform learnMore click
        verifyElementExistsAndVisible(siteLockSecurityLearnMore).hover().click();
        return new SiteLockSecurityLearnPage();
    }
}
