package payment;

import java.util.ArrayList;
import payment.cash.Cash;
import payment.card.Credit;
import payment.card.Debit;
import payment.card.Card;

public class Sale {

    private ArrayList<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();

    private Double paymentAmount = 0.0;

    public Sale() {
        Cash cash = new Cash();
        Credit credit = new Credit();
        Debit debit = new Debit();

        this.paymentMethods.add(cash);
        this.paymentMethods.add(credit);
        this.paymentMethods.add(debit);
    }

    public void init() {
        System.out.println("How much are you required to pay?");
        paymentAmount = Double.parseDouble(System.console().readLine());
        System.out.println("Choose payment method:");
        showPaymentMethods();
        int option = Integer.parseInt(System.console().readLine());
        selectPaymentOption(option);

    }

    private void showPaymentMethods() {
        for (int i = 0; i < paymentMethods.size(); i++) {
            PaymentMethod pm = paymentMethods.get(i);
            System.out.println("\t" + i + ") " + pm.name);
        }
    }

    private void selectPaymentOption(int option) {
        switch (option) {
            case 0: 
                cashSale();
                break;
            case 1:
                cardSale((Card)paymentMethods.get(option));
                break;
            case 2:
                cardSale((Card)paymentMethods.get(option));
                break;
            default: 
                System.out.println("Please choose an option with its number");
                break;
        }
    }

    private void cashSale() {
        System.out.println("How much cash do you have on hand?");
        Double cashOnHand = Double.parseDouble(System.console().readLine());
        System.out.println("Your change is: " + (cashOnHand - paymentAmount));
    }

    private void cardSale(Card card) {
        card.withdraw(paymentAmount);
        System.out.println(card.showInfo());
    }
}