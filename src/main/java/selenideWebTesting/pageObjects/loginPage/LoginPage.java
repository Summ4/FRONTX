package selenideWebTesting.pageObjects.loginPage;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    public SelenideElement
            userNameInput = $(By.id("Username")),
            passwordInput = $(By.id("Password")),
            loginButton = $(By.id("btnSubmit")),
            logIntoSystemHeader = $(new ByText("TBCFrontX სისტემაში შესვლა")),
            searchInput = $x("//input[@class='client__search-field ng-untouched ng-pristine ng-invalid']");


}
