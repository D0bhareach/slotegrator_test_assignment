package slotegrator.ui;

/// import slotegrator.ui.Utils;
// import slotegrator.ui.ByType.*;
import java.util.Properties;
import slotegrator.PropertiesUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

/**
 * PageObject for login page.
 */

public class LoginPage {
    private Properties props;
    private WebDriver driver;

    public LoginPage(){
     Properties p = PropertiesUtil.loadProperties(this.getClass(), "/ui/data.properties");
        assert p != null : "LoginPage properties are null!";
     this.props = p;
     WebDriver d = Driver.getDriver();
        assert driver != null : "LoginPage WebDriver is null!";
     this.driver = d;
    }

    
    public Properties getProps(){
        return this.props;
    }
    public  WebElement getLoginInput(){
        return Utils.getWebElement(this.driver, this.props, "login_input_id", ByType.ID);
    }
    public  WebElement getPasswordInput(){
        return Utils.getWebElement(this.driver, this.props, "password_input_id", ByType.ID);

    }

    public  WebElement getSubmitBtn(){
        return Utils.getWebElement(
                this.driver, this.props, "submit_btn_class", ByType.CSS_SELECTOR);
    }
}

