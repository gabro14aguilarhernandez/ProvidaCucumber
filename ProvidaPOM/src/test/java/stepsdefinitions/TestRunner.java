package stepsdefinitions;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
        features="C:/Users/hitss/git/ProvidaCucumber/ProvidaPOM/src/main/java/feature/SearchProvida.feature",
              glue = {"stepsdefinitions"},
              monochrome = true,
        plugin = {"pretty","html:target/HtmlReporst"},
        tags = "@tag1"
        
        )


public class TestRunner {

}
