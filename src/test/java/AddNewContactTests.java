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

    public void addNewContactSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;

        Contact contact = Contact.builder()
                .name("John" + i)
                .lastName("Snow")
                .phone("3434345" + i)
                .email("john" + i + "@mail.com")
                .address("Rehovot")
                .description("Best friend")
                .build();


        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().tabMethod();
        app.helperContact().tabMethod();
        app.helperContact().saveButton();

        Assert.assertTrue(app.helperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.helperContact().isContactAddedByPhone(contact.getPhone()));

    }


    @Test()

    public void addNewContactSuccessRequiredFields() {
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
        app.helperContact().tabMethod();
        app.helperContact().saveButton();

        Assert.assertTrue(app.helperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.helperContact().isContactAddedByPhone(contact.getPhone()));
    }

    @Test

    public void addNewContactWrongName() {
                Contact contact = Contact.builder()
                .name("")
                .lastName("Moo")
                .phone("3434345000")
                .email("M@mail.com")
                .address("Rehovot")
                .build();


        app.helperContact().openContactForm();
        app.helperContact().fillContactForm(contact);
        app.helperContact().tabMethod();
        app.helperContact().saveButton();
        app.helperContact().tabMethod();
        app.helperContact().tabMethod();
        app.helperContact().tabMethod();
        app.helperContact().tabMethod();
        app.helperContact().tabMethod();
        app.helperContact().tabMethod();
        app.helperContact().tabMethod();
        app.helperContact().tabMethod();

        Assert.assertTrue(app.helperContact().isAddPageStillDisplayed());
        }

        @Test(enabled = false)
        public void ChangeContact(){
            Contact contact = Contact.builder()
                    .name("Lisa").
                    build();
        app.helperContact().openExistContacts();
        app.helperContact().findContactByName("Mini");
        app.helperContact().clickEditButton();
        app.helperContact().toClearField();
        app.helperContact().toFillNewInformation(contact);
        app.helperContact().saveButtonToChangeContact();
        Assert.assertTrue(app.helperContact().isDetailedCardPresent());

        }

}
