package selenium.actions;

import selenium.pageObject.PageShopRegistration;

public class ClearPersonalData {
    public static void clearPersonalData(PageShopRegistration page){
        page.getPersonInfo().getFirstName().clear();
        page.getPersonInfo().getSecondName().clear();
        page.getPersonInfo().getInputEmail().clear();
        page.getPersonInfo().getPassword().clear();
        page.getPersonalAddress().getAddress().clear();

        page.getPersonalAddress().getAdditionalAddress().clear();
        page.getPersonalAddress().getCompany().clear();
        page.getPersonalAddress().getCity().clear();
        page.getPersonalAddress().getPostalCod().clear();
        page.getPersonalAddress().getAdditionalInformation().clear();
        page.getPersonalAddress().getHomePhone().clear();
        page.getPersonalAddress().getMobilePhone().clear();
        page.getPersonalAddress().getAsignAddress().clear();
    }
}
