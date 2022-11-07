package slotegrator.ui.step;

import slotegrator.ui.LoginPage;
import slotegrator.ui.PlayersPage;
import slotegrator.ui.DriverManager;
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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;

@PropertySource("ui_data.properties")
public class UiTests {


    // login elements
    private WebElement loginElmt;
    private WebElement passElmt;
    private WebElement submitElmt;


    private WebDriver driver;
    private DriverManager driverManager;
    private LoginPage loginPage;
    private PlayersPage playersPage;


    @Value("${url}")
    private String url;

    @Value("${login}")
    private String login;

    @Value("${password}")
    private String password;

    @Value("${admin_home_page}")
    private String adminHomePageUrl;

    @Value("${link_to_players}")
    private String playersPageUrl;

    @Autowired
    public UiTests(DriverManager dr, PlayersPage pp, LoginPage lgp){
        this.driverManager = dr;
        this.driver = dr.driver(); 
        this.playersPage = pp;
        this.loginPage = lgp;
    }

    @Given("can get login and password inputs")
    public void can_get_login_and_password_inputs() {
        // get to page
        assertNotNull(this.driver);
        assertNotNull(url);
        this.driver.get(url);
        this.loginElmt = loginPage.getLoginInput();
        this.passElmt = loginPage.getPasswordInput();
        this.submitElmt = loginPage.getSubmitBtn();
    }

    @When("enter login")
    public void enter_login() {
        assertNotNull(login);
        this.loginElmt.sendKeys(login);
    }

    @When("enter password")
    public void enter_password() {
        assertNotNull(password);
        this.passElmt.sendKeys(password);
    }

    @Then("submit credentials")
    public void submit_credentials() {
        this.submitElmt.click();
    }

    @Given("admin home page is current")
    public void admin_home_page_is_current() {
        String current_url  = this.driver.getCurrentUrl();
        assertNotNull(current_url);
        assertNotNull(adminHomePageUrl);
        assertEquals(current_url, adminHomePageUrl);
    }


    @Then("get to players page")
    public void get_to_players_page() {
        assertNotNull(playersPageUrl);
        this.driver.get(playersPageUrl);
    }

    // single player
    @Given("sort players by name")
    public void sort_players_by_name(DataTable table) {
        // make sure driver is on requred page.
        assertNotNull(playersPageUrl);
        String current_url  = this.driver.getCurrentUrl();
        assertEquals(current_url, playersPageUrl);

        List<List<String>> rows = table.asLists(String.class);
        String name = rows.get(0).get(0);
        assertNotNull(name);
        WebElement username = this.playersPage.getUserNameFld();
        assertNotNull(username);
        username.sendKeys(name);

        username.sendKeys(Keys.RETURN);
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
        this.driverManager.close();
    }
}
