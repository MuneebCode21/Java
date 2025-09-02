public class Main {
    public static void main(String[] args) {
        PaymentSystem.A A = new CreditClass(232);
        PaymentSystem.A B = new Paypal(424);
        PaymentSystem.A C = new BankTransfer(2455);

        A.DisplayAmount();
        B.DisplayAmount();
        C.DisplayAmount();
    }
}