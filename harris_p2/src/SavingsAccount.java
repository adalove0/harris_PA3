public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount() {
        annualInterestRate = 0.0;
        savingsBalance = 0;
    }

    public SavingsAccount(double newInterestRate, double savingsBalance) {
        annualInterestRate = newInterestRate;
        this.savingsBalance = savingsBalance;
    }

    public void calculateMonthlyInterest() {
        savingsBalance += (savingsBalance * (annualInterestRate / 12.0));
    }
    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public static void modifyInterestRate(double newInterestRate) {
        annualInterestRate = newInterestRate;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }
}
