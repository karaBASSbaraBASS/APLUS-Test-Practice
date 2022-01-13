package smoke;

import aplus.ui.pages.HomePage;
import aplus.ui.widgets.AdminMenu;
import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObservePagesTests extends BaseTest {

    @Test
    public void checkForMandatoryBlocksHomePage() {
        new HomePage().checkForMandatoryBlocksHomePage();
    }
}
