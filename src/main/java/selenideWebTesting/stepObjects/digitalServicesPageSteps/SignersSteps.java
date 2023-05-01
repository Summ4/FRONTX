package selenideWebTesting.stepObjects.digitalServicesPageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import selenideWebTesting.pageObjects.digitalServicesPage.Signers;

import java.time.Duration;

import static selenideWebTesting.dataObjects.UserData.longWaiter;
import static selenideWebTesting.dataObjects.UserData.waiter;

public class SignersSteps extends Signers {

    @Step
    public SignersSteps checkSigningRulesHeaders() {

        signingRules.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        type.shouldBe(Condition.visible);
        otherActions.shouldBe(Condition.visible);

        return this;
    }

    @Step
    public SignersSteps checkFinancialSignersHeaders() {
        signingRuleName.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        signingRuleLimitsAmount.shouldBe(Condition.visible);
        signingRuleCurrency.shouldBe(Condition.visible);
        signingRuleOperationType.shouldBe(Condition.visible);
        operationTypes.shouldBe(Condition.visible);
        signers.shouldBe(Condition.visible);

        return this;
    }

    @Step
    public SignersSteps checkNonFinancialSignersHeaders() {

        signingRuleName.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        signingRuleOperationType.shouldBe(Condition.visible);
        operationTypes.shouldBe(Condition.visible);
        signers.shouldBe(Condition.visible);

        return this;
    }

    @Step
    public SignersSteps clickOnAddSigningRulesButton() {

        addSigningRulesButton.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        addSigningRulesButton.click();

        return this;
    }

    @Step
    public SignersSteps chooseOperation(String operation) throws InterruptedException {

        operationTypes.click();
        addOperationButton.click();
        matSelectChooseOperation.click();
        Thread.sleep(1000);
        for (com.codeborne.selenide.SelenideElement matOption : matOptions) {
            if (matOption.getText().contains(operation)) {
                matOption.click();
                break;
            }
        }
        updateButton.sendKeys(Keys.ESCAPE);
        updateButton.click();

        return this;

    }

    @Step
    public SignersSteps chooseOperationWithoutSaving(String operation) throws InterruptedException {

        operationTypes.click();
        addOperationButton.click();
        matSelectChooseOperation.click();
        Thread.sleep(1000);
        for (com.codeborne.selenide.SelenideElement matOption : matOptions) {
            if (matOption.getText().contains(operation)) {
                matOption.click();
                break;
            }
        }

        return this;

    }

    @Step
    public SignersSteps chooseSignerWithoutSaving(String signer) throws InterruptedException {

        addSingersButton.click();
        matSelectChooseSigner.click();
        Thread.sleep(1000);
        for (com.codeborne.selenide.SelenideElement matOption : matOptions) {
            if (matOption.getText().contains(signer)) {
                matOption.click();
                break;
            }
        }

        return this;

    }

    @Step
    public SignersSteps chooseSigner(String signer) throws InterruptedException {

        addSingersButton.click();
        matSelectChooseSigner.click();
        Thread.sleep(1000);
        for (com.codeborne.selenide.SelenideElement matOption : matOptions) {
            if (matOption.getText().contains(signer)) {
                matOption.click();
                break;
            }
        }
        updateButton.click();

        return this;

    }

    @Step
    public SignersSteps chooseMoreThanOneSigner(String[] signers) throws InterruptedException {

        for (String signer : signers) {
            addSingersButton.click();
            matSelectChooseSigner.click();
            Thread.sleep(1000);
            for (com.codeborne.selenide.SelenideElement matOption : matOptions) {
                if (matOption.getText().contains(signer)) {
                    matOption.click();
                    break;
                }
            }
            updateButton.click();
        }

        return this;

    }

    @Step
    public SignersSteps clickOnAddSingersButton() {

        addSingersButton.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        addSingersButton.click();

        return this;

    }

    @Step
    public SignersSteps checkSelectedSigners(String[] signers) {

        for (int i = 0; i < listOfChosenOptions.size(); i++) {
            listOfChosenOptions.get(i).shouldHave(Condition.partialText(signers[i]));
        }

        return this;

    }

    @Step
    public SignersSteps checkIfOperationIsAdded(String operation) {

        listOfChosenOptions.get(0).shouldHave(Condition.text(operation));

        return this;

    }

    @Step
    public SignersSteps checkSelectedOperations(String[] operations) {

        for (int i = 0; i < listOfChosenOptions.size(); i++) {
            listOfChosenOptions.get(i).shouldHave(Condition.partialText(operations[i]));
        }

        return this;

    }

    @Step
    public SignersSteps checkIfOperationsIsEmpty() throws InterruptedException {

        Thread.sleep(2000);
        Assert.assertEquals(listOfChosenOptions.size(), 0);

        return this;

    }

