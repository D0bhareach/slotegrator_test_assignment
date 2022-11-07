package slotegrator.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.lang.Process;
import java.lang.ProcessBuilder;
import java.util.concurrent.TimeUnit;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.PropertySource;

/**
 * Seleniumn Web Driver's Manager Bean.
 * Driver create, obtain, destroy related settings and methods.
 */

@Component
@PropertySource("ui_data.properties")
@PropertySource("driver.properties")
public class DriverManager{

    // cache
    private WebDriver driver = null;

    @Value("${app_profile}")
    private String app_profile;

    @Value("${firefox_profile_path}")
    private String firefox_profile_path;

    @Value("${geckodriver_exec}")
    private String geckodriver_exec;

    public DriverManager(){}
 

    public  WebDriver driver(){
        if (this.driver != null) {
            return this.driver;
        }
        System.setProperty("webdriver.gecko.driver", geckodriver_exec);
        FirefoxOptions opt = new FirefoxOptions();
        
        if (app_profile.equals("dev")) {
        opt.addArguments("start-maximazed");
        } else {
            opt.setHeadless(true);
        }

        opt.addArguments("--profile", firefox_profile_path);

        // two lines to prevent: Invalid browser preferences for CDP. ERROR.
        opt.addPreference("fission.webContentIsolationStrategy", 0);
        opt.addPreference("fission.bfcacheInParent", false);

        WebDriver driver = new FirefoxDriver(opt);
        this.driver = driver;
        return driver;
    }

    /** Because we run on single thread it's practical to keep instance of application
     * running for us. So I would call this method right at the end of  test's chain.
     */
    public void close(){
        if (driver == null) return;

        driver.manage().deleteAllCookies();
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.close();
        // update cache otherwise it's a threat to get a stale pointer later.
        driver = null;
        String[] cli_args = new String[] {"/bin/bash", "-c", "pkill -f geckodriver"};
        try{
        Process proc = new ProcessBuilder(cli_args).start();
        proc.waitFor(1000, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                    e.printStackTrace();
            }
    }

}
