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

public class CalculatorTest {
    AppiumDriver driver;

    @BeforeEach
    public void openApp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName","UPBV9");
        capabilities.setCapability("appium:platformVersion","9.0");
        capabilities.setCapability("appium:appPackage","com.android.calculator2");
        capabilities.setCapability("appium:appActivity","com.android.calculator2.Calculator");
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
    public void verifyAddition() throws InterruptedException {
        // click 8
        driver.findElement(By.xpath("//android.widget.Button[@text='8']")).click();

        // click +
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"plus\"]")).click();

        // click 4
        driver.findElement(By.id("com.android.calculator2:id/digit_4")).click();

        // click =
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();
        Thread.sleep(5000);

        // verification
        String expected ="12";
        String actual =  driver.findElement(By.id("com.android.calculator2:id/result")).getText();
        Assertions.assertEquals(expected,actual,"ERROR la suma es incorrecta");
    }
}
