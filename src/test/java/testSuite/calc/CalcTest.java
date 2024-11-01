package testSuite.calc;

import activities.calc.MainScreen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalcTest extends CalcTestBase{
    MainScreen mainScreen = new MainScreen();
    @Test
    public void additionTwoNumbers(){
        mainScreen.eigthButton.click();
        mainScreen.addButton.click();
        mainScreen.fourButton.click();
        mainScreen.equalButton.click();
        Assertions.assertEquals("12",mainScreen.resultLabel.getText(),
                "ERROR la suma es incorrecta");
    }
}
