package slotegrator.ui.step;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
@CucumberContextConfiguration
@ContextConfiguration("classpath:cucumber.xml")
public class CucumberSpringConfiguration {}


