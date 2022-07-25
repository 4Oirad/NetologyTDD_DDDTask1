import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сумма кредита:");
        int creditSum = scanner.nextInt();
        System.out.println("Срок кредита (в мес.):");
        int creditTime = scanner.nextInt();
        System.out.println("Процентная ставка:");
        int creditRate = scanner.nextInt();

        CreditCalc calc = new CreditCalc(creditSum, creditTime, creditRate);

        System.out.println("Ваш ежемесячный платеж: " + (int) calc.getMonthlyPayment() + " руб.");
        System.out.println("Общая стоимость кредита: " + (int) calc.totalCreditValue() + " руб.");
        System.out.println("Переплата за весь период: " + (int) calc.creditOverpayment() + " руб.");
    }
}