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

    @Test

    public void RegistrationSuccess(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("city1@gmail.com","Yy12345$");
        app.getHelperUser().submitRegistration();
        Assert.assertEquals(app.getHelperUser().getTitleMessage(), "No Contacts here!");
        //Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test

    public void RegistrationSuccess1(){
        System.out.println(System.currentTimeMillis());
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        User user = new User().setEmail("city1"+i+"@gmail.com").setPassword("Yy12345$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        //Assert.assertEquals(app.getHelperUser().getTitleMessage(), "No Contacts here!");
        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void registrationNegativeWrongEmailFormat(){
       app.getHelperUser().openLoginRegistrationForm();
       app.getHelperUser().fillLoginRegistrationForm(new User().setEmail("city1gmail.com").setPassword("Yy12345$"));
        app.getHelperUser().submitRegistration();

    }
}
