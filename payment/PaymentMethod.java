package payment;

public abstract class PaymentMethod implements Payable {
    public String name;
    protected Double balance;

    public abstract void withdraw(Double amount);
    public abstract void deposit(Double amount);
}