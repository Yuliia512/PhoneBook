import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {


    @BeforeMethod
    public void precondition() {
        logger.info("Start checking authorisation");
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("Test has needed logout");
        }else{
            logger.info("Test has not needed logout");
        }
    }

    @Test
    public void loginSuccessModel() {
        logger.info("test started------------Login success Model");
        User user = new User().setEmail("423090@gmail.com").setPassword("Yy12345$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert passed(Model)");




    }


    @Test
    public void loginSuccess() {
        logger.info("User login with data:  email 423090@gmail.com & password Yy12345$");
        //open login form
        app.getHelperUser().openLoginRegistrationForm();
        //fill email
        app.getHelperUser().fillLoginRegistrationForm("423090@gmail.com", "Yy12345$");
        // submit login

        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Sign button Present");


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
