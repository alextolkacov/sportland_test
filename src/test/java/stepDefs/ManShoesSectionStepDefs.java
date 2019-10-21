package stepDefs;

import baseFunc.BaseFunc;
import baseFunc.Helper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import webPages.HomePage;
import webPages.MenFootballShoesPage;
import webPages.ProductsPage;
;import java.io.IOException;
import java.util.List;

public class ManShoesSectionStepDefs {
    private BaseFunc basefunc = new BaseFunc();
    private Helper helper = new Helper(basefunc);
    private HomePage homePage;
    private ProductsPage productsPage;
    private MenFootballShoesPage menFootballShoesPage;

    @Given("open {string} link")
    public void open_page(String url) {
        basefunc.openPage(url);
        homePage = new HomePage(basefunc);
    }

    @When("push menu")
    public void push_menu() {
        helper.pushHamburger_BTN();
    }

    @When("choose {string} section")
    public void select_section(String sectionName) {
        helper.selectMenuSection(sectionName);
    }

    @When("select {string} under {string} section in {string} tab")
    public void click_futbol(String section, String category, String gender) {
        productsPage = new ProductsPage(basefunc);
        productsPage.selectProductSection(section, category, gender);
    }

    @When("sort products by {string}")
    public void choose_sorting_method(String method) {
        menFootballShoesPage = new MenFootballShoesPage(basefunc);
        menFootballShoesPage.selectSortingMethod(method);
    }

    @When("select filters:")
    public void select_filters(List<String> filterNames) {
        menFootballShoesPage.selectFilters(filterNames);
    }

    @Then("on page appeared only {string} brand shoes")
    public void check_filtered_brand(String brand) {
        helper.checkBrand(brand);
    }

    @Then("all products are on sale")
    public void check_products_sale() {
        helper.checkSale();
    }

    @Then("create txt file with with info about products")
    public void create_txt_file() throws IOException {
        menFootballShoesPage.collectInformationTxt();
    }

    @Then("create json file with the same information")
    public void create_json_file() {
        menFootballShoesPage.createJsonFile();
    }

    @Then("close browser")
    public void close_browser() {
        basefunc.closeBrowser();
    }
}
