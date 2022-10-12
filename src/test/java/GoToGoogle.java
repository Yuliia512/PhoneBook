import manager.ListenerNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
@Listeners(ListenerNG.class)
public class GoToGoogle {

    WebDriver wd;

    @Test
    public void goGoogle(){
        wd = new ChromeDriver();
        wd.manage().window().maximize(); /// open full screen
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://google.com");
        wd.close();
    }
}
