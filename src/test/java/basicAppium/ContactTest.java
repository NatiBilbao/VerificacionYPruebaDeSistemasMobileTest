package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Date;

public class ContactTest {
    AppiumDriver driver;

    @BeforeEach
    public void openApp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName","UPBV9");
        capabilities.setCapability("appium:platformVersion","9.0");
        capabilities.setCapability("appium:appPackage","com.android.contacts");
        capabilities.setCapability("appium:appActivity","com.android.contacts.activities.PeopleActivity");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appium:automationName","uiautomator2");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterEach
    public void closeApp(){
        driver.quit();
    }

    @Test
    public void verifyNewAccount() throws InterruptedException {
//        click + --> com.android.contacts:id/floating_action_button
        driver.findElement(By.id("com.android.contacts:id/floating_action_button")).click();
//        cancel --> com.android.contacts:id/left_button
        driver.findElement(By.id("com.android.contacts:id/left_button")).click();
//        first name -->
//                  //android.widget.EditText[@text="First name"]

        String name="Appium"+new Date().getTime();
        String lastName="UPB";
        String phone="123123123";
        driver.findElement(By.xpath("//android.widget.EditText[@text=\"First name\"]")).sendKeys(name);
//                last name --> //android.widget.EditText[@text="Last name"]
        driver.findElement(By.xpath("//android.widget.EditText[@text=\"Last name\"]")).sendKeys(lastName);
//                phone ---> //android.widget.EditText[@text="Phone"]
        driver.findElement(By.xpath("//android.widget.EditText[@text=\"Phone\"]")).sendKeys(phone);
//        mobile combobox --> //android.widget.TextView[@text='Mobile']
        driver.findElement(By.xpath("//android.widget.TextView[@text='Mobile']")).click();
//                opcion --> //android.widget.CheckedTextView[@text='Home']
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Home']")).click();
//                save --> com.android.contacts:id/editor_menu_save_button
        driver.findElement(By.id("com.android.contacts:id/editor_menu_save_button")).click();
//
//        verificacion
//        name value --> com.android.contacts:id/large_title
        Assertions.assertEquals(name + " "+lastName,driver.findElement(By.id("com.android.contacts:id/large_title")).getText()
                ,"ERROR el contacto no fue creado");
    }
}
