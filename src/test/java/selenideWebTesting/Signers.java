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
                .checkSuccessText()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnThreeDotsWithName(name)
                .clickOnViewSignerRole()
                .checkFinancialSignersHeaders()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnThreeDotsWithName(name)
                .clickOnDeleteSignerRole()
                .checkSuccessText();

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
                .checkSuccessText()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnThreeDotsWithName(name)
                .clickOnViewSignerRole()
                .checkNonFinancialSignersHeaders()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnThreeDotsWithName(name)
                .clickOnDeleteSignerRole()
                .checkSuccessText();

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
                .checkSuccessText()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnThreeDotsWithName(name)
                .clickOnViewSignerRole()
                .updateButtonIsnotAvailable()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnThreeDotsWithName(name)
                .clickOnDeleteSignerRole()
                .checkSuccessText();

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
                .checkSuccessText()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnThreeDotsWithName(name)
                .clickOnEditOnSignerRolePage()
                .clickOnUpdateButtonInSigningRule();

        name = helper.getRandomString();

        signersSteps
                .updateSigningRuleName(name)
                .clickOnUpdateButton()
                .clickOnNextButton()
                .checkSuccessText()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        Thread.sleep(2000);
        signersSteps
                .checkIfSignerRuleExist(name)
                .hoverOnThreeDotsWithName(name)
                .clickOnDeleteSignerRole()
                .checkSuccessText();

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
                .checkSuccessText()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnThreeDotsWithName(name)
                .clickOnDeleteSignerRole()
                .checkSuccessText()
                .checkIfSigningRuleIsNotInList(name);

    }

    @Test(description = "[WPL-T8239]")
    @Story("Digital Services -> Pressing Edit Signing Rules -> ოპერაციის ტიპი(ები) -> ოპერაციის დამატება")
    @Description("ოპერაციის დამატებაზე დავაჭიროთ, უნდა ამოვარდეს pop-up-ი და ავირჩიოთ სასურველი ოპერაციის ტიპი, მაგალითად ბუღალტერი და შევინახოთ, გადავამოწმოთ, რომ დამატებული ოპერაცია შეინახა")
    public void checkIfOperationIsAdded() throws InterruptedException {

        String operation1 = "Manage Current Account Open";
        String operation2 = "Manage Subscription Application";
        String[] operations = {operation1, operation2};

        String name = helper.getRandomString();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .addNewNonFinancialSigningRule(name, operation1, "Director")
                .checkSuccessText()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnThreeDotsWithName(name)
                .clickOnEditOnSignerRolePage()
                .chooseOperation(operation2)
                .checkSelectedOperations(operations)
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnThreeDotsWithName(name)
                .clickOnDeleteSignerRole()
                .checkSuccessText();


    }

    @Test(description = "[WPL-T8238]")
    @Story("Digital Services -> Pressing Signing Rules -> ოპერაციის ტიპი(ები) -> წაშლა")
    @Description("ოპერაციების სია:\n" +
            "მოცემულია ის ოპერაციები რაც ამ ხელმოწერას გააჩნია. ოპერაციის მარჯვნივ 3 წერლიზე დაჭერისას და წაშლის არჩევისას უნდა მოგვცეს საშუალება წავშალოთ ოპერაცია")
    public void deleteOperationType() throws InterruptedException {

        String name = helper.getRandomString();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .addNewNonFinancialSigningRule(name, "Manage Current Account Open", "Director")
                .checkSuccessText()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnThreeDotsWithName(name)
                .clickOnEditOnSignerRolePage()
                .clickOnSigners()
                .hoverOnFirstThreeDots()
                .clickOnDeleteSignerRole()
                .checkIfOperationsIsEmpty();

    }

    @Test(description = "[WPL-T8244]")
    @Story("Digital Services -> Pressing Edit Signing Rules -> ოპერაციის ტიპი(ები) -> ოპერაციის დამატება -> Available Buttons")
    @Description("""
            Pop-up-ს აქვს 2 ღილაკი, "გაუქმება" და "დამატება"
            გაუქმებაზე დაჭერით უნდა გაქრეს pop-up-ი და არ შეინახოს ცვლილება""")
    public void editSigningRule_backButtonWhenAddingOperationType() throws InterruptedException {

        String name = helper.getRandomString();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .addNewNonFinancialSigningRule(name, "Manage Current Account Open", "Director")
                .checkSuccessText()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnThreeDotsWithName(name)
                .clickOnEditOnSignerRolePage()
                .clickOnSigners()
                .hoverOnFirstThreeDots()
                .clickOnDeleteSignerRole()
                .chooseSignerWithoutSaving("Director")
                .clickOnQuitButton()
                .checkIfSignersIsEmpty()
                .clickOnBackButton()
                .hoverOnThreeDotsWithName(name)
                .clickOnDeleteSignerRole();

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

        String name = helper.getRandomString();
        String signer1 = "Director";
        String signer2 = "Trusted Person";
        String[] signers = {signer1, signer2};
        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .addNewNonFinancialSigningRule(name, "Manage Current Account Open", signer1)
                .checkSuccessText()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnThreeDotsWithName(name)
                .clickOnEditOnSignerRolePage()
                .clickOnSigners()
                .chooseSigner(signer2)
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
                .checkSuccessText()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnThreeDotsWithName(name)
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

        signersSteps
                .hoverOnThreeDotsWithName(name)
                .clickOnDeleteSignerRole()
                .checkSuccessText();

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
                .checkSuccessText()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnThreeDotsWithName(name)
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

        signersSteps
                .hoverOnThreeDotsWithName(name)
                .clickOnDeleteSignerRole()
                .checkSuccessText();


    }

    @Test(description = "[WPL-T8330]")
    @Story("Digital Services -> Signers -> Pressing Add Signing Rule -> Visual")
    @Description("""
            By pressing Add singing Rule user will be redirected to a new page where is the following information:
            "<- ხელმოწერის შექმნა" this will redirect user to the previous page ("ხელმომწერები")
            "ოპერაციის ტიპი"
            "სახელი"
            "პროდუქტები:
            ოპერაციის ტიპი(ები)
            ხელმოწერა(ები)
            "უკან" this will redirect user to the previous page ("ხელმომწერები")
            "შენახვა" this will save all changes""")
    public void checkButtonsSigningRuleBPage() {

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .checkButtonsOnAddNewSigningRulePage();

    }

    @Test(description = "[WPL-T8330]")
    @Story("Digital Services -> Signers -> Pressing Add Signing Rule -> ოპერაციის ტიპი Сhoosing Financial")
    @Description("""
            if user chooses Financial in operation type, two new tabs will show up:
            ლიმიტი
            ვალუტა""")
    public void checkNewTabsWhenChoosingFinancialOperationType() {

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .clickOnOperationTypeDropDown()
                .selectOperationTypeFinancial()
                .checkIfLimitsAndCurrencyLabelsAreVisibleWhenChoosingFinancialOperationType();

    }

    @Test(description = "[WPL-T8331]")
    @Story("Digital Services -> Signers -> Pressing Add Signing Rule -> ოპერაციის ტიპი Сhoosing Non-Financial")
    @Description("""
            no new tabs will be added""")
    public void checkThatNoNewTabsIsDisplayedWhenChoosingNonFinancialOperationType() {

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .clickOnOperationTypeDropDown()
                .selectOperationTypeNonFinancial()
                .checkLimitsAndCurrencyLabelsIsnotVisibleWhenChoosingNonFinancialOperationType();

    }

    @Test(description = "[WPL-T8333]")
    @Story("Digital Services -> Signers -> Pressing Add Signing Rule -> ხელმოწერა(ები) -> ხელმოწერის დამატება -> Available Buttons")
    @Description("""
            Pop-up-ს აქვს 2 ღილაკი, "გაუქმება" და "დამატება"
                                     გაუქმებაზე დაჭერით უნდა გაქრეს pop-up-ი და არ შეინახოს ცვლილება
                                     დამატებაზე დაჭერისას არსებული ცვლილება უნდა შეინახოს და გაქრესპოპ-აპი""")
    public void checkIfWeGetBackToSigningRulesPageWhenClickingOnBackButtonOnAddSigningRulePage() {

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .clickOnBackButton()
                .checkSigningRulesHeaders();

    }

    @Test(description = "[WPL-T8240]")
    @Story("Digital Services -> Pressing Edit Signing Rules -> ხელმოწერა(ები) -> წაშლა")
    @Description("""
            ხელმოწერის სია:
            ოცემულია ის ხელმოწერები რაც გააჩნია. ხელმოწერების მარჯვნივ 3 წერლიზე დაჭერისას და წაშლის არჩევისას უნდა მოგვცეს საშუალება წავშალოთ ოპერაცია""")
    public void checkDeleteButtonWhenHoveringOnSignersWhileEditingSigningRule() throws InterruptedException {

        String name = helper.getRandomString();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .addNewNonFinancialSigningRule(name, "Manage Current Account Open", "Director")
                .checkSuccessText()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnThreeDotsWithName(name)
                .clickOnEditOnSignerRolePage()
                .clickOnSigners()
                .hoverOnFirstThreeDots()
                .clickOnDeleteSignerRole()
                .checkIfSignersIsEmpty()
                .clickOnBackButton();

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();

        signersSteps
                .hoverOnThreeDotsWithName(name)
                .clickOnDeleteSignerRole()
                .checkSuccessText();

    }

    @Test(description = "[WPL-T8334]")
    @Story("Digital Services -> Signers -> Pressing Add Signing Rule -> ხელმოწერა(ები) -> წაშლა")
    @Description("""
            ხელმოწერის სია:
            ოცემულია ის ხელმოწერები რაც გააჩნია. ხელმოწერების მარჯვნივ 3 წერლიზე დაჭერისას და წაშლის არჩევისას უნდა მოგვცეს საშუალება წავშალოთ ოპერაცია""")
    public void createSigningRule_checkDeleteButtonWhenHoveringOnSigners() throws InterruptedException {

        String signer = "Director";

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .clickOnSigners()
                .chooseSigner(signer)
                .hoverOnFirstThreeDots()
                .clickOnDeleteSignerRole()
                .checkIfSignersIsEmpty();

    }

    @Test(description = "[WPL-T8245]")
    @Story("Digital Services -> Signers -> Pressing Add Signing Rule -> ხელმოწერა(ები) -> ხელმოწერის დამატება -> Visual")
    @Description("""
            there should be visible next information:
            "აირჩიე ხელმომწერი"
            user can choose more than 1 option and every next option will be listed below""")
    public void selectMorethanOneSignerWhenCreatingSigningRule() throws InterruptedException {

        String[] signers = {"Director", "Trusted Person"};

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .clickOnSigners()
                .chooseMoreThanOneSigner(signers)
                .checkSelectedSigners(signers);

    }

    @Test(description = "[WPL-T8336]")
    @Story("Digital Services -> Signers -> Pressing Add Signing Rule -> ოპერაციის ტიპი(ები) -> წაშლა")
    @Description("ოპერაციების სია:\n" +
            "მოცემულია ის ოპერაციები რაც ამ ხელმოწერას გააჩნია. ოპერაციის მარჯვნივ 3 წერლიზე დაჭერისას და წაშლის არჩევისას უნდა მოგვცეს საშუალება წავშალოთ ოპერაცია")
    public void deleteOperationTypeWhenCreatingSigningRule() throws InterruptedException {

        String operation = "Manage Current Account Open";

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .chooseNonFinancialOperationType()
                .chooseOperation(operation)
                .hoverOnFirstThreeDots()
                .clickOnDeleteSignerRole()
                .checkIfOperationsIsEmpty();

    }

    @Test(description = "[WPL-T8336]")
    @Story("Digital Services -> Signers -> Pressing Add Signing Rule -> ოპერაციის ტიპი(ები) -> ოპერაციის დამატება -> Available Buttons")
    @Description("Pop-up-ს აქვს 2 ღილაკი, \"გაუქმება\" და \"დამატება\"\n" +
            "გაუქმებაზე დაჭერით უნდა გაქრეს pop-up-ი და არ შეინახოს ცვლილება")
    public void createSigningRule_backButtonWhenAddingOperationType() throws InterruptedException {

        String operation = "Manage Current Account Open";

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .chooseOperationWithoutSaving(operation)
                .clickOnQuitButton()
                .checkIfOperationsIsEmpty();

    }

    @Test(description = "[WPL-T8338]")
    @Story("Digital Services -> Signers -> Pressing Add Signing Rule -> ოპერაციის ტიპი(ები) -> ოპერაციის დამატება")
    @Description("ოპერაციის დამატებაზე დავაჭიროთ, უნდა ამოვარდეს pop-up-ი და ავირჩიოთ სასურველი ოპერაციის ტიპი, " +
            "მაგალითად ბუღალტერი და შევინახოთ, გადავამოწმოთ, რომ დამატებული ოპერაცია შეინახა")
    public void createSigningRule_AddOperation() throws InterruptedException {

        String operation = "Manage Current Account Open";

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .chooseOperation(operation)
                .clickOnNextButton()
                .checkIfOperationIsAdded(operation);

    }

    @Test(description = "[WPL-T8339]")
    @Story("Digital Services -> Signers -> Pressing Add Signing Rule -> User added Signers and Operation Types and wants to change Type from Financial to Non-Financial")
    @Description("""
            By changing Type all of the information in  "ოპერაციის ტიპი(ები)" and "ხელმოწერა(ები)" must get deleted automatically""")
    public void changingSigningRuleFromFinancialToNonFinancialWhenCreateingNewSigningRule() throws InterruptedException {

        String operation = "Manage Current Account Open";
        String director = "Director";

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .clickOnOperationTypeDropDown()
                .selectOperationTypeFinancial()
                .chooseOperation(operation)
                .clickOnSigners()
                .chooseSigner(director)
                .clickOnOperationTypeDropDown()
                .selectOperationTypeNonFinancial()
                .checkIfOperationsIsEmpty()
                .clickOnSigners()
                .checkIfSignersIsEmpty();

    }

    @Test(description = "[WPL-T8339]")
    @Story("Digital Services -> Signers -> Pressing Add Signing Rule -> User added Signers and Operation Types and wants to change Type from Non-Financial to Financial")
    @Description("""
            By changing Type all of the information in  "ოპერაციის ტიპი(ები)" and "ხელმოწერა(ები)" must get deleted automatically""")
    public void changingSigningRuleFromNonFinancialToFinancialWhenCreateingNewSigningRule() throws InterruptedException {

        String operation = "Manage Current Account Open";
        String director = "Director";

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .clickOnOperationTypeDropDown()
                .selectOperationTypeNonFinancial()
                .chooseOperation(operation)
                .clickOnSigners()
                .chooseSigner(director)
                .clickOnOperationTypeDropDown()
                .selectOperationTypeFinancial()
                .checkIfOperationsIsEmpty()
                .clickOnSigners()
                .checkIfSignersIsEmpty();

    }

    @Test(description = "[WPL-T8332]")
    @Story("Digital Services -> Signers -> Pressing Add Signing Rule -> Mandatory Tabs")
    @Description("""
            All of the following tabs are mandatory to be filled in:
            ოპერაციის ტიპი
            თანხა (will appear if chosen financial in operation type)
            ვალუტა (will appear if chosen financial in operation type)
            სახელი
            ოპერაციის ტაბი(ები)
            ხელმოწერა(ები)
            """)
    public void notFillingAnySigningRulesTab() {

        digitalServicesPageSteps
                .clickOnSigningRulesHeader();
        signersSteps
                .clickOnAddSigningRulesButton()
                .clickOnNextButton()
                .checkErrorForNotFillingAnySigningRulesTab()
                .closePopUp();

    }

}
