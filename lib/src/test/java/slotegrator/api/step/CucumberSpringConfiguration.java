package slotegrator.api.step;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.context.annotation.ImportResource;
// import org.springframework.context.annotation.ComponentScan;

@CucumberContextConfiguration
@ImportResource("classpath:api_cucumber.xml")
public class CucumberSpringConfiguration {}

