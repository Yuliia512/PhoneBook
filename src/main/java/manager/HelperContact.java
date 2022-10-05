package manager;

import models.Contact;
import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.awt.SystemColor.text;

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
        WebElement saveButton = wd.findElement(By.xpath("//button[text()='Save']"));
        saveButton.click();

    }


    public void TabMethod() {
        wd.findElement(By.cssSelector("[placeholder='description']")).sendKeys(Keys.TAB);
    }

    public boolean isContactContactAddedByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if (el.getText().equals(name))
                return true;
        }
        return false;
    }


    public boolean isContactContactAddedByPhone(String phone) {
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

    public boolean isAddPageStillDisplayed() {
        return isElementPresent(By.cssSelector("a.active[href='/add']"));
    }

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

    public boolean isContactDeleted() {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if (el.equals("2")) ;
            return true;
        }
        return false;
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
}

