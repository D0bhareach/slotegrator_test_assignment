package slotegrator.ui;

import java.util.Properties;
import slotegrator.PropertiesUtil;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class PlayersPage {
    private Properties props;
    private WebDriver driver;

    public PlayersPage(){
     Properties p = PropertiesUtil.loadProperties(this.getClass(), "/ui/data.properties");
        assert p != null : "LoginPage properties are null!";
     this.props = p;
     WebDriver d = Driver.getDriver();
        assert driver != null : "LoginPage WebDriver is null!";
     this.driver = d;
    }

    private WebElement getTable(){
        return Utils.getWebElement(
                this.driver, this.props, "plr_table_xpath", ByType.XPATH);
    }
    private WebElement getTableBody(){
        return Utils.getWebElement(
                this.driver, this.props, "plr_tbody_xpath", ByType.XPATH);
    }



    // Rows id - row indexces in XPath
    // id less than zero will return single row.
    private  WebElement getTableRowById(int id){
        String path = null;
        if (id > 0) {
        String format = this.props.getProperty("plr_tbl_row_tormat");
        path = String.format(format, id);
        assert path !=null:"Path is null in PlayersPage:getTableRowById.";
        } else if(id < 0){
        // single row.
        path = this.props.getProperty("plr_tr_xpath");
        assert path !=null:"Single path is null in PlayersPage:getTableRowById.";
        }
        assert path !=null:"Before send to Utils path is null in PlayersPage:getTableRowById.";
        // must get table using driver not util method. Because xpath is created 
        // on the fly and not in properties.
        // TODO: Change Util method? Keep an eye on this!!!
        return this.driver.findElement(By.xpath(path));
    }

    // public api
    public WebElement getVerifiedOption(){
        return Utils.getWebElement(
                this.driver, this.props, "verified_opt_selector", ByType.CSS_SELECTOR);
    }

    public WebElement getActiveOption(){
        return Utils.getWebElement(
                this.driver, this.props, "active_opt_selector", ByType.CSS_SELECTOR);
    }

    public int getPlrTableRowQuantity(){
        WebElement t_body = this.getTableBody();
        List<WebElement> l = this.driver.findElements(By.tagName("tr"));
        return l.size();
    }

    /**
     * When there is only one player get, that row from players table by xpath
     */

    public WebElement getUserNameFld(){
        return Utils.getWebElement(
                this.driver, this.props, "username_fld_xpath", ByType.XPATH);
    }

    // xpath for single and xpath for first of many are the same and having index 1
    public  List<String> getPlayerDataByRowId(int id){
        // username, external id, email
        int[] cells = {2, 3, 6};
        int len = cells.length;
        List<String> res = new ArrayList<>(len);
        WebElement row = this.getTableRowById(id);
        String format = null;
        String path = null;
        // row and td interpolation string when many rows
        if(id > 0){
            format = this.props.getProperty("plr_tbl_row_cell_format");
            assert format !=null:"Format string is null id > 0 in PlayersPage:getPlayerDataByRowId";
        } else if(id < 0){
            format = this.props.getProperty("single_row_cell_format");
            assert format !=null:"Format string is null id < 0 in PlayersPage:getPlayerDataByRowId";
        }
        for (int i = 0; i < cells.length; i++) {
            if (id > 0){
                path = String.format(format, id, cells[i]);
            } else if (id < 0){
                path = String.format(format, cells[i]);
            }
            assert format !=null:"Path string is null in PlayersPage:getPlayerDataByRowId";
            WebElement cell = this.driver.findElement(By.xpath(path));
            String txt = cell.getText();
            res.add(i, txt);
        }
        return res;
    }

}
