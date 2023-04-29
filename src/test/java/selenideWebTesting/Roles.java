package selenideWebTesting;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import selenideWebTesting.stepObjects.digitalServicesPageSteps.DigitalServicesPageSteps;
import selenideWebTesting.stepObjects.digitalServicesPageSteps.RoleSteps;
import selenideWebTesting.utils.ConfigAndLoginSteps;
import selenideWebTesting.utils.Helper;

import java.util.Random;

import static org.apache.commons.lang3.RandomUtils.nextInt;

public class Roles extends ConfigAndLoginSteps {

    DigitalServicesPageSteps digitalServicesPageSteps = new DigitalServicesPageSteps();
    RoleSteps roleSteps = new RoleSteps();
    Helper helper = new Helper();
    ConfigAndLoginSteps configAndLoginSteps = new ConfigAndLoginSteps();

    @Test(description = "[WPL-T7980]")
    @Story("Role Page -> Bottom of the page -> Visual")
    @Description("""
            on the bottom of the page are available options:
                                  "Number" with arrow pointing down "v" from where u can select how many items u want to see on the page
                                  1-"n" of "n" items (this indicates how many items are available on the page
                                  1 of "n" pages (this indicates on which page u are at the moment out of "n" pages) also there is pointing down arrow "v" from where u can choose a specific page
                                  left and right button which allows u to move between pages""")
    public void checkElementsOnBottomOfThePage() {

        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .checkElementsOnBottomOfThePage();

    }

    @Test(description = "[WPL-T7277]")
    @Story("Role Page -> Actions tab -> Visual")
    @Description("This tab has only one option at this step, which is \"Three dots\". when hovering on this button checking that - 'ნახვა', 'შეცვლა', 'წაშლა' options are visible")
    public void checkActionsOnRolesButton() {

        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .hoverOnThreeDotsOnFirstRole()
                .checkActionsOnRolesButton();

    }

    @Test(description = "[WPL-T7279]")
    @Story("Role Page -> Actions tab -> Pressing \"Three dots\" -> Edit -> Actions tab -> Available Buttons")
    @Description("""
            On this page there are next available buttons:
                            ყველა ქმედების ჩართვა
                            უკან
                            შემდეგ""")
    public void checkEditRolePage_availablebuttons() {

        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .hoverOnThreeDotsOnFirstRole()
                .clickOnEditRole()
                .checkButtonsOnViewOrEditRolesPage();

    }

    @Test(description = "[WPL-T7291]")
    @Story("Role Page -> Actions tab -> Pressing \"Three dots\" -> Choosing \"View\" Option")
    @Description("If user presses \"ნახვა\" button, User will be redirected to the new page, from there user can view the role but doesn't have permission to make any change")
    public void checkIfUserIsNavigatedToRolePageAfterClickingViewRoleButton() {

        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .hoverOnThreeDotsOnFirstRole()
                .clickOnViewRole()
                .checkButtonsOnViewOrEditRolesPage()
                .checkThatEditIsNotPossibleWhileViewing();

    }

    @Test(description = "[WPL-T8049]")
    @Story("Role Page -> Actions tab -> Pressing \"Three dots\" -> Edit -> Actions tab -> Choosing a role \"აირჩიე როლის შაბლონი\" When user is Corporate")
    @Description("""
            ჩამოსაშლელი ველია სადაც უნდა ავირჩიოთ სამი შესაძლო ვარიანტიდან:
            Corporate Director
            Corporate Active
            Corporate Passive""")
    public void userManagementDropdownAvailableOptionsWhenUserIsCorporate() {

        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .hoverOnThreeDotsOnFirstRole()
                .clickOnEditRole()
                .clickOnUserManagementDrowdown()
                .checkUserManagementDropdownOptionsForCorporateUser();

    }

    @Test(description = "[WPL-T8247]")
    @Story("Role Page -> Actions tab -> Pressing \"Three dots\" -> Edit -> Actions tab -> Choosing a role \"აირჩიე როლის შაბლონი\" When user is Retail")
    @Description("""
            ჩამოსაშლელი ველია სადაც უნდა ავირჩიოთ სამი შესაძლო ვარიანტიდან:
            Retail Active
            Retail Passive
            Retail Digital Onboarding""")
    public void userManagementDropdownAvailableOptionsWhenUserIsRetail() {

        configAndLoginSteps
                .beforeStepForRetailUsers("6449887");
        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .hoverOnThreeDotsOnFirstRole()
                .clickOnEditRole()
                .clickOnUserManagementDrowdown()
                .checkUserManagementDropdownOptionsForRetailUser();

    }

