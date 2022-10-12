import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContact extends TestBase {
    @BeforeMethod
    public void preCondition() {

        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("city1@gmail.com").setPassword("Yy12345$"));
            }
            app.helperContact().providerOfContacts();
        }
    

    @Test(priority = 1)
    public void removeFirstContact(){
//        app.helperContact();
//        app.helperContact().removeOneContact();
//        int after = app.helperContact().countOfContact();

        Assert.assertEquals(app.helperContact().removeOneContact(),(1));
    }

    @Test(priority = 2)
    public void RemoveAllContacts(){
        app.helperContact().removeAllContacts();
        Assert.assertTrue(app.helperContact().isNoContactHere());

    }
}
