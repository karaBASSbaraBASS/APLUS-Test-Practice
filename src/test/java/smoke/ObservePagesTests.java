package smoke;

import aplus.ui.pages.HomePage;
import aplus.ui.widgets.AdminMenu;
import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObservePagesTests extends BaseTest {

    @Test
    public void observeHomePage() {
        new HomePage().checkForMandatoryBlocksHomePage();
    }

    @Test
    public void observePromoPanel(){
        new HomePage().checkDefaultBannerText();

        new HomePage().ClickEmailButtonAndCheckTitle();
        new HomePage().ClickLogoButtonAndCheckTitle();
        new HomePage().ClickStoreButtonAndCheckTitle();
        new HomePage().ClickHostingButtonAndCheckTitle();
    }


}
