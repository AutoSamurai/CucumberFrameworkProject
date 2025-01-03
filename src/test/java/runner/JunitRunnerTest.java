package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/resources/features",
                  glue ={"stepdefinations", "hooks"},
		          plugin= {"pretty", 
		        		   "html:target/CucumberReports/CucumberReport.html", 
		        		   "json:target/CucumberReports/Cucumberjson.json", 
		        		   "junit:target/CucumberReports/Cucumberxml.xml",
		        		 
                            "rerun:target/FailedScenarios.txt"
		        		  },
		          tags = "@all")
public class JunitRunnerTest {
	
	

}                                                                   
