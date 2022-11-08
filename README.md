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

app_profile='dev' == firefox in maximazed screen, other string == headless.
```

##### To run test.
In terminal `cd` to PROJECT\_ROOT and `./gradlew test`.
