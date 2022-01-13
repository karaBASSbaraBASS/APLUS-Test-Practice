package smoke;

import aplus.ui.widgets.AdminMenu;
import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObservePagesTests extends BaseTest {

    @Test
    public void checkForMandatoryBlocksHomePage() {
        new AdminMenu().verifyNewDomainSearchFlow();
        //                - Header
//                - Promo banner with “Get started” button
//                - Promo panel
//                - “Search for a domain” field
//                - Daily Deals block with “Learn more” and “Buy now” buttons
//                - “Create your own website” block with “Learn more” button
//                - “Custom email” block with “Learn more” button
//                - “Design” block with “Learn more” button
//                - “SiteLock Security” block with “Learn more” button
//                - Testimonials block with “Left arrow” and “Right arrow” buttons
//                - Footer
    }
}
