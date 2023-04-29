package selenideWebTesting;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import selenideWebTesting.stepObjects.digitalServicesPageSteps.DigitalServicesPageSteps;
import selenideWebTesting.stepObjects.digitalServicesPageSteps.SignersSteps;
import selenideWebTesting.utils.ConfigAndLoginSteps;
import selenideWebTesting.utils.Helper;

public class Signers extends ConfigAndLoginSteps {

    DigitalServicesPageSteps digitalServicesPageSteps = new DigitalServicesPageSteps();
    SignersSteps signersSteps = new SignersSteps();
    Helper helper = new Helper();

    @Test(description = "[WPL-T8323]")
    @Story("Digital Services -> Pressing Signing Rules -> Visual")
    @Description("""
            On this tab next information must be visible:
                                        ხელმოწერის წესი (Name of Singing Rule)
                                        ტეპი (Financial or Non-Financial)
                                        სხვა ქმედებები (Edit, View, Delete)""")
    public void checkVisualOfElements_SigningRule() {

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .checkSigningRulesHeaders();

    }

    @Test(description = "[WPL-T8236]")
    @Story("Digital Services -> Pressing Signing Rules -> უკან დაბრუნების ღილაკი")
    @Description("ზედა მარცხენა კუთხეში არსებულ უკან დაბრუნების ღილაკზე (<- ხელმოწერის წესები) დაჭერისას უნდა გვაბრუნებდეს უკან, ციფრულ სივრცეში ხელმოწერებში")
    public void backButton() {

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .clickOnBackToRolesButton()
                .checkSigningRulesHeaders();


    }

    @Test(description = "[WPL-T8234]")
    @Story("Digital Services -> Pressing Signing Rules -> Pressing Edit with type Financial -> Visual")
    @Description("""
            In Singing rules there should be listed following information:
                          ძირითადი ინფორმაცია:
                          იუზერნეიმი
                          ლიმიტი თანხა
                          ვალუტა
                          ოპერაციის ტიპი
                          პროდუქტები:
                          ოპერაციის ტიპი(ები)
                          ხელმოწერა(ები)""")
    public void checkVisualOfElements_FinancialSigningRule() throws InterruptedException {

        String name = helper.getRandomString();
        int limitNumber = helper.getRandomNumber();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .addNewFinancialSigningRule(name, String.valueOf(limitNumber), "GEL", "Manage Loan Prepayment Application", "Director")
                .checkSuccessTextAfterChange()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnSignerRolesThreeDotsWithName(name)
                .clickOnViewSignerRole()
                .checkFinancialSignersHeaders()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnSignerRolesThreeDotsWithName(name)
                .clickOnDeleteSignerRole()
                .checkSuccessTextAfterChange();

    }

    @Test(description = "[WPL-T8324]")
    @Story("Digital Services -> Pressing Signing Rules -> Pressing Edit with type Non-Financial -> Visual")
    @Description("""
            In Singing rules there should be listed following information:
                                         ძირითადი ინფორმაცია:
                                         იუზერნეიმი
                                         ოპერაციის ტიპი
                                         პროდუქტები:
                                         ოპერაციის ტიპი(ები)
                                         ხელმოწერა(ები)""")
    public void checkVisualOfElements_NonFinancialSigningRule() throws InterruptedException {

        String name = helper.getRandomString();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .addNewNonFinancialSigningRule(name, "Manage Current Account Open", "Director")
                .checkSuccessTextAfterChange()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnSignerRolesThreeDotsWithName(name)
                .clickOnViewSignerRole()
                .checkNonFinancialSignersHeaders()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnSignerRolesThreeDotsWithName(name)
                .clickOnDeleteSignerRole()
                .checkSuccessTextAfterChange();

    }

    @Test(description = "[WPL-T8326]")
    @Story("Digital Services -> Pressing Signing Rules -> Pressing View")
    @Description("""
            If user presses View, user must be redirected to the next page but he mustnt be able to edit""")
    public void editingIsnotAvailableWhenPressingViewSigningRule() throws InterruptedException {

        String name = helper.getRandomString();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .addNewNonFinancialSigningRule(name, "Manage Current Account Open", "Director")
                .checkSuccessTextAfterChange()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnSignerRolesThreeDotsWithName(name)
                .clickOnViewSignerRole()
                .updateButtonIsnotAvailable()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnSignerRolesThreeDotsWithName(name)
                .clickOnDeleteSignerRole()
                .checkSuccessTextAfterChange();

    }