    @Test(description = "[WPL-T7981]")
    @Story("Role Page -> Actions tab -> Pressing \"Three dots\" -> Edit -> Actions tab -> Actions -> Choosing an action and options")
    @Description("""
            We can choose an action and tick any options we want to have user in this group, for example:
                                  "ჯგუფურ გადახდებში" მოვნიშნოთ "ყველა" ოფცია, რის შემდეგაც ყველა არსებული ოფცია უნდა აირჩეს""")
    public void checkOnActionsAllOptions() {

        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .hoverOnThreeDotsOnFirstRole()
                .clickOnEditRole()
                .checkIfActionsAllOptionsIsSelected();

    }

    @Test(description = "[WPL-T7981]")
    @Story("Role Page -> Actions tab -> Pressing \"Three dots\" -> Edit -> Actions tab -> Actions -> Choosing an action and options")
    @Description("""
            We can choose an action and tick any options we want to have user in this group, for example:
                                  "ჯგუფურ გადახდებში" მოვნიშნოთ "ყველა" ოფცია, რის შემდეგაც ყველა არსებული ოფცია უნდა აირჩეს""")
    public void editRoleName() {

        String newRoleName = helper.getRandomString();

        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .hoverOnThreeDotsOnFirstRole()
                .clickOnEditRole();
        roleSteps
                .editRoleName(newRoleName)
                .clickOnNextButton()
                .clickOnNextButton()
                .checkSuccessTextAfterChange()
//                .clickOnBackToRolesButton()
                .checkEditedRoleName(newRoleName);

    }

    @Test(description = "[WPL-T7981]")
    @Story("Role Page -> Actions tab -> Pressing \"Three dots\" -> Edit -> Actions tab -> Naming a role -> Mandatory tab")
    @Description("This tab is mandatory to be filled in")
    public void emptyRoleName() {

        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .hoverOnThreeDotsOnFirstRole()
                .clickOnEditRole();
        roleSteps
                .clearRoleName()
                .clickOnNextButton()
                .clickOnNextButton()
                .checkUnSuccessTextAfterChange();

    }

    @Test(description = "[WPL-T7984]")
    @Story("Role Page -> Actions tab -> Pressing \"Three dots\" -> Edit -> Actions tab -> Pressing \"ყველა ქმედების ჩართვა\"")
    @Description("""
            If user presses "ყველა ქმედების ჩართვა" then, in every Actions all of the tickable options will be selected.""")
    public void selectAllActions() {


        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .hoverOnThreeDotsOnFirstRole()
                .clickOnEditRole()
                .clickOnSelectAllActions()
                .checkIfAllActionsAreSelected();

    }

    @Test(description = "[WPL-T7988]")
    @Story("Role Page -> Actions tab -> Pressing \"Three dots\" -> Edit -> Actions tab -> Pressing 'შემდეგ\" Button")
    @Description("If we press 'შემდეგ' button, we will be redirected to the next page, which is Limits tab")
    public void checkNextButtonFunctionality() {

        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .hoverOnThreeDotsOnFirstRole()
                .clickOnEditRole()
                .clickOnNextButton()
                .checkIfUserNavigatedToRoleLimitsPage();

    }

    @Test(description = "[WPL-T7987]")
    @Story("Role Page -> Actions tab -> Pressing \"Three dots\" -> Edit -> Actions tab -> Pressing 'უკან' Button")
    @Description("If we press 'უკან' button, we will be redirected to the previous page")
    public void checkBackButtonFunctionality() {

        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .hoverOnThreeDotsOnFirstRole()
                .clickOnEditRole()
                .clickOnNextButton()
                .clickOnBackButton()
                .checkButtonsOnViewOrEditRolesPage();

    }

    @Test(description = "[WPL-T7992]")
    @Story("Role Page -> Actions tab -> Pressing \"Three dots\" -> Edit -> Limits tab -> Limits Identification")
    @Description("უნდა იყოს შემდეგი შეტყობინება: \"განხორციელებული ცვლილება აისახება როლზე\"")
    public void checkRoleChangeWarningText() {

        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .hoverOnThreeDotsOnFirstRole()
                .clickOnEditRole();
        roleSteps
                .clickOnNextButton()
                .checkRoleChangeWarning();

    }

