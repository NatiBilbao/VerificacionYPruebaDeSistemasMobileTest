package tarea17.activities;

import org.openqa.selenium.By;
import tarea17.controls.Button;

public class HomeActivity {
    public Button addTask = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));

    public Button taskItem(String taskName){
        return new Button(By.xpath("//android.widget.TextView[@text='"+taskName+"']"));
    }
}
