package tarea17.testSuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tarea17.activities.CreateTaskActivity;
import tarea17.activities.DeleteConfirmDialog;
import tarea17.activities.HomeActivity;
import tarea17.activities.UpdateTaskActivity;
import tarea17.session.Session;

public class CreateUpdateDeleteTaskTest {
    private HomeActivity homeActivity = new HomeActivity();
    private CreateTaskActivity createTaskActivity = new CreateTaskActivity();
    private UpdateTaskActivity updateTaskActivity = new UpdateTaskActivity();
    private DeleteConfirmDialog deleteConfirmDialog = new DeleteConfirmDialog();

    @Test
    public void verifySomething(){

        //Crear tarea
        String taskName = "Hacer la tarea de verificacion y prueba de sistemas";

        homeActivity.addTask.click();
        createTaskActivity.titleTask.setText(taskName);
        createTaskActivity.saveTask.click();
        Assertions.assertTrue(homeActivity.taskItem(taskName).isControlDisplayed(), "ERROR la tarea no fue creada");

        //Actualizar tarea
        String taskNameUpdated = "Hacer la tarea de QA";
        homeActivity.taskItem(taskName).click();
        updateTaskActivity.titleTask.setText(taskNameUpdated);
        updateTaskActivity.saveTask.click();
        Assertions.assertTrue(homeActivity.taskItem(taskNameUpdated).isControlDisplayed(), "ERROR la tarea no fue actualizada");

        //Eliminar tarea
        homeActivity.taskItem(taskNameUpdated).click();
        updateTaskActivity.deleteTask.click();
        deleteConfirmDialog.deleteTask.click();
        Assertions.assertFalse(homeActivity.taskItem(taskNameUpdated).isControlDisplayed(), "ERROR la tarea no fue eliminada");
    }

    @AfterEach
    public void close(){
        Session.getInstance().closeApp();
    }
}
