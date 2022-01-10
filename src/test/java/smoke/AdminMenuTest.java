package smoke;

import aplus.ui.widgets.AdminMenu;
import base.BaseTest;
import org.junit.jupiter.api.Test;

public class AdminMenuTest extends BaseTest {

    @Test
    public void checkMainMenuPresence(){
        new AdminMenu()
                .verifyAdminMenuContentIsDisplayed();
    }
}
