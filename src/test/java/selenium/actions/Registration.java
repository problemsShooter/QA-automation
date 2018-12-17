package selenium.actions;

import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
import selenium.pageObject.PageShopRegistration;

public final class Registration {

    public static void registration(PageShopRegistration page, User user) {

        FillPersonalData.fillPersonalData(page,user);
        FillPersonalAddress.fillPersonalAddress(page,user);

    }
}
