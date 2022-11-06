package slotegrator.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.lang.Process;
import java.lang.ProcessBuilder;
import java.util.concurrent.TimeUnit;

import java.util.Properties;
import slotegrator.PropertiesUtil;

/**
 * Seleniumn Web Driver's related settings and creation.
 * Keep it simple and build just one driver - FirefoxDriver
 *
 *
*/

public class Driver{

    private static WebDriver driver = null;
 

    public static WebDriver getDriver(){
        if (Driver.driver != null) {
            return Driver.driver;
        }
        Properties props = PropertiesUtil.loadProperties(
                Driver.class, "/ui/driver.properties");
        System.setProperty("webdriver.gecko.driver", props.getProperty("geckodriver_exec"));
        FirefoxOptions opt = new FirefoxOptions();
        
        String app_profile = props.getProperty("app_profile");
        if (app_profile.equals("dev")) {
        // opt.addArguments("start-maximazed");
        } else {
            opt.setHeadless(true);
        }

        opt.addArguments(
                "--profile", props.getProperty("firefox_profile_path"));

        // two lines to prevent: Invalid browser preferences for CDP. ERROR.
        opt.addPreference("fission.webContentIsolationStrategy", 0);
        opt.addPreference("fission.bfcacheInParent", false);

        WebDriver driver = new FirefoxDriver(opt);
        Driver.driver = driver;
        return driver;
    }

    /** Because we run on single thread it's practical to keep instance of application
     * running for us. So I would call this method right at the end of  test's chain.
     */
    public static  void closeDriver(){
        if (Driver.driver == null) return;

        Driver.driver.manage().deleteAllCookies();
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        Driver.driver.close();
        // update cache otherwise it's a threat to get a stale pointer later.
        Driver.driver = null;
        String[] cli_args = new String[] {"/bin/bash", "-c", "pkill -f geckodriver"};
        try{
        Process proc = new ProcessBuilder(cli_args).start();
        proc.waitFor(1000, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                    e.printStackTrace();
            }
    }

}
