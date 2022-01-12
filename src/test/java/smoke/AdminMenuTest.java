package smoke;

import aplus.ui.widgets.AdminMenu;
import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdminMenuTest extends BaseTest {

    @BeforeEach
    public void checkMainMenuPresence() {
        new AdminMenu().verifyAdminMenuContentIsDisplayed();
    }

    @Test
    public void checkDomainSearchFlow() {
        new AdminMenu().verifyNewDomainSearchFlow();
    }

    @Test
    public void checkLoginToWebsiteFlow() {
        new AdminMenu().verifyLoginIsSuccessful();
    }
}
