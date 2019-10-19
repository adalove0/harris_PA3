public class TestProgram {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        saver1.setSavingsBalance(2000);
        saver2.setSavingsBalance(3000);
        SavingsAccount.modifyInterestRate(0.04);

        for (int i = 0; i < 12; i++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.printf("Month " + (i+1) + ": saver1 new balance: $%.2f, saver2 new balance: $%.2f\n", saver1.getSavingsBalance(), saver2.getSavingsBalance());
        }
        SavingsAccount.modifyInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.printf("Balance one month after interest rates raised to 5%%, saver1 new balance: $%.2f, saver2 new balance: $%.2f\n", saver1.getSavingsBalance(), saver2.getSavingsBalance());
    }
}
