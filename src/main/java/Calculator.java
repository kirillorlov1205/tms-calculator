import Utils.Operator;
import Utils.exceptions.IncorrectOperatorException;
import Utils.exceptions.ResultLessThanLimitException;
import Utils.exceptions.ResultMoreThanLimitException;

public class Calculator {

    public Calculator() {}

    public double calculateByOperator(double num1, double num2, Operator operator) throws ResultMoreThanLimitException,
            ResultLessThanLimitException, IncorrectOperatorException {

        double result = 0;
        if (operator != null) {
            switch (operator) {
                case SUM:
                    result = num1 + num2;
                    break;
                case SUBTRACTION:
                    result = num1 - num2;
                    break;
                case DIVISION:
                    result = num1 / num2;
                    break;
                case MULTIPLICATION:
                    result = num1 * num2;
                    break;
            }
        } else {
            throw new IncorrectOperatorException("Incorrect operator provided, we don't give a shit");
        }
        if (result > 100) {
            throw new ResultMoreThanLimitException("Result couldn't be more than 100. Calm down, bro");
        } else if (result < -100) {
            throw new ResultLessThanLimitException("Result couldn't be less than -100. Calm down, bro");
        }
        return result;
    }
}
