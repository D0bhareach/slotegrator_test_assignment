package slotegrator.ui.step;

import slotegrator.PropertiesUtil;
import slotegrator.ui.LoginPage;
import slotegrator.ui.PlayersPage;
import slotegrator.ui.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import java.util.Properties;
import java.util.List;
// import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class UiTests {


    // login elements
    private WebElement login;
    private WebElement pass;
    private WebElement submit;


    private LoginPage loginPage;
    private PlayersPage playersPage;
    private Properties props;

    private WebDriver driver;

    public UiTests() {
    
        loginPage = new LoginPage();
        playersPage = new PlayersPage();
        props = PropertiesUtil.loadProperties(getClass(), "/ui/data.properties");
        driver = Driver.getDriver();
    }

    @Given("can get login and password inputs")
    public void can_get_login_and_password_inputs() {
        // get to page
        assertNotNull(this.driver);
        // get to login page.
        String url = this.props.getProperty("url");
        assertNotNull(url);
        this.driver.get(url);
        this.login = loginPage.getLoginInput();
        this.pass = loginPage.getPasswordInput();
        this.submit = loginPage.getSubmitBtn();
    }

    @When("enter login")
    public void enter_login() {
        String login_txt = this.props.getProperty("login");
        assertNotNull(login_txt);
        this.login.sendKeys(login_txt);
    }

    @When("enter password")
    public void enter_password() {
        String pass_txt = this.props.getProperty("password");
        assertNotNull(pass_txt);
        this.pass.sendKeys(pass_txt);
    }

    @Then("submit credentials")
    public void submit_credentials() {
        this.submit.click();
    }

    @Given("admin home page is current")
    public void admin_home_page_is_current() {
        String current_url  = this.driver.getCurrentUrl();
        assertNotNull(current_url);
        String expected_url = this.props.getProperty("admin_home_page");
        assertNotNull(expected_url);
        assertEquals(current_url, expected_url);
    }


    @Then("get to players page")
    public void get_to_players_page() {
        String url = this.props.getProperty("link_to_players");
        assertNotNull(url);
        this.driver.get(url);
    }

    // after this is crup
    @Given("driver on players page")
    public void driver_on_players_page() {
        // make sure driver is on requred page.
        String url = this.props.getProperty("link_to_players");
        assertNotNull(url);
        String current_url  = this.driver.getCurrentUrl();
        assertEquals(current_url, url);
    }

    @When("number of rows more then one")
    public void select_first_option() {
        // get rows make sure bigger than one
        int len = this.playersPage.getPlrTableRowQuantity();
        assertTrue(len > 1);
    }

    @Then("compare several players")
    public void compare_several_players(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);
    
        for (int i = 1; i <= rows.size(); i++) {
            List<String> row = rows.get(i);
            List<String> actual = this.playersPage.getPlayerDataByRowId(i);
            assertTrue(actual.equals(row));
        }

    }

    // single player
    @Given("sort players by name")
    public void sort_players_by_name(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);
        String name = rows.get(0).get(0);
        assertNotNull(name);
        WebElement username = this.playersPage.getUserNameFld();
        assertNotNull(username);
        username.sendKeys(name);

        username.sendKeys(Keys.RETURN);
        // this. driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
    }

    @When("only one player")
    public void only_one_player() {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){

        }
        int len = this.playersPage.getPlrTableRowQuantity();
        assertTrue(len == 3, String.format("UiTest:only_one_player len:%d.",len));
    }

    @Then("get player and compare")
    public void get_player_and_compare(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);
    
            List<String> row = rows.get(0);
            List<String> actual = this.playersPage.getPlayerDataByRowId(-1);
            assertTrue(actual.equals(row));
    }

    // full Cucumber to be JUnit, and do @AfterAll
    // ugly, but otherwise will need to use static and I'm too lazy.
    @Given("clean context")
    public void clean_context() {
        Driver.closeDriver();
    }
}
