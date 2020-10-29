package cucumberoptions;

import cucumber.api.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",
		glue="stepDefination"
		
		)

public class TestRunner extends cucumber.api.testng.AbstractTestNGCucumberTests{
	
}
