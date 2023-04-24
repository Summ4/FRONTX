package selenideWebTesting.stepObjects.loginpageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import selenideWebTesting.pageObjects.loginPage.LoginPage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static selenideWebTesting.dataObjects.UserData.longWaiter;

import java.time.Duration;

public class LoginPageSteps extends LoginPage {

    @Step
    public LoginPageSteps userNameInput(String username) {
        userNameInput.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        userNameInput.sendKeys(username);

        return this;
    }

    @Step
    public LoginPageSteps passwordInput(String password) {
        passwordInput.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        passwordInput.sendKeys(password);

        return this;
    }

    @Step
    public LoginPageSteps clickOnLoginButton() {
        loginButton.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));
        loginButton.click();

        return this;
    }

    @Step("login by using username :{0} and password : {1}")
    public LoginPageSteps logginIntoSystem(String username, String password) {

        loginButton.shouldBe(visible, Duration.ofMillis(longWaiter));
        logIntoSystemHeader.shouldBe(visible,Duration.ofMillis(longWaiter));

        userNameInput.shouldBe(enabled);
        userNameInput.shouldBe(enabled);
        passwordInput.shouldBe(enabled);
        passwordInput.setValue(password);
        loginButton.shouldBe(visible, Duration.ofMillis(longWaiter));
        loginButton.click();

        return this;
    }

    @Step
    public LoginPageSteps checkIfLoginWasSuccessfull(){

        searchInput.shouldBe(Condition.visible, Duration.ofMillis(longWaiter));

        return this;

    }

}
