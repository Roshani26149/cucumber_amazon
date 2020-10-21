package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="D:\\CucumberProjects\\com.qa.amazon\\src\\test\\resources\\features\\HealthCheke123.feature",
                 glue="StepDefs11",
                 monochrome=true,
                  plugin = {"pretty", // to generate reports
		                      "html:target/html/htmlreport.html",
		                         "json:target/json/file.json",
                                                                  },
                                       publish=true,
                                   dryRun=false 
		)

public class TestRunner {

}
