package payment.cash;
import payment.PaymentMethod;

public class Cash extends PaymentMethod {

    public Cash() {
        name = "Cash";
        balance = 100.0;
    }

    public void withdraw(Double amount) {}

    public void deposit(Double amount) {}
}