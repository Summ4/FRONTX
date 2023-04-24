package selenideWebTesting.pageObjects.searchPage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {

    public SelenideElement searchInput = $x("//input[@class='client__search-field ng-untouched ng-pristine ng-invalid']"),
    searchResult = $x("//div[@class='list-item client-type-1']");


}
