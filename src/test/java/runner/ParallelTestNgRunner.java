package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features" ,
glue ={"stepdefinations", "hooks"},
plugin= {"pretty", 
		   "html:target/CucumberReports/CucumberReport.html", 
		   "json:target/CucumberReports/Cucumberjson.json", 
		   "junit:target/CucumberReports/Cucumberxml.xml"
		  },
tags = "@all"
)
public class ParallelTestNgRunner extends AbstractTestNGCucumberTests{

	@DataProvider(parallel= true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
}
