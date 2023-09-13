import exceptions.IncorrectOperatorException;
import exceptions.ResultLessThanLimitException;
import exceptions.ResultMoreThanLimitException;
import model.Operator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest extends BaseTest {

    @DataProvider(name = "Positive values to calculate sum")
    private Object[][] positiveValuesList() {
        return new Object[][]{
                {-0.1, 0.1, 0},
                {0.0, 10.0, 10.0},
                {0.1, 10.0, 10.1},
                {50.0, 50.0, 100.0},
                {99.9, 0.1, 100},
        };
    }

    @Test(dataProvider = "Positive values to calculate sum", testName = "Verify sum calculation")
    public void verifySumCalculation(double num1, double num2, double result) {
        double actualValue = 0;
        try {
            actualValue = calculator.calculateByOperator(num1, num2, Operator.SUM);
        } catch (ResultMoreThanLimitException | ResultLessThanLimitException | IncorrectOperatorException e) {
            throw new RuntimeException(e);
        }
        double expectedValue = result;
        Assert.assertEquals(actualValue, expectedValue, "Actual result doesn't match expected");
    }

    @Test(testName = "Verify validation with more than limit result while sum calculation", expectedExceptions =
            RuntimeException.class)
    public void verifyValidationWithMoreThanLimitSumCalculation() {
//        String expectedExceptionMessage = "Result couldn't be more than 100. Calm down, bro";
//        String actualExceptionMessage = "";
        try {
            calculator.calculateByOperator(100.0, 0.1, Operator.SUM);
        } catch (ResultMoreThanLimitException | ResultLessThanLimitException | IncorrectOperatorException e) {
            throw new RuntimeException(e);
        }
//        Assert.assertEquals(actualExceptionMessage, expectedExceptionMessage, "Actual result doesn't match " +
//                "expected");
    }
}
