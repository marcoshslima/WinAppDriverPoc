import io.appium.java_client.MobileBy;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class CalculadoraWindows {

private static WindowsDriver driver = null;
//private static WebElement element = null;

    @Test
    public void testOpenCalcWindows() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("app",
          //      "Microsoft.WindowsCalculator_10.1906.53.0_x64__8wekyb3d8bbwe");

             capabilities.setCapability("app",
               "C:\\Users\\Marcos Lima\\Desktop\\AC WorkStation\\ACWorkStation.exe");


        driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capabilities);
        System.out.println(driver.getWindowHandle());

        Thread.sleep(47000);
        System.out.println(driver.getWindowHandle());

        for(String winHandle : driver.getWindowHandles()){
            System.out.println("Janelas " + winHandle);
        }

        Optional<String> loginWindow = driver.getWindowHandles().stream().findFirst();
        System.out.println("Teste " + loginWindow.get());
        driver.switchTo().window(loginWindow.get());
        driver.findElementByAccessibilityId("txtUserName").sendKeys("teste");
        driver.findElementByAccessibilityId("txtUserPassword").sendKeys("teste");
        driver.findElementByAccessibilityId("btnLogin").click();
    }


}