    @Step
    public SignersSteps checkIfSignersIsEmpty() throws InterruptedException {

        Thread.sleep(2000);
        Assert.assertEquals(listOfChosenOptions.size(), 0);

        return this;

    }

    @Step
    public SignersSteps chooseNonFinancialOperationType() {

        addSigningRules_operationTypeDropdown.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        addSigningRules_operationTypeDropdown.click();

        addSigningRules_operationTypeNonFinancial.click();

        return this;

    }

    @Step
    public SignersSteps clickOnSigners() {

        signers.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        signers.click();

        return this;

    }

    @Step
    public SignersSteps selectOperationType(String operationType) {

        addSigningRules_operationTypeDropdown.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        addSigningRules_operationTypeDropdown.click();

        if (operationType.equals("ფინანსური")) addSigningRules_operationTypeFinancial.click();
        else if (operationType.equals("არაფინანსური")) addSigningRules_operationTypeNonFinancial.click();

        return this;

    }

    @Step
    public SignersSteps enterLimitAmount(String limit) {

        updateSigningRules_limitInput.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        updateSigningRules_limitInput.sendKeys(limit);

        return this;

    }

    @Step
    public SignersSteps selectGelCurrency() {

        updateSigningRules_currencyDropdown.click();
        updateSigningRules_currencyGel.click();

        return this;

    }

    @Step
    public SignersSteps addNewFinancialSigningRule(String name, String limit, String currency, String operation, String signer) throws InterruptedException {

        addSigningRules_operationTypeDropdown.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        addSigningRules_operationTypeDropdown.click();

        addSigningRules_operationTypeFinancial.click();

        addSigningRules_nameInput.sendKeys(name);
        addSigningRules_limitInput.sendKeys(limit);

        addSigningRules_currencyDropdown.click();
        addSigningRules_currencyGel.click();

        operationTypes.click();
        addOperationButton.click();
        matSelectChooseOperation.click();
        Thread.sleep(1000);
        for (com.codeborne.selenide.SelenideElement matOption : matOptions) {
            if (matOption.getText().contains(operation)) {
                matOption.click();
                break;
            }
        }
        updateButton.sendKeys(Keys.ESCAPE);
        updateButton.click();

        signers.click();
        addSingersButton.click();
        matSelectChooseSigner.click();
        Thread.sleep(1000);
        for (com.codeborne.selenide.SelenideElement matOption : matOptions) {
            if (matOption.getText().contains(signer)) {
                matOption.click();
                break;
            }
        }
        updateButton.click();

        Thread.sleep(1000);
        saveButton.click();

        return this;
    }

    @Step
    public SignersSteps addNewNonFinancialSigningRule(String name, String operation, String signer) throws InterruptedException {

        addSigningRules_operationTypeDropdown.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        addSigningRules_operationTypeDropdown.click();

        addSigningRules_operationTypeNonFinancial.click();

        addSigningRules_nameInput.sendKeys(name);

        operationTypes.click();
        addOperationButton.click();
        matSelectChooseOperation.click();
        Thread.sleep(1000);
        for (com.codeborne.selenide.SelenideElement matOption : matOptions) {
            if (matOption.getText().contains(operation)) {
                matOption.click();
                break;
            }
        }
        updateButton.sendKeys(Keys.ESCAPE);
        updateButton.click();

        signers.click();
        addSingersButton.click();
        matSelectChooseSigner.click();
        Thread.sleep(1000);
        for (com.codeborne.selenide.SelenideElement matOption : matOptions) {
            if (matOption.getText().contains(signer)) {
                matOption.click();
                break;
            }
        }
        updateButton.click();

        Thread.sleep(1000);
        saveButton.click();

        return this;
    }

