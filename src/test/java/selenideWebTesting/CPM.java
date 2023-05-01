package selenideWebTesting;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import selenideWebTesting.stepObjects.digitalServicesPageSteps.DigitalServicesPageSteps;
import selenideWebTesting.stepObjects.digitalServicesPageSteps.RoleSteps;
import selenideWebTesting.utils.ConfigAndLoginSteps;

public class CPM extends ConfigAndLoginSteps {

    DigitalServicesPageSteps digitalServicesPageSteps = new DigitalServicesPageSteps();
    RoleSteps roleSteps = new RoleSteps();

    @Test(description = "[WPL-T7272]", priority = 1)
    @Story("Role page -> Visual")
    @Description("On this page there should be following tabs:\n" +
            "\n" +
            "Role\n" +
            "Confirmation group\n" +
            "Status\n" +
            "Other actions\n" +
            "Also here should be next available button:\n" +
            "\"+ Add a role\"")
    public void visualOfRolePageTabs() {

        digitalServicesPageSteps
                .clickOnRolesHeader()
                .checkHeadersOnMainServicesTab();

    }

//    @Test(description = "[WPL-T7278]", priority = 2)
//    @Story("Role Page -> Other Actions tab -> Pressing \"Three dots\" -> Choosing \"Delete\" Option")
//    @Description("if user presses on the \"წაშლა\" button, the selected role will be deleted")
//    public void deleteRole() {
//
//        digitalServicesPageSteps
//                .clickOnMainHeader();
//        roleSteps
//                .clickOnDeleteRoleButtonAndCheckIfDeleted();
//
//    }

    @Test(description = "[WPL-T7314]", priority = 3)
    @Story("Role Page -> Pop-up -> Limits -> Visual")
    @Description("""
            Limits tab contains following information's:
            ოპერაციები
            ლიმიტები
            პერიოდი""")
    public void checkLimitsHeaders() {

        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .clickOnFirstViewRoleEyeButton()
                .clickOnLimitsHeader()
                .checkLimitsHeaders();

    }

    @Test(description = "[WPL-T7276]", priority = 4)
    @Story("Role Page -> Status tab -> Visual")
    @Description("""
            Context of status tab has following options:
                   აქტიური
                   დდასაავტორიზებელი
                   """)
    public void checkRoleStatus() {

        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .checkRoleStatus();

    }

    @Test(description = "[WPL-T7319]", priority = 5)
    @Story("Role Page -> Pop-up -> Limits -> Period")
    @Description("""
            right next to operations, there is little arrow "v" pointing downwards, if user clicks it following options will show up:
                   ერთჯერადი
                   ერთი კვირა
                   ერთი თვე
                   ერთი წელი
                   უსასრულოდ""")
    public void checkLimitsPeriodValues() {

        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .clickOnFirstViewRoleEyeButton()
                .clickOnLimitsHeader()
                .clickOnPeriodSelect()
                .checkLimitsPeriodValues();

    }

    @Test(description = "[WPL-T7975]", priority = 6)
    @Story("Digital Services tab -> Visual ")
    @Description("""
            If user has selected - მომხარებელი:
                                  Under this tab should be next available options:
                                  მომხმარებელი
                                  როლები
                                  ხელმოწერები
                                  მომხარებლის დამატება
                                  ცვლილებები""")
    public void checkHeadersWhenUserHasSelected_customers() {

        digitalServicesPageSteps
                .clickOnUsersHeader()
                .checkHeadersWhenUserHasSelected_customers();

    }

    @Test(description = "[WPL-T8052]", priority = 7)
    @Story("Digital Services tab -> Visual ")
    @Description("""
            If user has selected - როლები:
                                  Under this tab should be next available options:
                                  მომხმარებელი
                                  როლები
                                  ხელმოწერები
                                  როლის დამატება
                                  ცვლილებები""")
    public void checkHeadersWhenUserHasSelected_roles() {

        digitalServicesPageSteps
                .clickOnRolesHeader()
                .checkHeadersWhenUserHasSelected_roles();

    }

}
