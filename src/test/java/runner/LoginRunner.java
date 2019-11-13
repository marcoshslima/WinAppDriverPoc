package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/features/Login",
        tags = {"@WinAPP"},
        glue = "steps",
        plugin = {"pretty","json:target/cucumber/WinApp.json"}
)
public class LoginRunner {
}