    @Test(description = "[WPL-T7995]")
    @Story("Role Page -> Actions tab -> Pressing \"Three dots\" -> Edit -> Limits tab -> Limits -> Setting limit")
    @Description("ვცვლით როლის ლიმიტის მნიშვნელობას, ვინახავთ და ვამოწმებთ რომ წარმატებით შეიცვალა")
    public void editRoleLimit() {




        String randomLimitValue = String.valueOf(new Random().nextInt(100, 1000));

        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .hoverOnThreeDotsOnFirstRole()
                .clickOnEditRole()
                .clickOnNextButton()
                .editRolesFirstLimitValue(randomLimitValue)
                .clickOnNextButton()
                .checkSuccessTextAfterChange()
//                .clickOnBackToRolesButton()
                .hoverOnThreeDotsOnFirstRole()
                .clickOnEditRole()
                .clickOnNextButton()
                .checkEditedRoleLimitValue(randomLimitValue);

    }

    @Test(description = "[WPL-T7996]")
    @Story("Role Page -> Actions tab -> Pressing \"Three dots\" -> Edit -> Limits tab -> Limits -> Add new operation")
    @Description("\"ახალი ოპერაციის დამატება\"-ზე დაჭერისას უნდა დაემატოს ახალი ველი, ოპერაციით ლიმიტითა და პერიოდით.")
    public void checkAddNewLimit() {

        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .hoverOnThreeDotsOnFirstRole()
                .clickOnEditRole();
        roleSteps
                .clickOnNextButton()
                .checkIfNewLimitLabelIsAddedAfterClickingAddNewLimit();

    }

    @Test(description = "[WPL-T7997]")
    @Story("Role Page -> Actions tab -> Pressing \"Three dots\" -> Edit -> Limits tab -> Limits -> Remove operation")
    @Description("\"X\" ღილაკზე დაჭერისას პერიოდის მარჯვნივ, უნდა წაიშალოს ის ველი რომლის გასწვრივადაც დავაჭირეთ ღილაკს")
    public void checkDeleteRoleLimit() {

        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .hoverOnThreeDotsOnFirstRole()
                .clickOnEditRole();
        roleSteps
                .clickOnNextButton()
                .addAndDeleteRoleLimit_checkThatDeleteWorks();

    }

    @Test(description = "[WPL-T7997]")
    @Story("Role Page -> Actions tab -> Pressing \"Three dots\" -> Edit -> Limits tab -> Limits -> Operations")
    @Description("ოპერაციების სიიდან უნდა ავირჩიოთ ჩვენთვის სასურველი ოპერაცია, მაგალითად ავირჩიოთ \"გადარიცხვა\"")
    public void editRoleLimitOperation() throws InterruptedException {

        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .hoverOnThreeDotsOnFirstRole()
                .clickOnEditRole()
                .clickOnNextButton()
                .clickOnLimitOperationDropdown();

        String newRoleLimitOperation = roleSteps
                .editLimitManagement();

        roleSteps
                .clickOnNextButton()
                .checkSuccessTextAfterChange()
//                .clickOnBackToRolesButton()
                .hoverOnThreeDotsOnFirstRole()
                .clickOnEditRole()
                .clickOnNextButton()
                .checkEditedRoleLimitOperationValue(newRoleLimitOperation);

    }

    @Test(description = "[WPL-T7973]")
    @Story("Role Page -> Role tab - Add new Role")
    @Description("შევქმნათ ახალი როლი და ვიზუალში უნდა გამოჩნდეს ეს როლი")
    public void createRole() {

        String newRoleName = helper.getRandomString();

        digitalServicesPageSteps
                .clickOnRolesHeader()
                .clickOnAddRoleButton();

        roleSteps
                .clickOnUserManagementDrowdown()
                .selectFirstRoleTemplate()
                .editRoleName(newRoleName)
                .clickOnNextButton()
                .addLimitWithValues()
                .clickOnNextButton()
                .checkSuccessTextAfterChange();
//                .clickOnBackToRolesButton();
        digitalServicesPageSteps
                .clickOnRolesHeader();
        roleSteps
                .goToLastRoleListPage()
                .checkCreatedRoleWithName(newRoleName)
                .deleteRoleWithName(newRoleName);


    }

    @Test(description = "[WPL-T7989]")
    @Story("Role Page -> Actions tab -> Pressing \"Three dots\" -> Edit -> Limits tab -> Approval Group")
    @Description("Approval groups can be set on the user but with some restrictions in mind, for retail client approval group can not be corporate and for corporate it cant be retail.\n" +
            "if we want to set approval group for retail, we need to Choose Retail as option and if we want to set it for corporate, we should choose corporate")
    public void checkApprovalGroupWhenUserIsRetail() {

        configAndLoginSteps
                .beforeStepForRetailUsers("6449887");
        digitalServicesPageSteps
                .clickOnUsersHeader()
                .clickOnRolesHeader();
        roleSteps
                .hoverOnThreeDotsOnFirstRole()
                .clickOnEditRole()
                .clickOnNextButton()
                .checkApprovalGroupsOptions("რითეილ");

    }


}