    @Step
    public SignersSteps checkSuccessText() {

        successText.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));

        return this;

    }

    @Step
    public SignersSteps hoverOnFirstThreeDots() {

        threeDots.get(0).shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        threeDots.get(0).hover();

        return this;

    }

    @Step
    public SignersSteps hoverOnThreeDotsWithName(String name) throws InterruptedException {

        Thread.sleep(2000);

        for (int i = 0; i < listOfChosenOptions.size(); i++) {
            listOfChosenOptions.get(i).scrollTo();
            if (listOfChosenOptions.get(i).has(Condition.text(name))) {
                threeDots.get(i).hover();
                break;
            }
        }


        return this;
    }

    @Step
    public SignersSteps hoverOnFirstNonFinancialSignerRoleThreeDots() {

        threeDots.get(0).shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        threeDots.get(0).hover();

        return this;

    }

    @Step
    public SignersSteps clickOnViewSignerRole() {

        viewSignerRole.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        viewSignerRole.click();

        return this;

    }

    @Step
    public SignersSteps clickOnDeleteSignerRole() {

        deleteSignerRole.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        deleteSignerRole.click();

        return this;

    }

    @Step
    public SignersSteps clickOnEditOnSignerRolePage() {

        editSignerRole.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        editSignerRole.click();

        return this;

    }

    @Step
    public SignersSteps clickOnOperationTypeDropDown() {

        addSigningRules_operationTypeDropdown.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        addSigningRules_operationTypeDropdown.click();

        return this;

    }

    @Step
    public SignersSteps selectOperationTypeFinancial() {

        addSigningRules_operationTypeFinancial.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        addSigningRules_operationTypeFinancial.click();

        return this;

    }

    @Step
    public SignersSteps checkIfLimitsAndCurrencyLabelsAreVisibleWhenChoosingFinancialOperationType() {

        addSigningRules_limitInput.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        addSigningRules_currencyDropdown.shouldBe(Condition.visible);

        return this;

    }

    @Step
    public SignersSteps checkLimitsAndCurrencyLabelsIsnotVisibleWhenChoosingNonFinancialOperationType() {

        addSigningRules_limitInput.shouldNotBe(Condition.visible, Duration.ofMillis(waiter));
        addSigningRules_currencyDropdown.shouldNotBe(Condition.visible);

        return this;

    }

    @Step
    public SignersSteps selectOperationTypeNonFinancial() {

        addSigningRules_operationTypeNonFinancial.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        addSigningRules_operationTypeNonFinancial.click();

        return this;

    }

    @Step
    public SignersSteps clickOnNextButton() {

        nextButton.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        nextButton.click();

        return this;

    }

    @Step
    public SignersSteps clickOnUpdateButton() {

        updateButton.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        updateButton.click();

        return this;

    }

    @Step
    public SignersSteps clickOnBackButton() {

        backButton.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        backButton.click();

        return this;

    }

    @Step
    public SignersSteps clickOnQuitButton() {

        quitButton.sendKeys(Keys.ESCAPE);
        quitButton.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        quitButton.click();

        return this;

    }

    @Step
    public SignersSteps clickOnBackToRolesButton() {

        bactToSignerRolesButton.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        bactToSignerRolesButton.click();

        return this;

    }

    @Step
    public SignersSteps checkIfSignerRuleExist(String name) throws InterruptedException {

        boolean signingRuleExists = false;
        int i;

        for (i = 0; i < listOfChosenOptions.size(); i++) {
            listOfChosenOptions.get(i).scrollTo();
            if (listOfChosenOptions.get(i).has(Condition.text(name))) {
                signingRuleExists = true;
                break;
            }
        }
        Thread.sleep(2000);
        Assert.assertTrue(signingRuleExists);

        return this;
    }

    @Step
    public SignersSteps clickOnUpdateButtonInSigningRule() {

        updateButtonInSigningRule.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        updateButtonInSigningRule.click();

        return this;

    }

    @Step
    public SignersSteps updateSigningRuleName(String name) {

        updateSigningRule_nameInput.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
//        updateSigningRule_nameInput.sendKeys(Keys.COMMAND + "a" + Keys.DELETE);
//        updateSigningRule_nameInput.sendKeys(Keys.DELETE);
        updateSigningRule_nameInput.setValue("");
        updateSigningRule_nameInput.sendKeys(name);

        return this;

    }

    @Step
    public SignersSteps checkIfSigningRuleIsNotInList(String name) throws InterruptedException {

        Thread.sleep(3000);
        boolean signingRuleExists = false;
        int i;
        for (i = 0; i < listOfChosenOptions.size(); i++) {
            listOfChosenOptions.get(i).scrollTo();
            if (listOfChosenOptions.get(i).has(Condition.text(name))) {
                signingRuleExists = true;
                break;
            }
        }
        Thread.sleep(2000);
        Assert.assertFalse(signingRuleExists);

        return this;
    }

    @Step
    public SignersSteps updateButtonIsnotAvailable() {

        updateButtonInSigningRule.shouldNotBe(Condition.visible, Duration.ofMillis(longWaiter));

        return this;

    }

    @Step
    public SignersSteps checkButtonsOnAddNewSigningRulePage() {

        addSigningRules_nameInput.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        addSigningRules_operationTypeDropdown.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        operationTypes.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        signers.shouldBe(Condition.visible, Duration.ofMillis(waiter));

        return this;
    }

    @Step
    public SignersSteps checkErrorForNotFillingAnySigningRulesTab() {

        errorForNotFillingAnySigningRulesTab.shouldBe(Condition.visible, Duration.ofMillis(waiter));

        return this;
    }

    @Step
    public SignersSteps closePopUp() {

        closePopUp.shouldBe(Condition.visible, Duration.ofMillis(waiter));
        closePopUp.click();

        return this;

    }

}
