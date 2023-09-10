import Utils.Operator;
import Utils.exceptions.IncorrectOperatorException;
import Utils.exceptions.ResultLessThanLimitException;
import Utils.exceptions.ResultMoreThanLimitException;
import org.testng.Assert;
import org.testng.annotations.Test;
import support.Retry;

public class SubtractionTest extends BaseTest {

    @Test(testName = "Verify decimals subtraction calculation", retryAnalyzer = Retry.class)
    public void verifyDecimalsSubtractionCalculation() {
        double actualValue = 0;
        try {
            actualValue = calculator.calculateByOperator(5.5, 2.5, Operator.SUBTRACTION);
        } catch (ResultMoreThanLimitException | ResultLessThanLimitException | IncorrectOperatorException e) {
            throw new RuntimeException(e);
        }
        double expectedValue = 3;
        Assert.assertEquals(actualValue, expectedValue, "Actual result doesn't match expected");
    }

    @Test(testName = "Verify integers subtraction calculation")
    public void verifyIntegersSubtractionCalculation() {
        double actualValue = 0;
        try {
            actualValue = calculator.calculateByOperator(5, 2, Operator.SUBTRACTION);
        } catch (ResultMoreThanLimitException | ResultLessThanLimitException | IncorrectOperatorException e) {
            throw new RuntimeException(e);
        }
        double expectedValue = 3;
        Assert.assertEquals(actualValue, expectedValue, "Actual result doesn't match expected");
    }

    @Test(testName = "Verify subtraction calculation with zero")
    public void verifySubtractionCalculationWithZero() {
        double actualValue = 0;
        try {
            actualValue = calculator.calculateByOperator(5.5, 0, Operator.SUBTRACTION);
        } catch (ResultMoreThanLimitException | ResultLessThanLimitException | IncorrectOperatorException e) {
            throw new RuntimeException(e);
        }
        double expectedValue = 5.5;
        Assert.assertEquals(actualValue, expectedValue, "Actual result doesn't match expected");
    }
}
