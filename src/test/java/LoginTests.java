import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {


    @BeforeMethod
    public void precondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess() {

        //open login form
        app.getHelperUser().openLoginRegistrationForm();
        //fill email
        app.getHelperUser().fillLoginRegistrationForm("423090@gmail.com", "Yy12345$");
        // submit login
        app.getHelperUser().submitLogin();

    }


    //@Test
    //public void loginNegativeWrongEmailFormat() {

    //}

    //@Test
    //public void loginNegativeWrongPasswordFormat() {


    //}
}
