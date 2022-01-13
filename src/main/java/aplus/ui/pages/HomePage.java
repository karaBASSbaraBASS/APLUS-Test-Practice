package aplus.ui.pages;

import aplus.ui.base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final By header = By.xpath("//header");
    private final By promoBannerCTAButton = By.xpath("//div[@id='panel1']//a[text()='Get started']");
    private final By promoPanel = By.xpath("//div[@id='panel1']");
    private final By searchForADomainField = By.xpath("//div[@class='homepage-blue-box']//input[@id='enter_domain']");
    private final By DailyDealsLearnMore = By.xpath("//div[contains(@class,'awesome-daily-deals-wrap')]//a[contains(text(),'LEARN MORE')]");
    private final By DailyDealsBuyNow = By.xpath("//div[contains(@class,'awesome-daily-deals-wrap')]//a[contains(text(),'BUY NOW')]");


//                - “Create your own website” block with “Learn more” button
//                - “Custom email” block with “Learn more” button
//                - “Design” block with “Learn more” button
//                - “SiteLock Security” block with “Learn more” button
//                - Testimonials block with “Left arrow” and “Right arrow” buttons
//                - Footer
}
