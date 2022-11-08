## Test Assignment for Slotegrator.

##### Technical Stack:
* Java 11
* Selenium
* Geckodriver
* Cucumber

##### Settings:
To run test Geckodriver 0.32 must be installed on test machine. Then in 
directory PROJECT\_ROOT/lib/src/test/resources in file driver.properties
set required properties:  
```bash
geckodriver_exec=path to executable

firefox_profile_path=must set firefox profile

app_profile='dev' == firefox in maximized screen, other string == headless.
```

##### To run test.
In terminal `cd` to PROJECT\_ROOT and `./gradlew test`.  
Html reports for test are in PROJECT\_ROOT/cucumber\_reports  
To run tests individually: `./gradlew apiTests` and `./gradlew uiTests` respectively.  

##### What is not properly done:
Whole API Testing Section. Because url that provided in specifications respond with 404
code response. After writing letters to HR I have got response that it's actually
that what is requested. So I simply write boiler plate code for this section.  
I have spend a lot of time to suppress logging to teminal from sprinframework.
But no matter what I did it still showing up. One thing that makes me feel a bit
easier that as in 'Inception' movie the more levels of indirection we have the more
glitchy system behave.   

##### Notes to those who may read this code:
Code written in vim editor I don't have particularly good settings for Java.
Some unused imports and strange formatting may be present.
