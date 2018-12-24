package selenium.actions;

import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Select;
import selenium.pageObject.PageShopRegistration;

public final class Registration {

    public void registration(PageShopRegistration page, User user) {
        FillPersonalData fillPersonalData = new FillPersonalData();
        FillPersonalAddress fillPersonalAddress = new FillPersonalAddress();
        fillPersonalData.fillPersonalData(page,user);
        fillPersonalAddress.fillPersonalAddress(page,user);
        page.getButtonRegister().click();

    }

    public Registration() {
    }
}
