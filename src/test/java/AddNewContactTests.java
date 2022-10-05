import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;


public class AddNewContactTests extends TestBase {
    @BeforeMethod
    public void preCondition() {

        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("city1@gmail.com").setPassword("Yy12345$"));
        }
    }

    @Test

    public void AddNewContactSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;

        Contact contact = Contact.builder()
                .name("John" + i)
                .lastName("Snow")
                .phone("3434345" + i)
                .email("john" + i + "@mail.com")
                .address("Rehovot")
                .description("The best friend")
                .build();


        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().TabMethod();
        app.helperContact().SaveButton();

        Assert.assertTrue(app.helperContact().isContactContactAddedByName(contact.getName()));
        Assert.assertTrue(app.helperContact().isContactContactAddedByPhone(contact.getPhone()));

    }


    @Test

    public void AddNewContactSuccessRequiredFields() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;

        Contact contact = Contact.builder()
                .name("Leny" + i)
                .lastName("Lee")
                .phone("3434345" + i)
                .email("john" + i + "@mail.com")
                .address("Haifa")
                .build();


        app.helperContact().openContactForm();
        app.helperContact().fillContactRequiredForm(contact);
        app.helperContact().TabMethod();
        app.helperContact().SaveButton();

        Assert.assertTrue(app.helperContact().isContactContactAddedByName(contact.getName()));
        Assert.assertTrue(app.helperContact().isContactContactAddedByPhone(contact.getPhone()));
    }

    @Test

    public void AddNewContactWrongName() {
                Contact contact = Contact.builder()
                .name("")
                .lastName("Moo")
                .phone("3434345000")
                .email("M@mail.com")
                .address("Rehovot")
                .description("The best friend")
                .build();


        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().TabMethod();
        app.helperContact().SaveButton();

        Assert.assertTrue(app.helperContact().isAddPageStillDisplayed());
        }

        @Test
        public void ChangeContact(){
            Contact contact = Contact.builder()
                    .name("Lisa").
                    build();
        app.helperContact().OpenExistContacts();
        app.helperContact().FindContactByName("Mini");
        app.helperContact().ClickEditButton();
        app.helperContact().ToClearField();
        app.helperContact().ToFillNewInformation(contact);
        app.helperContact().SaveButton();
        Assert.assertTrue(app.helperContact().IsDetailedCardPresent());

        }

        @Test
    public void DeleteContact(){
        app.helperContact().OpenExistContacts();
        app.helperContact().FindContactByName("Lany1423");
        app.helperContact().ClickRemoveButton();
        Assert.assertTrue(app.helperContact().isContactDeleted());
        }

    @Test
    public void DeleteAllContacts(){
        app.helperContact().OpenExistContacts();
        app.helperContact().FindContactByName("Lisa");
        app.helperContact().ClickRemoveButton();
        app.getHelperUser().pause(3000);
        app.helperContact().FindContactByName("Leny1409");
        app.helperContact().ClickRemoveButton();
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());
    }
}
