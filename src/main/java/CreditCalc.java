public class CreditCalc {

    private double creditSum;
    private double creditTime;
    private double creditRate;

    public CreditCalc(int creditSum, int creditTime, int creditRate) {
        this.creditSum = creditSum;
        this.creditTime = creditTime;
        this.creditRate = creditRate;
    }

    public CreditCalc() {

    }

    public double getMonthlyPayment() {
        double r = creditRate / 1200; //Месячная процентная ставка
        return creditSum * r * Math.pow(1 + r, creditTime) / (Math.pow(1 + r, creditTime) - 1);
    }

    public double totalCreditValue() {
        return creditTime * getMonthlyPayment();
    }

    public double creditOverpayment() {
        return totalCreditValue() - creditSum;
    }
}