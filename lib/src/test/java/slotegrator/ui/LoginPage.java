package slotegrator.ui;

import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * PageObject for login page.
 */

@Component
@PropertySource("ui_data.properties")
public class LoginPage {

    // selectors to use in findElement method
    @Value("${login_input_id}")
    private String loginInput;

    @Value("${password_input_id}")
    private String passwordInput;

    @Value("${submit_btn_class}")
    private String submitButton;

    private WebDriver driver;

    @Autowired
    public LoginPage(DriverManager drvManager){
        this.driver = drvManager.driver();
    }

    public LoginPage(){}

    
    public  WebElement getLoginInput(){
        return this.driver.findElement(By.id(this.loginInput));
    }
    public  WebElement getPasswordInput(){
        return this.driver.findElement(By.id(passwordInput));
    }

    public  WebElement getSubmitBtn(){
        return this.driver.findElement(By.cssSelector(this.submitButton));
    }
}

