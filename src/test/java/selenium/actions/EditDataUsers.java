package selenium.actions;

import models.User;
import selenium.pageObject.PagePersonalAddress;
import selenium.pageObject.PagePersonalInformation;

public class EditDataUsers {
    public void editPersonalInfo(PagePersonalInformation page, User user){
        FillPersonalData fillPersonalData = new FillPersonalData();
        fillPersonalData.editPersonalInformation(page, user);
    }
    public void editPersonalAddress(PagePersonalAddress page, User user){
        FillPersonalAddress fillPersonalAddress = new FillPersonalAddress();
        fillPersonalAddress.editPersonalAddress(page, user);
    }
}
