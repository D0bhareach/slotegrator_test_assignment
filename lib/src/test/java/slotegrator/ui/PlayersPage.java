package slotegrator.ui;

import java.util.Properties;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;

@Component
@PropertySource("ui_data.properties")
public class PlayersPage {

    @Value("${plr_tbody_xpath}")
    private String tbodyXpath;

    @Value("${username_fld_xpath}")
    private String usernameFieldXpath;

    @Value("${plr_tbl_row_tormat}")
    private String tableRowsFormat;

    @Value("${plr_tr_xpath}")
    private String tableSingleRowXpath;

    @Value("${plr_tbl_row_cell_format}")
    private String tableRowsCellsFormat;

    @Value("${single_row_cell_format}")
    private String tableSingleRowCellsFormat;

    private WebDriver driver;

    @Autowired
    public PlayersPage(DriverManager driverManager){
        this.driver = driverManager.driver();

    }

    private WebElement getTableBody(){
        return this.driver.findElement(By.xpath(this.tbodyXpath));
    }



    // Rows id - row indexces in XPath
    // id less than zero will return single row.
    private  WebElement getTableRowById(int id){
        String path = null;
        if (id > 0) {
        path = String.format(tableRowsFormat, id);
        assert path !=null:"Path is null in PlayersPage:getTableRowById.";
        } else if(id < 0){
        // single row.
        path = this.tableSingleRowXpath;
        assert path !=null:"Single path is null in PlayersPage:getTableRowById.";
        }
        assert path !=null:"Before send to Utils path is null in PlayersPage:getTableRowById.";
        // must get table using driver not util method. Because xpath is created 
        // on the fly and not in properties.
        return this.driver.findElement(By.xpath(path));
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
        return this.driver.findElement(By.xpath(this.usernameFieldXpath));
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
            format = this.tableRowsCellsFormat;
            assert format !=null:"Format string is null id > 0 in PlayersPage:getPlayerDataByRowId";
        } else if(id < 0){
            format = this.tableSingleRowCellsFormat;
            assert format !=null:"Format string is null id < 0 in PlayersPage:getPlayerDataByRowId";
        }
        for (int i = 0; i < cells.length; i++) {
            if (id > 0){
                path = String.format(format, id, cells[i]);
            } else if (id < 0){
                path = String.format(format, cells[i]);
            }
            assert path !=null:"Path string is null in PlayersPage:getPlayerDataByRowId";
            WebElement cell = this.driver.findElement(By.xpath(path));
            String txt = cell.getText();
            res.add(i, txt);
        }
        return res;
    }

}
