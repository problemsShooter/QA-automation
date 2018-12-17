package selenium.actions;

import models.User;
import selenium.pageObject.PagePersonalAddress;
import selenium.pageObject.PagePersonalInformation;

public class EditDataUsers {
    public static void editPersonalInfo(PagePersonalInformation page, User user){
        FillPersonalData.editPersonalInformation(page, user);
    }
    public static void editPersonalAddress(PagePersonalAddress page, User user){
        FillPersonalAddress.editPersonalAddress(page, user);
    }
}
