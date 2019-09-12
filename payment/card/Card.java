package payment.card;
import payment.PaymentMethod;

public abstract class Card extends PaymentMethod {

    public void withdraw(Double amount) {
        if (amount > 0 && amount < this.balance) {
            this.balance = this.balance - amount;
        } else {
            System.out.println("You do not have the funds to purchase");
        }
    };
    
    public void deposit(Double amount) {
    }

    public String showInfo() {
        return "Your " + this.name + " card has " + this.balance + " left.";
    }
}
