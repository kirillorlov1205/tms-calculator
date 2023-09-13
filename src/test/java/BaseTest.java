import org.testng.annotations.*;
import utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    protected Calculator calculator;

    @BeforeClass
    public void setup() {
        calculator = new Calculator();
        System.out.println("Fuck testng !!!");
    }

    @BeforeMethod
    public void startMethodExecution() {
        System.out.println("Test method started");
    }

    @AfterMethod
    public void finishMethodExecution() {
        System.out.println("Test method finished");
    }
}
