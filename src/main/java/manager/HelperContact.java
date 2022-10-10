package manager;

import models.Contact;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.annotation.Repeatable;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class HelperContact extends HelperBase {


    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        click(By.cssSelector("a[href = '/add']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        type(By.xpath("//input[@placeholder='description']"), contact.getDescription());
    }


    public void SaveButton() {
        WebElement saveButton = wd.findElement(By.xpath("//b[text()='Save']"));
        saveButton.click();

    }

    public void SaveButtonToChangeContact() {
        WebElement saveButton = wd.findElement(By.xpath("//button[text()='Save']"));
        saveButton.click();

    }


    public void TabMethod() {
      WebElement tab = wd.findElement(By.cssSelector("[placeholder='description']"));
      tab.sendKeys(Keys.TAB);

    }

    public boolean isContactAddedByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if (el.getText().equals(name))
                return true;
        }
        return false;
    }


    public boolean isContactAddedByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : list) {
            if (el.getText().equals(phone))
                return true;
        }
        return false;
    }

    public void fillContactRequiredForm(Contact contact) {
        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getPhone());
        type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
    }

    //public boolean isAddPageStillDisplayed() {
        //return isElementPresent(By.cssSelector("a.active[href='/add']"));
    //}

    public void OpenExistContacts() {
        WebElement loginTab = wd.findElement(By.cssSelector("a[href='/contacts']"));
        loginTab.click();
    }

    public void FindContactByName(String name) {
        WebElement ContactName = wd.findElement(By.cssSelector("h2"));
        ContactName.getText();
        ContactName.click();
    }

    public void ClickRemoveButton() {
        WebElement delete = wd.findElement(By.xpath("//button[text()='Remove']"));
        delete.click();
    }






    public void ClickEditButton() {
        WebElement edit = wd.findElement(By.xpath("//button[text()='Edit']"));
        edit.click();
    }

    public void ToClearField() {
        WebElement element = wd.findElement(By.xpath("//input[@placeholder='Name']"));
        element.click();
        element.clear();
    }

    public void ToFillNewInformation(Contact contact) {
        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
    }


    public boolean IsDetailedCardPresent() {
        return isElementPresent(By.cssSelector(".contact-item-detailed_card__50dTS"));
    }

    public boolean isAddPageStillDisplayed() {
        return  wd.findElements(By.cssSelector("a.active[href='/add']")).size()>0;
    }

    public int removeOneContact() {
        int before =countOfContact();

        if(!isCountListEmpty()) {
            removeContact();
        }

        int after =countOfContact();
        return before-after;
    }

    private boolean isCountListEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

    private void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        pause(500);
        click(By.xpath("//button[text()='Remove']"));
        pause(500);
    }

    private int countOfContact() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public void removeAllContacts() {
//        List <WebElement> list = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
//        for (int i = 0; i < list.size(); i++) {
//            click(By.cssSelector(".contact-item_card__2SOIM"));
//            click(By.xpath("//button[text()='Remove']"));
//            pause(500);
//        }

        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()!=0){
            removeContact();
        }



    }

    public boolean isNoContactHere() {
        return new WebDriverWait(wd, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .textToBePresentInElement(wd.findElement(By.cssSelector(".contact-page_message__2qafk h1")),"No Contacts here!" ));
    }

    public void providerOfContacts() {
while(wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()<3){
    AddNewContact();
}
    }
    public void AddNewContact() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        Contact contact = Contact.builder()
                .name("Leny" + i)
                .lastName("Lee")
                .phone("3434345" + i)
                .email("john" + i + "@mail.com")
                .address("Haifa")
                .build();
        openContactForm();
        fillContactRequiredForm(contact);
        TabMethod();
        SaveButton();
    }
}

