package smoke;

import aplus.ui.pages.*;
import base.BaseTest;
import org.junit.jupiter.api.Test;

public class ObservePagesTests extends BaseTest {

    //TODO
    // главное меню доменов, создать коллекцию в класе странички,
    // создать чекМейнМеньюДробдаунЕлементс
    // в нем вызываем елементс колекшн - проверить:
    // 1) что отображается дробдоун
    // 2) при ховере появляется выпадающий список со всеми заголовками
    //TODO
    // как быть с требя сайтами? В плане у нас есть в тестовом плане тестирвоание трех сайтов с разным функционалом
    // и главная у каждой странички своя, правильно ли писать эти все тесты в одном проекте?
    //TODO
    //    @Test
    //    public void checkPageOpened() {
    //        new HomePage()
    //                .checkTitlePage("Aplus.net: Web Hosting &amp; Domain Name Registration Services");
    //    }
    //Test3 from HomePage.xls
    @Test
    public void observeHomePage() {
        new HomePage().checkForMandatoryBlocksHomePage();
    }
    //Test4 from HomePage.xls
    @Test
    public void observePromoPanel(){
        new HomePage()
                .checkDefaultBannerText()
                .clickEmailButtonAndCheckTitle()
                .clickLogoButtonAndCheckTitle()
                .clickStoreButtonAndCheckTitle()
                .clickHostingButtonAndCheckTitle();
    }
    //Test5 from HomePage.xls
    @Test
    public void testSearchForANewDomainErrorMessages(){
        new HomePage()
                .clickSearchDomainButton()
                .checkErrorMessage("Please enter domain name")
                .insertDomainName("t")
                .checkErrorMessage("2 minimum characters are required")
                .insertDomainName("LoremiipsumddolorssitaametccconsecteturaadipiscingeelitssSediinn")
                .checkErrorMessage("63 maximum characters are required")
                .insertDomainName(": !@")
                .checkErrorMessage("Special characters are not allowed")
                .insertDomainName("TestersGonnaTest.ua")
                .checkErrorMessage("Wrong TLD Extension")
                .insertDomainName("TestersGonnaTest.ru")
                .checkErrorMessage("Wrong TLD Extension");
    }
    //Test6 from HomePage.xls
    @Test
    public void testRedirectionToAdditionalDomainExtensions(){
        new HomePage()
                .acceptCoockies()
                .insertDomainName("qatest-ym-011090.com")
                .clickSearchDomainButton()
                .addDomainToCart()
                .checkResultText("qatest-ym-011090.com");
    }
    //Test7 from HomePage.xls
    //TODO
    // какие библиотеки используются для проверки на тайпо?
    // какие билиотеки используются на проверку битых картинок?
    @Test
    public void testObserveDailyDealsAndClickLearnMoreButton() {
        new HomePage()
                .acceptCoockies()
                .checkAndClickDailyDealsLearnMore()
                .CheckDailyDealsBlockVisible();
    }
    //Test8 from HomePage.xls
    @Test
    public void testObserveCreateWebsiteAndCheckCarousel() {
        new HomePage()
                .acceptCoockies()
                .checkNecessaryBlocksInCreateWebsiteSection()
                .createWebsiteCarouselTest();
    }
    //Test9 from HomePage.xls
    @Test
    public void testObserveCustomEmailAndClickLearnMoreButton() {
        new HomePage()
                .acceptCoockies()
                .checkAndClickCustomEmailLearnMore()
                .CheckCustomEmailNecessaryFields();
    }
    //Test10 from HomePage.xls
    @Test
    public void testObserveDesignAndClickLearnMoreButton() {
        new HomePage()
                .acceptCoockies()
                .checkAndClickObserveDesignLearnMore()
                .checkDesignNecessaryFields();
    }
    //Test11 from HomePage.xls
    @Test
    public void testObserveSiteLockSecurityAndClickLearnMoreButton() {
        new HomePage()
                .acceptCoockies()
                .checkAndClickObserveSiteLockSecurityLearnMore()
                .checkSiteLockSecurityNecessaryFields();
    }
    //Test12 from HomePage.xls
    @Test
    public void observeTestimonialsCarousel() {
        new HomePage()
                .acceptCoockies()
                .checkNecessaryBlocksInTestimonialsSection()
                .testimonialsCarouselTest();
    }
    //Test3 from Domains page testing.xlsx
    @Test
    public void observeDomainSearchPage() {
        new HomePage()
                .navigateToDomainSearch()
                .checkNecessarySections();
    }
}
