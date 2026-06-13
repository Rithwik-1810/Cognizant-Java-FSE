public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentStrategy creditCard = new CreditCardPayment("John Doe", "1234567812345678");
        PaymentContext context = new PaymentContext(creditCard);

        System.out.println("--- Paying with Credit Card ---");
        context.executePayment(250.00);

        System.out.println("\n--- Switching to PayPal ---");
        context.setStrategy(new PayPalPayment("johndoe@example.com"));
        context.executePayment(99.99);
    }
}
