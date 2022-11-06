package slotegrator.ui;

import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import java.lang.Exception;

public class Utils {


    public static WebElement getWebElement(
            WebDriver driver, Properties props, String propName, ByType type){
        String  selector = props.getProperty(propName);
        assert selector != null : propName + ": CSS Selector is null!";

        WebElement result = null;
        switch(type) {
            case ID:
                result =  driver.findElement(By.id(selector));
                break;
            case CLASS:
                result =  driver.findElement(By.className(selector));
                break;
            case NAME:
                result =  driver.findElement(By.name(selector));
                break;
            case CSS_SELECTOR:
                result =  driver.findElement(By.cssSelector(selector));
                break;
            case XPATH:
                result =  driver.findElement(By.xpath(selector));
                break;
            default:
                try{
                throw new Exception("Unknown ByType in Utils getWebElement method.");

                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        return result;
        
    }

}
