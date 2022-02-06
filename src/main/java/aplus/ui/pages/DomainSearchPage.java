package aplus.ui.pages;

import aplus.ui.base.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DomainSearchPage extends BasePage {
    private final By headerSection = By.xpath("//section[contains(@class,'top-bar-section')]");
    private final By mainBanner = By.xpath("//div[@class='select-new-domain-wrap']//h2[@class='text-center']");
    private final By enterDomain = By.xpath("//div[contains(@class,'quicktabs_main')]//input[@placeholder='Enter the domain you want here (example.com)']");
    private final By allDomainIncludeBlock = By.xpath("//div[@class='all-domains-include']");
    private final By searchDomainSwitcher = By.xpath("//a[@id='quicktabs-tab-domain_page_search_transfer-0']");
    private final By transferDomainSwitcher = By.xpath("//a[@id='quicktabs-tab-domain_page_search_transfer-1']");

    private final By seeDomainPricingChartLink = By.xpath("//strong[text()='See Domain Pricing Chart'][@id='main-content']/parent::a");
    private final By seeDomainFooterSection = By.xpath("//div[@id='footer']");
    private final By seeDomainTestimonialsSection = By.xpath("//div[@class='comment-slider-wrap']");

    private final By seeDomainDomainGuardLearnMore = By.xpath("//div[@class='three-ways-to-protect']//h3[text()='Domain guard']/following-sibling::a");
    private final By seeDomainDomainPrivacyLearnMore = By.xpath("//div[@class='three-ways-to-protect']//h3[text()='Domain privacy']/following-sibling::a");
    private final By seeDomainDomainMonitorLearnMore = By.xpath("//div[@class='three-ways-to-protect']//h3[text()='Domain monitor']/following-sibling::a");

    private final By seeDomainExampleDomainsSearch = By.xpath("//div[@class='ck-widget-search-again']//input[@placeholder='Search for a domain']");
    private final By seeDomainExampleDomainsSearchButton = By.xpath("//div[@class='ck-widget-search-again']//button[@class='button js_search_domain_find_btn']");
    private final By seeDomainExampleDomainsSection = By.xpath("//div[@class='ck-widget-search-again']//div[contains(@class,'example-domain')]");
    private final By seeDomainExampleDomainsLearnMore = By.xpath("//div[@class='ck-widget-search-again']//a[contains(@class,'learn-more-link')]");


    public DomainNameSearchPage checkNecessarySections(){
        checkCurentURL();
        verifyElementExistsAndVisible(headerSection);
        verifyElementExistsAndVisible(mainBanner);
        verifyElementExistsAndVisible(enterDomain);
        //Search field with “Enter the domain you want here (example.com)” inline text and magnifying glass search button;
        String enterDomainText = verifyElementExistsAndVisible(enterDomain).getAttribute("placeholder");
        String expectedEnterDomainText = "Enter the domain you want here (example.com)";
        assertEquals(enterDomainText, expectedEnterDomainText);
        //Check “Search for a new domain” and “Transfer a domain you own” search options;
        String searchDomainSwitcherText = verifyElementExistsAndVisible(searchDomainSwitcher).getText();
        String expectedSearchDomainSwitcherText = "Search for a new domain";
        assertEquals(searchDomainSwitcherText, expectedSearchDomainSwitcherText);

        String transferDomainSwitcherText = verifyElementExistsAndVisible(transferDomainSwitcher).getText();;
        String expectedTransferDomainSwitcherText = "Transfer a domain you own";
        assertEquals(transferDomainSwitcherText, expectedTransferDomainSwitcherText);
        //Check “See domain pricing chart” link;
        verifyElementExistsAndVisible(seeDomainPricingChartLink);
        //“All domains include” info block;
        //“All domains include” info block;
        verifyElementExistsAndVisible(allDomainIncludeBlock);
        //“3 ways to protect your domains” block with Domain Guard, Domain Privacy, Domain Monitor “Learn More” buttons.
        verifyElementExistsAndVisible(seeDomainDomainGuardLearnMore);
        verifyElementExistsAndVisible(seeDomainDomainPrivacyLearnMore);
        verifyElementExistsAndVisible(seeDomainDomainMonitorLearnMore);
        //“www.mydomain.club” block with info text, search field with “Search for a domain” inline text and magnifying glass search button, “Learn More” button;
        verifyElementExistsAndVisible(seeDomainExampleDomainsSearch);
        verifyElementExistsAndVisible(seeDomainExampleDomainsSearchButton);
        verifyElementExistsAndVisible(seeDomainExampleDomainsSection);
        verifyElementExistsAndVisible(seeDomainExampleDomainsLearnMore);
        //Testimonials block;
        verifyElementExistsAndVisible(seeDomainTestimonialsSection);
        //Footer;
        verifyElementExistsAndVisible(seeDomainFooterSection);


        return new DomainNameSearchPage();
    }
    private DomainNameSearchPage checkCurentURL(){
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        String expectedUrl = "https://preview-aplus-website.c45stagehostopia.com/domains";

        assertEquals(expectedUrl, currentUrl);
        return new DomainNameSearchPage();
    }

}
