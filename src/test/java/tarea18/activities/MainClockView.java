package tarea18.activities;

import org.openqa.selenium.By;
import tarea18.controls.Button;

public class MainClockView {
    public Button alarmButton = new Button(By.xpath("//android.widget.TextView[@text=\"ALARM\"]"));
    public Button addAlarmButton = new Button(By.xpath("//android.widget.ImageButton[@content-desc=\"Add alarm\"]\n"));
    public Button confirmAlarm = new Button(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]\n"));

}
