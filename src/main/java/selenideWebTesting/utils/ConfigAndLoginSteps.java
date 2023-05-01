package selenideWebTesting.utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import selenideWebTesting.dataObjects.UrlData;
import selenideWebTesting.stepObjects.digitalServicesPageSteps.DigitalServicesPageSteps;
import selenideWebTesting.stepObjects.loginpageSteps.LoginPageSteps;
import selenideWebTesting.stepObjects.searchPageSteps.SearchPageSteps;

import java.sql.SQLException;
import java.util.Collections;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.open;
import static selenideWebTesting.dataObjects.UserData.password;
import static selenideWebTesting.dataObjects.UserData.userName;

public class ConfigAndLoginSteps {

    UrlData urlData = new UrlData();
    LoginPageSteps loginPageSteps = new LoginPageSteps();
    SearchPageSteps searchPageSteps = new SearchPageSteps();
    DigitalServicesPageSteps digitalServicesPageSteps = new DigitalServicesPageSteps();

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws SQLException {

        RestAssured.useRelaxedHTTPSValidation();
//        WebDriverManager.chromedriver().proxy("192.168.100.49:3128").setup();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("incognito");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-features=UserAgentClientHint");
        options.setAcceptInsecureCerts(true);
        options.addArguments("start-maximized");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        timeout = 9000;
        browser = "chrome";
        browserSize = "3440x1440";
        downloadsFolder = "src\\main\\downloads";
        headless = false;
        browserCapabilities = options;
        fastSetValue = true;

    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {

        Selenide.open(urlData.BaseUrl);

        SleepingSteps.stopAction(3);
//        ZephyrConfiguration.projectKey = "WPL";
//        ZephyrConfiguration.jiraToken = secrets.getSecret("Token", "/testauto/data/testautocommon/JiraUser");
    }

    @BeforeMethod(alwaysRun = true)
    public void before(ITestResult result) throws SQLException, InterruptedException {
        reopenBrowserOnFail = true;

        Selenide.sleep(5000);
        boolean loginPage = WebDriverRunner.url().contains("/TBCIdentityServerTest/connect/");
        boolean searchPage = WebDriverRunner.url().contains("/main/search");

        try {
            Selenide.open(urlData.BaseUrl);
        } catch (IllegalStateException | ElementClickInterceptedException | TimeoutException |
                 NoSuchWindowException ex) {
            beforeSuite();
            open(urlData.BaseUrl);
            selenideWebTesting.utils.SleepingSteps.stopAction(3);
        }
        Selenide.sleep(2000);
        if (loginPageSteps.checkIfUserIsOnLoginPage())
            loginPageSteps
                    .logginIntoSystem(userName, password);

        searchPageSteps
                .inputUserInSearch("791");
//                .clickOnFirstResult();
        digitalServicesPageSteps
                .clickOnDigitalServices()
                .checkDigitalServicesHeadersWhenUserIsCorporate();


    }

    @Step
    public void beforeStepForRetailUsers(String user) {

        loginPageSteps
                .clickOnLogo();
        searchPageSteps
                .inputUserInSearch(user);
        digitalServicesPageSteps
                .clickOnDigitalServices()
                .checkDigitalServicesHeadersWhenUserIsRetail();

    }



}