    @Test(description = "[WPL-T8235]")
    @Story("Digital Services -> Pressing Signing Rules -> \"ცვლილების\" ღილაკი")
    @Description("""
            ზედა მარჯვენა კუთხეში არის "შეცვლა" ღილაკი.
                                                       დავაჭიროთ შეცვლა ღილაკს და უნდა მოგვცეს ძირითადი ინფროამციის შეცვლის საშუალება. 
                                                       შევვალოთ ძირითადი ინფორმაცია და შევინახოთ, ვნახოთ რომ შეცვლილი ინფორმაცია შეინახა.""")
    public void editSigningRule() throws InterruptedException {

        String name = helper.getRandomString();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .addNewNonFinancialSigningRule(name, "Manage Current Account Open", "Director")
                .checkSuccessTextAfterChange()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnSignerRolesThreeDotsWithName(name)
                .clickOnEditOnSignerRolePage()
                .clickOnUpdateButtonInSigningRule();

        name = helper.getRandomString();

        signersSteps
                .updateSigningRuleName(name)
                .clickOnUpdateButton()
                .clickOnNextButton()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .checkIfSignerRuleExist(name)
                .hoverOnSignerRolesThreeDotsWithName(name)
                .clickOnDeleteSignerRole()
                .checkSuccessTextAfterChange();

    }

    @Test(description = "[WPL-T8325]")
    @Story("Digital Services -> Pressing Signing Rules -> Pressing Delete")
    @Description("If user chooses to delete a signing rule, the signing rule must be deleted")
    public void deleteSigningRule() throws InterruptedException {

        String name = helper.getRandomString();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .addNewNonFinancialSigningRule(name, "Manage Current Account Open", "Director")
                .checkSuccessTextAfterChange()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnSignerRolesThreeDotsWithName(name)
                .clickOnDeleteSignerRole()
                .checkSuccessTextAfterChange()
                .checkIfSigningRuleIsNotInList(name);

    }

    @Test(description = "[WPL-T8324]")
    @Story("Digital Services -> Pressing Signing Rules -> ოპერაციის ტიპი(ები) -> ოპერაციის დამატება")
    @Description("ოპერაციის დამატებაზე დავაჭიროთ, უნდა ამოვარდეს pop-up-ი და ავირჩიოთ სასურველი ოპერაციის ტიპი, მაგალითად ბუღალტერი და შევინახოთ, გადავამოწმოთ, რომ დამატებული ოპერაცია შეინახა")
    public void checkIfOperationIsAdded() throws InterruptedException {

        String operation = "Manage Current Account Open";

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .chooseNonFinancialOperationType()
                .chooseOperation(operation)
                .checkIfOperationIsAdded(operation);


    }

    @Test(description = "[WPL-T8238]")
    @Story("Digital Services -> Pressing Signing Rules -> ოპერაციის ტიპი(ები) -> წაშლა")
    @Description("ოპერაციების სია:\n" +
            "მოცემულია ის ოპერაციები რაც ამ ხელმოწერას გააჩნია. ოპერაციის მარჯვნივ 3 წერლიზე დაჭერისას და წაშლის არჩევისას უნდა მოგვცეს საშუალება წავშალოთ ოპერაცია")
    public void deleteOperationType() throws InterruptedException {

        String operation = "Manage Current Account Open";

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .chooseNonFinancialOperationType()
                .chooseOperation(operation)
                .hoverOnThreeDotsOnFirstSigningRule()
                .clickOnDeleteSignerRole()
                .checkIfOperationsIsEmpty();


    }

    @Test(description = "[WPL-T8240]")
    @Story("Digital Services -> Pressing Signing Rules -> ხელმოწერა(ები) -> წაშლა")
    @Description("ხელმოწერის სია:\n" +
            "მოცემულია ის ხელმოწერები რაც გააჩნია. ხელმოწერების მარჯვნივ 3 წერლიზე დაჭერისას და წაშლის არჩევისას უნდა მოგვცეს საშუალება წავშალოთ ოპერაცია")
    public void deleteSigners() throws InterruptedException {

        String signer = "Director";

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .chooseNonFinancialOperationType()
                .clickOnSigners()
                .chooseSigner(signer)
                .hoverOnThreeDotsOnFirstSigningRule()
                .clickOnDeleteSignerRole()
                .checkIfSignersIsEmpty();


    }

