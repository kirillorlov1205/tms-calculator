import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import support.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    protected Calculator calculator;

    @BeforeClass
    public void setup() {
        calculator = new Calculator();
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
