package selenideWebTesting.pageObjects.digitalServicesPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Roles {

    public SelenideElement
            limitsHeader = $(byText("ლიმიტები")),
            limitPeriod_Once = $(byText("ერთჯერადი")),
            limitPeriod_Weekly = $(byText("ერთი კვირა")),
            limitPeriod_Monthly = $(byText("ერთი თვე")),
            limitPeriod_Yearly = $(byText("ერთი წელი")),
            mat_select = $x("//div[@role='listbox']"),

    infoPopUp = $x("//h2[text()='შეტყობინება']"),
            closePopUp = $x("//span[text()='დახურვა']"),
            viewRole = $x("//span[text()='ნახვა']"),
            editRole = $x("//span[text()='შეცვლა']"),
            deleteRole = $x("//span[text()='წაშლა']"),
            roleViewRangeLabel = $(By.className("mat-paginator-range-label")),
            rolesPerPage = $x("//mat-select[@role='combobox']"),
            nextArrowButton = $x("//div[@class='mat-paginator-range-actions']//button[@type='button'][2]"),
            backArrowButton = $x("//div[@class='mat-paginator-range-actions']//button[@type='button'][2]"),
            roleNumberRange = $(By.className("mat-paginator-range-label")),

    // EditRole
    turnOnAllActions = $x("//span[text()=' ყველა ქმედების ჩართვა ']/..//input"),
            backButton = $x("//div[@class='back-btn']"),
            nextButton = $x("//button[@class='next-btn']"),
            bactToRolesButton = $x("//img[@alt='eye-icon']"),
            roleName = $x("//usmng-usmng-input[@controlname='name']//input"),
            successTextAfterEdit = $x("//span[text()='წარმატებით შესრულდა']"),
            unSuccessTextAfterEdit = $x("//span[text()='ვერ შესრულდა']"),
            userManagementDropDown = $(By.className("user-management-dropdown")),
            userManagement_retailActive = $x("//span[text()=' Retail Active ']"),
            userManagement_retailPassive = $x("//span[text()=' Retail Passive ']"),
            userManagement_retailDigitalOnboarding = $x("//span[text()=' Retail Digital Onboarding ']"),
            userManagement_corporateDirector = $x("//span[text()=' Corporate Director ']"),
            userManagement_corporateActive = $x("//span[text()=' Corporate Active ']"),
            userManagement_corporatePassive = $x("//span[text()=' Corporate Passive ']"),
            roleChangeWarning = $x("//p[text()='განხორციელებული ცვლილებები აისახება როლზე']"),
            addNewRoleButton = $x("//div[text()='როლის დამატება']"),


    addNewLimit = $x("//p[text()=' ახალი ოპერაციის დამატება + ']"),
            approvalGroup = $x("//p[text()='აირჩიე ჯგუფი']/..//mat-select"),

    html = $x("//html");

    public ElementsCollection
            rolesList = $$x("//tr[@class='mat-row cdk-row ng-star-inserted']"),
            deleteRoles = $$x("//img[contains(@src,'recycle')]"),

    viewRolesCollection = $$x("//img[contains(@src, 'eye-icon.svg')]"),
            roleStatus = $$x("//tbody[@role='rowgroup']//tr/td[3]"),
            actions = $$x("//mat-label[text()='Action']//ancestor::span/../mat-select"),
            limits = $$x("//mat-label[text()='Limit']//ancestor::span/../input"),
            period = $$x("//mat-label[text()='Period']//ancestor::span/../mat-select"),
            mat_options = $$x("//mat-option"),
            threeDots = $$x("//mat-icon[text()='more_vert']"),
            actionsCategory = $$(By.xpath("//div[@class='actions-category']//input")),
            roleActions = $$x("//div[@class='action-checkbox-container']//input"),

    //RoleLimits
    roleLimitInputs = $$x("//input"),
            deleteRoleLimitButtons = $$x("//img[@class='delete-icon']"),
            limitOperation = $$x("//mat-label[text()='ოპერაცია']/..//mat-select[1]"),
            limitPeriodicity = $$x("//mat-label[text()='პერიოდი']/..//mat-select[1]"),
            listOfChosenOptions = $$x("//tbody//tr//td[1]");


}