    @Test(description = "[WPL-T8244]")
    @Story("Digital Services -> Pressing Signing Rules -> ოპერაციის ტიპი(ები) -> ოპერაციის დამატება -> Available Buttons")
    @Description("""
            Pop-up-ს აქვს 2 ღილაკი, "გაუქმება" და "დამატება"
            გაუქმებაზე დაჭერით უნდა გაქრეს pop-up-ი და არ შეინახოს ცვლილება""")
    public void backButtonWhenAddingOperationType() throws InterruptedException {

        String operation = "Manage Current Account Open";

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .chooseNonFinancialOperationType()
                .chooseOperationWithoutSaving(operation)
                .clickOnQuitButton()
                .checkIfOperationsIsEmpty();

    }

    @Test(description = "[WPL-T8245]")
    @Story("Digital Services -> Pressing Signing Rules -> ხელმოწერა(ები) -> ხელმოწერის დამატება -> Available Buttons")
    @Description("Pop-up-ს აქვს 2 ღილაკი, \"გაუქმება\" და \"დამატება\"\n" +
            "გაუქმებაზე დაჭერით უნდა გაქრეს pop-up-ი და არ შეინახოს ცვლილება")
    public void backButtonWhenAddingSigners() throws InterruptedException {

        String signer = "Director";

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .clickOnSigners()
                .chooseSignerWithoutSaving(signer)
                .clickOnQuitButton()
                .checkIfSignersIsEmpty();


    }

    @Test(description = "[WPL-T8245]")
    @Story("Digital Services -> Pressing Signing Rules -> ხელმოწერა(ები) -> ხელმოწერის დამატება -> Visual")
    @Description("""
            there should be visible next information:
            "აირჩიე ხელმომწერი"
            user can choose more than 1 option and every next option will be listed below""")
    public void addMorethanOneSigner() throws InterruptedException {

        String[] signers = {"Director", "Trusted Person"};

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .clickOnSigners()
                .chooseMoreThanOneSigner(signers)
                .checkSelectedSigners(signers);

    }

    @Test(description = "[WPL-T8328]")
    @Story("Digital Services -> Pressing Signing Rules -> Pressing Edit with type Financial -> Pressing \"ცვლილება\" -> Changing to Non-Financial")
    @Description("""
            By changing Type all of the information in  "ოპერაციის ტიპი(ები)" and "ხელმოწერა(ები)" must get deleted automatically""")
    public void changingSigningRuleFromFinancialToNonFinancial() throws InterruptedException {

        String name = helper.getRandomString();
        int limitNumber = helper.getRandomNumber();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .addNewFinancialSigningRule(name, String.valueOf(limitNumber), "GEL", "Manage Loan Prepayment Application", "Director")
                .checkSuccessTextAfterChange()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnSignerRolesThreeDotsWithName(name)
                .clickOnEditOnSignerRolePage()
                .clickOnUpdateButtonInSigningRule()
                .selectOperationType("არაფინანსური")
                .clickOnUpdateButton()
                .checkIfOperationsIsEmpty()
                .clickOnSigners()
                .checkIfSignersIsEmpty()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        Thread.sleep(2000);
        signersSteps
                .hoverOnSignerRolesThreeDotsWithName(name)
                .clickOnDeleteSignerRole()
                .checkSuccessTextAfterChange();

    }

    @Test(description = "[WPL-T8242]")
    @Story("Digital Services -> Pressing Signing Rules -> Pressing Edit with type Non-Financial -> Pressing \"ცვლილება\" -> Changing to Financial")
    @Description("""
            By changing Type all of the information in  "ოპერაციის ტიპი(ები)" and "ხელმოწერა(ები)" must get deleted automatically""")
    public void changingSigningRuleFromNonFinancialToFinancial() throws InterruptedException {

        String name = helper.getRandomString();
        int limitNumber = helper.getRandomNumber();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .addNewNonFinancialSigningRule(name, "Manage Current Account Open", "Director")
                .checkSuccessTextAfterChange()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnSignerRolesThreeDotsWithName(name)
                .clickOnEditOnSignerRolePage()
                .clickOnUpdateButtonInSigningRule()
                .selectOperationType("ფინანსური")
                .enterLimitAmount(String.valueOf(limitNumber))
                .selectGelCurrency()
                .clickOnUpdateButton()
                .checkIfOperationsIsEmpty()
                .clickOnSigners()
                .checkIfSignersIsEmpty()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        Thread.sleep(2000);
        signersSteps
                .hoverOnSignerRolesThreeDotsWithName(name)
                .clickOnDeleteSignerRole()
                .checkSuccessTextAfterChange();


    }

}
