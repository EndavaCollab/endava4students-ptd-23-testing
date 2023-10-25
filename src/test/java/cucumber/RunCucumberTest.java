package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/cucumber"},
    glue = {"cucumber"},
    plugin = {"pretty","json:target/cucumber.json"})
public class RunCucumberTest {
}
