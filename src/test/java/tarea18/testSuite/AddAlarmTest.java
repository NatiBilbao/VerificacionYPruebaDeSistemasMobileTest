package tarea18.testSuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tarea17.session.Session;
import tarea18.activities.MainClockView;
import tarea18.controls.Label;

public class AddAlarmTest {

    MainClockView mainClockView = new MainClockView();

    @Test
    public void verifyCreateAlarm(){
        mainClockView.alarmButton.click();
        mainClockView.addAlarmButton.click();
        mainClockView.confirmAlarm.click();

        Label alarmNotification = new Label(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.deskclock:id/snackbar_text\"]\n"));
        Assertions.assertTrue(alarmNotification.isControlDisplayed(),"Error la alarma no fue creada");
    }

    @AfterEach
    public void close(){
        Session.getInstance().closeApp();
    }

}
