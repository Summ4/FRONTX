package selenideWebTesting.stepObjects.digitalServicesPageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import selenideWebTesting.pageObjects.digitalServicesPage.DigitalServicesPage;

import java.time.Duration;

import static selenideWebTesting.dataObjects.UserData.longWaiter;
import static selenideWebTesting.dataObjects.UserData.waiter;

public class DigitalServicesPageSteps extends DigitalServicesPage {

    @Step
    public DigitalServicesPageSteps clickOnDigitalServices() {
        digitalServices.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        digitalServices.click();

        return this;
    }

    @Step
    public DigitalServicesPageSteps checkDigitalServicesHeaders() {
        digitalServicesHeader_user.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        digitalServicesHeader_roles.shouldBe(Condition.visible, Duration.ofMillis(waiter));
//        digitalServicesHeader_signingRules.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        digitalServicesHeader_addUsers.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        digitalServicesHeader_changes.shouldBe(Condition.visible, Duration.ofMillis(waiter));

        return this;
    }

    @Step
    public DigitalServicesPageSteps clickOnUsersHeader() {
        digitalServicesHeader_user.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        digitalServicesHeader_user.click();

        return this;
    }

    @Step
    public DigitalServicesPageSteps clickOnRolesHeader() {
        digitalServicesHeader_roles.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        digitalServicesHeader_roles.click();
//        digitalServicesHeader_signingRules.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
//        digitalServicesHeader_addUsers.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));

        return this;
    }

    @Step
    public DigitalServicesPageSteps clickOnSigningRulesHeader() {
        digitalServicesHeader_signingRules.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        digitalServicesHeader_signingRules.click();
        digitalServicesHeader_addUsers.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));

        return this;
    }

    @Step
    public DigitalServicesPageSteps clickOnAddUsersButton() {
        digitalServicesHeader_addUsers.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        digitalServicesHeader_addUsers.click();

        return this;
    }

    @Step
    public DigitalServicesPageSteps clickOnAddRoleButton() {
        digitalServicesHeader_addRole.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        digitalServicesHeader_addRole.click();

        return this;
    }

    @Step
    public DigitalServicesPageSteps checkHeadersWhenUserHasSelected_customers() {

        digitalServicesHeader_user.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        digitalServicesHeader_roles.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        digitalServicesHeader_addUsers.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
//        digitalServicesHeader_signingRules.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        digitalServicesHeader_changes.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));

        return this;

    }

    @Step
    public DigitalServicesPageSteps checkHeadersWhenUserHasSelected_roles() {

        digitalServicesHeader_user.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        digitalServicesHeader_roles.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        digitalServicesHeader_addRole.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
//        digitalServicesHeader_signingRules.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        digitalServicesHeader_changes.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));

        return this;

    }

    @Step
    public DigitalServicesPageSteps checkHeadersOnMainServicesTab() {

        role.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        approvalRule.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        otherActions.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));


        return this;
    }




}
