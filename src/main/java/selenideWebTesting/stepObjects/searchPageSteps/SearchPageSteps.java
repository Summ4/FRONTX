package selenideWebTesting.stepObjects.searchPageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import selenideWebTesting.pageObjects.searchPage.SearchPage;

import java.time.Duration;

import static selenideWebTesting.dataObjects.UserData.longWaiter;

public class SearchPageSteps extends SearchPage {

    @Step
    public SearchPageSteps checkIfLoginWasSuccessfull(){

        searchInput.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));

        return this;

    }

    @Step
    public SearchPageSteps inputUserInSearch(String user){

        searchInput.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        searchInput.setValue(user);

        return this;

    }

    @Step
    public SearchPageSteps clickOnFirstResult(){

        searchResult.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        searchResult.click();

        return this;

    }




}
