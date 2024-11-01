package tarea17.activities;

import org.openqa.selenium.By;
import tarea17.controls.Button;
import tarea17.controls.TextBox;

public class UpdateTaskActivity {
    public TextBox titleTask = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));

    public Button saveTask = new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));

    public Button deleteTask = new Button(By.id("com.vrproductiveapps.whendo:id/deleteItem"));
}
