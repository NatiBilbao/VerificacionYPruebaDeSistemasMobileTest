package tarea17.session;

import io.appium.java_client.AppiumDriver;
import tarea17.factoryDevices.FactoryDevices;
import tarea17.utils.GetEnvironment;

public class Session {
    private static Session session = null;
    private AppiumDriver device;
    private Session(){
        // todo
        device = FactoryDevices.make("android").create();
    }

    public static Session getInstance(){
        if (session == null)
            session = new Session();
        return session;
    }

    public void closeApp(){
        device.quit();
        session = null;
    }

    public AppiumDriver getDevice(){
        return  device;
    }
}
