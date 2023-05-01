package selenideWebTesting.pageObjects.digitalServicesPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Selenide.*;

public class Signers {

    public SelenideElement

            signingRules = $x("//th[text()=' ხელმოწერის წესი ']"),
            type = $x("//th[text()=' ტიპი ']"),
            otherActions = $x("//th[text()=' სხვა ქმედებები ']"),
            addSigningRulesButton = $x("//div[text()='ხელმოწერის წესის დამატება']"),
            viewSignerRole = $x("//span[text()='ნახვა']"),
            editSignerRole = $x("//span[text()='შეცვლა']"),
            deleteSignerRole = $x("//span[text()='წაშლა']"),
            signingRuleName = $x("//p[text()='დასახელება']/following-sibling::p[1]"),
            signingRuleLimitsAmount = $x("//p[text()='ლიმიტის თანხა']/following-sibling::p[1]"),
            signingRuleCurrency = $x("//p[text()='ვალუტა']/following-sibling::p[1]"),
            signingRuleOperationType = $x("//p[text()='ოპერაციის ტიპი']/following-sibling::p[1]"),
            operationTypes = $x("//div[@class='signing-rules-tabs']//p[text()='ოპერაციის ტიპი(ები)']"),

    signers = $x("//div[@class='signing-rules-tabs']//p[text()='ხელმოწერა(ები)']"),

    addSigningRules_operationTypeDropdown = $x("//mat-label[text()='ოპერაციის ტიპი']/..//mat-form-field"),
            addSigningRules_operationTypeFinancial = $x("//span[text()=' ფინანსური ' or text()=' Financial ']"),
            addSigningRules_operationTypeNonFinancial = $x("//span[text()=' არაფინანსური ' or text() = ' NonFinancial ']"),
            addSigningRules_nameInput = $x("//mat-label[text()='სახელი']/..//input"),
            updateSigningRule_nameInput = $x("//mat-label[text()='ხელმოწერის სახელი']/..//input"),
            addSigningRules_limitInput = $x("//mat-label[text()='ლიმიტი']/..//input"),
            updateSigningRules_limitInput = $x("//mat-label[text()='ლიმიტის თანხა']/..//input"),
            addSigningRules_currencyDropdown = $x("//mat-label[text()='ვალუტა']/..//mat-form-field"),
            updateSigningRules_currencyDropdown = $x("//mat-label[text()='ვალუტის კურსი']/..//mat-form-field"),
            addSigningRules_currencyGel = $(new ByText("GEL")),
            updateSigningRules_currencyGel = $x("//span[text()=' GEL ']"),
            saveButton = $x("//button[@class='next-btn']"),
            backButton = $x("//div[@class='back-btn']"),
            quitButton = $x("//button[@class='quit-button']"),
            bactToSignerRolesButton = $x("//img[@alt='eye-icon']"),
            nextButton = $x("//button[@class='next-btn']"),
            updateButton = $x("//button[@class='update-button']"),
            successText = $x("//span[text()='წარმატებით შესრულდა']"),
            matSelectChooseOperation = $x("//mat-label[text()='აირჩიე ოპერაცია']//..//mat-select"),
            matSelectChooseSigner = $x("//mat-label[text()='აირჩიე ხელმომწერი']//..//mat-select"),
            addOperationButton = $(new ByText("ოპერაციის დამატება +")),
            addSingersButton = $(new ByText("ხელმოწერის დამატება +")),
            updateButtonInSigningRule = $x("//p[text()='შეცვლა']"),
            errorForNotFillingAnySigningRulesTab = $x("//div[text()='One or more validation errors occurred.']"),
            closePopUp = $x("//span[text()='დახურვა']");

    public ElementsCollection
            listOfChosenOptions = $$x("//tbody//tr//td[1]"),
            threeDots = $$x("//mat-icon[text()='more_vert']"),
            matOptions = $$x("//mat-option");

}
