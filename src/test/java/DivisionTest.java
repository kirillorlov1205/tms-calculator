import exceptions.IncorrectOperatorException;
import exceptions.ResultLessThanLimitException;
import exceptions.ResultMoreThanLimitException;
import model.Operator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DivisionTest extends BaseTest {

    @Test(testName = "Verify decimals division calculation", invocationCount = 3, threadPoolSize = 3, priority = 1)
    public void verifyDecimalsDivisionCalculation() {
        double actualValue = 0;
        try {
            actualValue = calculator.calculateByOperator(5.5, 2.5, Operator.DIVISION);
        } catch (ResultMoreThanLimitException | ResultLessThanLimitException | IncorrectOperatorException e) {
            throw new RuntimeException(e);
        }
        double expectedValue = 2.2;
        Assert.assertEquals(actualValue, expectedValue, "Actual result doesn't match expected");
    }

    @Test(testName = "Verify integers division calculation", invocationCount = 3, threadPoolSize = 3, priority = 2)
    public void verifyIntegersDivisionCalculation() {
        double actualValue = 0;
        try {
            actualValue = calculator.calculateByOperator(5, 2, Operator.DIVISION);
        } catch (ResultMoreThanLimitException | ResultLessThanLimitException | IncorrectOperatorException e) {
            throw new RuntimeException(e);
        }
        double expectedValue = 2.5;
        Assert.assertEquals(actualValue, expectedValue, "Actual result doesn't match expected");
    }

    @Test(testName = "Verify division calculation with zero", enabled = false, description = "Blocked by 'ITF-1297'",
            priority = 3)
    public void verifyDivisionCalculationWithZero() {
        double actualValue = 0;
        try {
            actualValue = calculator.calculateByOperator(5, 2, Operator.DIVISION);
        } catch (ResultMoreThanLimitException | ResultLessThanLimitException | IncorrectOperatorException e) {
            throw new RuntimeException(e);
        }
        double expectedValue = 0;
        Assert.assertEquals(actualValue, expectedValue, "Actual result doesn't match expected");
    }
}
