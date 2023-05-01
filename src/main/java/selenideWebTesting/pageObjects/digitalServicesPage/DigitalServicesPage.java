package selenideWebTesting.pageObjects.digitalServicesPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DigitalServicesPage {

    public SelenideElement digitalServices = $x("//a[text()='ციფრული სივრცე']"),
            digitalServicesHeader_user = $x("//div[text()='მომხმარებელი']"),
            digitalServicesHeader_roles = $x("//div[text()='როლები']"),
            digitalServicesHeader_signingRules = $x("//div[text()='ხელმომწერები']"),
            digitalServicesHeader_addUsers = $x("//div[text()='მომხმარებლის დამატება']"),
            digitalServicesHeader_addRole = $x("//div[text()='როლის დამატება']"),
            digitalServicesHeader_changes = $x("//div[text()=' ცვლილებები ']"),
            role = $x("//th[text()=' როლი']"),
            approvalRule = $x("//th[text()=' დადასტურების ჯგუფი ']"),
            otherActions = $x("//th[text()=' სხვა ქმედებები ']");



    public ElementsCollection rolesList = $$x("//tr[@class='mat-row cdk-row ng-star-inserted']"),
    deleteRoles = $$x("//img[contains(@src,'recycle')]");


}
