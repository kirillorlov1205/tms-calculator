import Utils.Operator;
import Utils.exceptions.IncorrectOperatorException;
import Utils.exceptions.ResultLessThanLimitException;
import Utils.exceptions.ResultMoreThanLimitException;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiplicationTest extends BaseTest {

    @Test(testName = "Verify decimals multiplication calculation", priority = 1, groups = {"group1"})
    public void verifyDecimalsMultiplicationCalculation() {
        double actualValue = 0;
        try {
            actualValue = calculator.calculateByOperator(5.5, 2.5, Operator.MULTIPLICATION);
        } catch (ResultMoreThanLimitException | ResultLessThanLimitException | IncorrectOperatorException e) {
            throw new RuntimeException(e);
        }
        double expectedValue = 13.75;
        Assert.assertEquals(actualValue, expectedValue, "Actual result doesn't match expected");
    }

    @Test(testName = "Verify integers multiplication calculation", priority = 2, groups = {"group1"})
    public void verifyIntegersMultiplicationCalculation() {
        double actualValue = 0;
        try {
            actualValue = calculator.calculateByOperator(5, 2, Operator.MULTIPLICATION);
        } catch (ResultMoreThanLimitException | ResultLessThanLimitException | IncorrectOperatorException e) {
            throw new RuntimeException(e);
        }
        double expectedValue = 10;
        Assert.assertEquals(actualValue, expectedValue, "Actual result doesn't match expected");
    }

    @Parameters({"num1", "num2"})
    @Test(testName = "Verify multiplication calculation with zero", priority = 3)
    public void verifyMultiplicationCalculationWithZero(@Optional("10") int num1, @Optional("10") int num2) {
        double actualValue = 0;
        try {
            actualValue = calculator.calculateByOperator(num1, num2, Operator.MULTIPLICATION);
        } catch (ResultMoreThanLimitException | ResultLessThanLimitException | IncorrectOperatorException e) {
            throw new RuntimeException(e);
        }
        double expectedValue = 0;
        Assert.assertEquals(actualValue, expectedValue, "Actual result doesn't match expected");
    }
}
