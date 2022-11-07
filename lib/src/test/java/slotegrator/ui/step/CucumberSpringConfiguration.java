package slotegrator.ui.step;

import slotegrator.ui.Driver;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
// import org.springframework.test.context.support.AnnotationConfigContextLoader;
// import org.springframework.context.annotation.PropertySource;
// 
// @PropertySource("classpath:ui.data.properties")
// @PropertySource("classpath:ui.driver.properties")
@CucumberContextConfiguration
@ContextConfiguration("classpath:cucumber.xml")
// @ContextConfiguration(
// classes=slotegrator.ui.step.UiTestRunner.class , loader=AnnotationConfigContextLoader.class)

// @ComponentScan(basePackages="slotegrator")
public class CucumberSpringConfiguration {
    
    // @Bean
    // public Driver getDriver(){
    //     return new Driver();
    // }
}


