import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestBase {

    WebDriver wd;
    @BeforeTest
    public void init() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();//open full sreen
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app");

    }

    @AfterTest
    public void TearDown() {
        wd.quit();
    }
}
