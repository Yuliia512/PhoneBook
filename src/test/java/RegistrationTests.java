import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test(enabled = false)

    public void RegistrationSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("city8@gmail.com","Yy12345$");
        app.getHelperUser().submitRegistration();
        //Assert.assertEquals(app.getHelperUser().getTitleMessage(), "No Contacts here!");

        Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());
    }

    @Test

    public void RegistrationSuccess1(){
        System.out.println(System.currentTimeMillis());
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        User user = new User().setEmail("city1"+i+"@gmail.com").setPassword("Yy12345$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());
    }

    @Test
    public void registrationNegativeWrongEmailFormat(){
       app.getHelperUser().openLoginRegistrationForm();
       app.getHelperUser().fillLoginRegistrationForm(new User().setEmail("city1gmail.com").setPassword("Yy12345$"));
        app.getHelperUser().submitRegistration();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertWithErrorPresent("Wrong email or password format"));
        //Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());

    }

    @Test
    public void registrationNegativeWrongPasswordFormat(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User().setEmail("city2@gmail.com").setPassword("Yy12345"));
        app.getHelperUser().submitRegistration();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());

    }

    @Test
    public void registrationNegativeUserAlreadyExists(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User().setEmail("city1@gmail.com").setPassword("Yy12345$"));
        app.getHelperUser().submitRegistration();
        Assert.assertFalse(app.getHelperUser().isLogged());
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertWithErrorPresent("User already exist"));

    }

}
