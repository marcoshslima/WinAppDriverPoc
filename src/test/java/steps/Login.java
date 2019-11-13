package steps;


import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Login {

    Process p;
    private static WindowsDriver driver = null;

    @Before
    public void openWinAppDriver() throws IOException, InterruptedException {

        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "WinAppDriver.bat");
        File dir = new File("C:\\Users\\Marcos Lima\\IdeaProjects\\WindowsApplicationTest\\src\\test\\java\\Driver");
        pb.directory(dir);
        p = pb.start();
        //p.destroy();
    }

    @Given("^I open the paytrue system successfully$")
    public void iOpenThePaytrueSystemSuccessfully() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app",
                "C:\\Users\\Marcos Lima\\Desktop\\AC WorkStation\\ACWorkStation.exe");
        driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capabilities);
        Thread.sleep(47000);
        Optional<String> loginWindow = driver.getWindowHandles().stream().findFirst();
        driver.switchTo().window(loginWindow.get());

    }

    @And("^I fill the field Username (.*) and PassWord (.*) with incorrect values$")
    public void iFillTheFieldUsernameUsernameAndPassWordPasswordWithIncorrectValues(String userName, String password) {
        driver.findElementByAccessibilityId("txtUserName").sendKeys(userName);
        driver.findElementByAccessibilityId("txtUserPassword").sendKeys(password);
    }

    @When("^I Click on the button Login$")
    public void iClickOnTheButtonLogin() {
        driver.findElementByAccessibilityId("btnLogin").click();
    }

    @Then("^The system should displayed the following message (.*)$")
    public void theSystemShouldDisplayedTheFollowingMessageMessageError(String message) {
        String teste = "Marcos";
        assertThat(teste).contains("Henrique");
    }

    @AfterStep
    public void teste(Scenario s){
       // s.
        //System.out.println("Teste");
    }

    @After
    public void closeDriver(){
        driver.closeApp();
        p.destroyForcibly();
    }
}
