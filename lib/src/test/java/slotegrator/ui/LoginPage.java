package slotegrator.ui;

/// import slotegrator.ui.Utils;
// import slotegrator.ui.ByType.*;
import java.util.Properties;
import slotegrator.PropertiesUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * PageObject for login page.
 */

@Component
public class LoginPage {

    @Autowired
    private Driver driverBldr;

    public LoginPage(){}
     private Properties props = PropertiesUtil.loadProperties(
             this.getClass(), "/ui/data.properties");

     // private WebDriver driver = driverBldr.getDriver();

    
    public  WebElement getLoginInput(){
        return Utils.getWebElement(this.driverBldr.getDriver(), this.props, "login_input_id", ByType.ID);
    }
    public  WebElement getPasswordInput(){
        return Utils.getWebElement(this.driverBldr.getDriver(), this.props, "password_input_id", ByType.ID);

    }

    public  WebElement getSubmitBtn(){
        return Utils.getWebElement(
                this.driverBldr.getDriver(), this.props, "submit_btn_class", ByType.CSS_SELECTOR);
    }
}

