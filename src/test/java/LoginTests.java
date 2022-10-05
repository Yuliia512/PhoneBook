import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
    public void loginSuccessModel() {
        User user = new User().setEmail("423090@gmail.com").setPassword("Yy12345$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());




    }


    @Test
    public void loginSuccess() {
        logger.info("test started------------Login success");
        //open login form
        app.getHelperUser().openLoginRegistrationForm();
        //fill email
        app.getHelperUser().fillLoginRegistrationForm("423090@gmail.com", "Yy12345$");
        // submit login
        logger.info("User login with data:  email 423090@gmail.com & password Yy12345$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert passed");


    }


    @Test
    public void loginNegativeWrongEmailFormat() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User().setEmail("423090gmail.com").setPassword("Yy12345$"));
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
    }

    @Test
    public void loginNegativeWrongPasswordFormat() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User().setEmail("42309@gmail.com").setPassword("Yy12345"));
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());

    }
}
