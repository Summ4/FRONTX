package selenideWebTesting.stepObjects.digitalServicesPageSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import selenideWebTesting.dataObjects.Enums.PeriodEnums;
import selenideWebTesting.pageObjects.digitalServicesPage.Roles;

import java.time.Duration;

import static selenideWebTesting.dataObjects.UserData.longWaiter;
import static selenideWebTesting.dataObjects.UserData.waiter;

public class RoleSteps extends Roles {

    @Step
    public RoleSteps checkElementsOnBottomOfThePage() {

        roleViewRangeLabel.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        rolesPerPage.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        nextArrowButton.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        backArrowButton.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        nextArrowButton.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));


        return this;

    }

    @Step
    public RoleSteps clickOnFirstViewRoleEyeButton() {

        viewRolesCollection.get(0).shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        viewRolesCollection.get(0).click();

        return this;

    }

    @Step
    public RoleSteps hoverOnThreeDotsOnFirstRole() {

        threeDots.get(0).shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        threeDots.get(0).hover();

        return this;

    }

    @Step
    public RoleSteps checkActionsOnRolesButton() {

        viewRole.shouldHave(Condition.visible, Duration.ofMillis(waiter));
        editRole.shouldHave(Condition.visible, Duration.ofMillis(waiter));
        deleteRole.shouldHave(Condition.visible, Duration.ofMillis(waiter));

        return this;

    }

    @Step
    public RoleSteps clickOnViewRole() {

        viewRole.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        viewRole.click();

        return this;

    }

    @Step
    public RoleSteps clickOnEditRole() {

        editRole.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        editRole.click();

        return this;

    }

    @Step
    public RoleSteps clickOnLimitsHeader() {

        limitsHeader.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        limitsHeader.click();

        return this;

    }

    @Step
    public RoleSteps checkRoleStatus() {

        roleStatus.get(0).shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        for (com.codeborne.selenide.SelenideElement status : roleStatus) {
            status.shouldHave(Condition.or("text", Condition.text(" დასაავტორიზებელი "), Condition.text(" აქტიური ")));
        }

        return this;

    }

    @Step
    public RoleSteps clickOnActionsSelect() {

        actions.get(0).shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        actions.get(0).click();

        return this;

    }

    @Step
    public RoleSteps clickOnPeriodSelect() {

        period.get(0).shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        period.get(0).click();

        return this;

    }

    @Step
    public RoleSteps checkLimitsHeaders() {

        actions.get(0).shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        limits.get(0).shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        period.get(0).shouldBe(Condition.visible, Duration.ofMillis(longWaiter));

        return this;

    }

    @Step
    public RoleSteps checkLimitsPeriodValues() {

        mat_options.get(0).shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        PeriodEnums[] periodValues = PeriodEnums.values();

        for (int i = 0; i < periodValues.length; i++) {
            mat_options.get(i).shouldHave(Condition.text(periodValues[i].getPeriod()));
        }
        return this;

    }

    public RoleSteps clickOnDeleteRoleButton() {

        rolesList.get(0).shouldBe(Condition.visible, Duration.ofMillis(longWaiter));

        deleteRoles.get(rolesList.size() - 1).shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        deleteRoles.get(rolesList.size() - 1).click();

        Selenide.sleep(4000);

        return this;

    }

    public RoleSteps clickOnDeleteRoleButtonAndCheckIfDeleted() {

        rolesList.get(0).shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        int roleListcountBeforeDelete = rolesList.size();

        deleteRoles.get(rolesList.size() - 1).shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        deleteRoles.get(rolesList.size() - 1).click();

        Selenide.sleep(4000);
        int roleListcountAfterDelete = rolesList.size();

        Assert.assertEquals(roleListcountBeforeDelete - 1, roleListcountAfterDelete);

        return this;

    }

    @Step
    public RoleSteps checkButtonsOnViewOrEditRolesPage() {

        turnOnAllActions.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        backButton.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        nextButton.shouldBe(Condition.visible, Duration.ofMillis(waiter));

        return this;

    }

    @Step
    public RoleSteps checkThatEditIsNotPossibleWhileViewing() {

        turnOnAllActions.isEnabled();
        roleName.shouldNotBe(Condition.exist);

        clickOnNextButton();
        addNewLimit.shouldNotBe(Condition.exist);

        return this;

    }

    @Step
    public RoleSteps clickOnSelectAllActions() {

        turnOnAllActions.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));

        if (!turnOnAllActions.isSelected())
            turnOnAllActions.parent().click();

        return this;

    }

    @Step
    public RoleSteps checkIfAllActionsAreSelected() {

        actionsCategory.get(0).shouldBe(Condition.visible, Duration.ofMillis(longWaiter));

        for (SelenideElement action : actionsCategory) {
            action.shouldBe(Condition.selected);
        }

        return this;

    }

    @Step
    public RoleSteps checkIfActionsAllOptionsIsSelected() {

        actionsCategory.get(0).shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        SelenideElement action = actionsCategory.get(0);

        if (action.isEnabled()) {
            action.parent().click();
            for (SelenideElement selenideElement : actions) {
                selenideElement.shouldNotBe(Condition.selected);
            }
        }

        action.parent().click();

        for (SelenideElement selenideElement : actions) {
            selenideElement.shouldBe(Condition.selected);
        }

        return this;

    }

    @Step
    public RoleSteps clearRoleName() {

        roleName.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        roleName.sendKeys(Keys.COMMAND, "a");
        roleName.sendKeys(Keys.BACK_SPACE);

        return this;

    }

    @Step
    public RoleSteps editRoleName(String newRoleName) {

        roleName.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        roleName.sendKeys(Keys.COMMAND, "a");
        roleName.sendKeys(Keys.BACK_SPACE);
        roleName.sendKeys(newRoleName);

        return this;

    }

    @Step
    public RoleSteps editRolesFirstLimitValue(String newLimitValue) {

        roleLimitInputs.get(0).shouldBe(Condition.visible, Duration.ofMillis(waiter));
        roleLimitInputs.get(0).setValue("");
        roleLimitInputs.get(0).sendKeys(newLimitValue);

        return this;

    }

    @Step
    public RoleSteps clickOnNextButton() {

        nextButton.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        nextButton.click();

        return this;

    }

    @Step
    public RoleSteps clickOnBackButton() {

        backButton.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        backButton.click();

        return this;

    }

    @Step
    public RoleSteps clickOnBackToRolesButton() {

        bactToRolesButton.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        bactToRolesButton.click();

        return this;

    }

    @Step
    public RoleSteps checkSuccessTextAfterChange() {

        successTextAfterEdit.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));

        return this;

    }

    @Step
    public RoleSteps checkUnSuccessTextAfterChange() {

        if (infoPopUp.isDisplayed())
            closePopUp.click();
        unSuccessTextAfterEdit.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));

        return this;

    }

    @Step
    public RoleSteps checkEditedRoleName(String newRoleName) {

        new Roles().rolesList.get(0).shouldHave(Condition.text(newRoleName));

        return this;

    }

    @Step
    public RoleSteps checkEditedRoleLimitValue(String newRoleLimitValue) {

        Assert.assertEquals(roleLimitInputs.get(0).getValue(), newRoleLimitValue);

        return this;

    }

    @Step
    public RoleSteps clickOnUserManagementDrowdown() {

        userManagementDropDown.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        userManagementDropDown.click();

        return this;

    }

    @Step
    public RoleSteps selectFirstRoleTemplate() {

        mat_options.get(0).shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        mat_options.get(0).click();

        return this;

    }


    @Step
    public RoleSteps checkUserManagementDropdownOptionsForRetailUser() {

        userManagement_retailActive.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        userManagement_retailPassive.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        userManagement_retailDigitalOnboarding.shouldBe(Condition.visible, Duration.ofMillis(waiter));

        return this;

    }

    @Step
    public RoleSteps checkUserManagementDropdownOptionsForCorporateUser() {

        userManagement_corporateDirector.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        userManagement_corporateActive.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        userManagement_corporatePassive.shouldBe(Condition.visible, Duration.ofMillis(waiter));

        return this;

    }

    @Step
    public RoleSteps checkIfUserNavigatedToRoleLimitsPage() {

        userManagementDropDown.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));

        return this;

    }

    @Step
    public RoleSteps clickOnAddNewLimitButton() {

        addNewLimit.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        addNewLimit.click();

        return this;

    }

    @Step
    public RoleSteps clickOnFirstDeleteLimitButton() {

        deleteRoleLimitButtons.get(0).shouldBe(Condition.visible, Duration.ofMillis(waiter));
        deleteRoleLimitButtons.get(0).click();

        return this;

    }

    @Step
    public RoleSteps deleteRolesAllLimits() {

        if (deleteRoleLimitButtons.get(0).isDisplayed()) {
            for (SelenideElement deleteButton : deleteRoleLimitButtons) {
                deleteButton.click();
            }
        }

        Assert.assertEquals(deleteRoleLimitButtons.size(), 0);

        return this;

    }

    @Step
    public RoleSteps addAndDeleteRoleLimit_checkThatDeleteWorks() {

        addNewLimit.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        addNewLimit.click();

        int roleLimitsBeforeDelete = deleteRoleLimitButtons.size();

        deleteRoleLimitButtons.get(deleteRoleLimitButtons.size() - 1).click();

        int roleLimitsAfterDelete = deleteRoleLimitButtons.size();

        Assert.assertEquals(roleLimitsAfterDelete, roleLimitsBeforeDelete - 1);

        return this;

    }

    @Step
    public RoleSteps checkIfNewLimitLabelIsAddedAfterClickingAddNewLimit() {

        addNewLimit.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        int limitsCountBeforeAddingNewLimit = roleLimitInputs.size();

        addNewLimit.click();
        int limitsCountAfterAddingNewLimit = roleLimitInputs.size();

        Assert.assertEquals(limitsCountBeforeAddingNewLimit + 1, limitsCountAfterAddingNewLimit);

        return this;

    }

    @Step
    public RoleSteps checkRoleChangeWarning() {

        roleChangeWarning.shouldBe(Condition.visible, Duration.ofMillis(waiter));

        return this;

    }

    @Step
    public RoleSteps clickOnLimitOperationDropdown() {

        if (!limitOperation.get(0).isDisplayed())
            addNewLimit.click();

        limitOperation.get(0).shouldBe(Condition.visible, Duration.ofMillis(waiter));
        limitOperation.get(0).click();

        return this;

    }

    @Step
    public String editLimitManagement() {
        SelenideElement element = mat_options.filter(Condition.not(Condition.attribute("aria-selected"))).first();
        String operation = element.getText();
        element.click();

        return operation;
    }

    @Step
    public RoleSteps checkEditedRoleLimitOperationValue(String newRoleLimitOperationValue) throws InterruptedException {

        Thread.sleep(3000);
        Assert.assertEquals(limitOperation.get(0).getText(), newRoleLimitOperationValue);

        return this;

    }

    @Step
    public RoleSteps addLimitWithValues() {

        addNewLimit.click();

        approvalGroup.shouldBe(Condition.visible, Duration.ofMillis(waiter));

        limitOperation.get(0).shouldBe(Condition.visible, Duration.ofMillis(waiter));
        limitPeriodicity.get(0).shouldBe(Condition.visible, Duration.ofMillis(waiter));
        roleLimitInputs.get(0).shouldBe(Condition.visible, Duration.ofMillis(waiter));

        approvalGroup.click();
        mat_options.get(0).click();

        limitOperation.get(0).click();
        mat_options.get(0).click();

        roleLimitInputs.get(0).sendKeys("100");


        limitPeriodicity.get(0).click();
        mat_options.get(0).click();

        return this;

    }

    @Step
    public RoleSteps clickOnNextRoleListPageButton() {

        nextArrowButton.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        if (nextArrowButton.isEnabled())
            nextArrowButton.click();

        return this;

    }

    @Step
    public RoleSteps goToLastRoleListPage() {

        nextArrowButton.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        while (nextArrowButton.isEnabled())
            nextArrowButton.click();

        return this;

    }

    @Step
    public RoleSteps checkCreatedRoleWithName(String roleName) {

        rolesList.get(rolesList.size() - 1).shouldHave(Condition.text(roleName));

        return this;

    }

    @Step
    public RoleSteps deleteRoleWithName(String roleName) {

        int index = 0;
        for (int i = 0; i < rolesList.size(); i++) {
            if (rolesList.get(i).getText().contains(roleName)) {
                index = i;
                break;
            }
        }
        threeDots.get(index).hover();
        deleteRole.click();

        return this;

    }

    @Step
    public RoleSteps checkApprovalGroupsOptions(String option) {

        approvalGroup.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        approvalGroup.click();

        mat_options.get(0).shouldBe(Condition.visible, Duration.ofMillis(waiter));
        ;

        for (SelenideElement matOption : mat_options) {
            matOption.shouldHave(Condition.partialText(option));
        }

        return this;

    }

}
