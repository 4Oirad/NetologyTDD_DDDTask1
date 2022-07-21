import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class TestCreditCalc {

    Random random = new Random();
    private static final double DELTA = 1e-15;

    @Test
    public void testGetMonthlyPayment() {
        final int creditSum = random.nextInt();
        final int creditTime = random.nextInt();
        final int creditRate = random.nextInt();

        CreditCalc calc = new CreditCalc(creditSum, creditTime, creditRate);

        final double actual = calc.getMonthleyPayment();
        final double r = creditRate / 1200;
        final double expected = creditSum * r * Math.pow(1 + r, creditTime) / (Math.pow(1 + r, creditTime) - 1);

        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testTotalCreditValue() {
        final int creditSum = random.nextInt();
        final int creditTime = random.nextInt();
        final int creditRate = random.nextInt();

        CreditCalc calc = new CreditCalc(creditSum, creditTime, creditRate);

        final double actual = calc.totalCreditValue();
        final double expected = creditTime * calc.getMonthlyPayment();

        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testCreditOverpayment() {
        final int creditSum = random.nextInt();
        final int creditTime = random.nextInt();
        final int creditRate = random.nextInt();

        CreditCalc calc = new CreditCalc(creditSum, creditTime, creditRate);

        final double actual = calc.creditOverpayment();
        final double expected = calc.totalCreditValue() - creditSum;

        Assertions.assertEquals(expected, actual, DELTA);
    }
}