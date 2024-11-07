package testSuite.contact;

import activities.contacts.ContactCreateForm;
import activities.contacts.ContactDetailScreen;
import activities.contacts.ContactListScreen;
import activities.contacts.SyncAlert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.util.Date;

public class ContactTest {
    SyncAlert syncAlert = new SyncAlert();
    ContactDetailScreen contactDetailScreen = new ContactDetailScreen();
    ContactListScreen contactListScreen = new ContactListScreen();

    ContactCreateForm contactCreateForm = new ContactCreateForm();

    @Test
    public void createContactTest(){
        String name = "UPB"+new Date().getTime();
        String lastName= "UPB";
        contactListScreen.addContactButton.click();
        syncAlert.cancelButton.click();
        contactCreateForm.nameTxtBox.setText(name);
        contactCreateForm.lastNameTxtBox.setText(lastName);
        contactCreateForm.phoneTxtBox.setText("777777777");
        contactCreateForm.typePhone.selectOption("Home");
        contactCreateForm.saveButton.click();
        Assertions.assertEquals(name+" "+lastName,contactDetailScreen.nameLabel.getText(),
                "ERROR, el contacto no fue creado correctamente");
    }

    @AfterEach
    public void close(){
        Session.getInstance().closeApp();
    }
}
