package selenium.actions;

import models.User;
import org.openqa.selenium.support.ui.Select;
import selenium.pageObject.PageShopRegistration;

public final class Registration {

    public static void registration(PageShopRegistration page, User user) {

        page.waitUntilLoaded();
        page.getInputEmail().sendKeys(user.getEmail());
        page.getButtonCreateAnAccount().click();
        //input firstName, secondName, sex and password
        if(user.getSex().getSex().equals("Mr"))page.getRadioBauttonMr().click();
        if(user.getSex().getSex().equals("Mrs"))page.getRadioBauttonMrs().click();
        page.getFirstName().sendKeys(user.getFirstName());
        page.getSecondName().sendKeys(user.getSecondName());
        page.getPassword().sendKeys(user.getPassword());
        //input birthday's day
        Select sel = new Select(page.getDayOfBirthday());
        sel.selectByValue(user.getDay());
        sel = new Select(page.getMonthOfBirthday());
        sel.selectByValue(String.valueOf(user.getMonth().ordinal()+1));
        sel = new Select(page.getYearOfBirthday());
        sel.selectByValue(user.getYear());

        //click additional button for advertising
        page.getRadioBtnNews().click();
        page.getRadioBtnOptin().click();
        //other data
        page.getAddress().sendKeys(user.getAddress());
        page.getAdditionalAddress().sendKeys(user.getAdditionalAddress());
        page.getCity().sendKeys(user.getCity());
        sel = new Select(page.getState());
        sel.selectByValue(String.valueOf(user.getState().ordinal()+1));

        page.getPostalCod().sendKeys(user.getPostalCod());
        page.getAdditionalInformation().sendKeys(user.getAdditionalInformation());
        page.getHomePhone().sendKeys(user.getHomePhone());
        page.getMobllePhone().sendKeys(user.getMobilPhone());
        page.getAsignAddress().sendKeys(user.getCityOfLiving().getCity());
        page.getCompany().sendKeys(user.getCompany());
        page.getButtonRegister().click();

    }
}
