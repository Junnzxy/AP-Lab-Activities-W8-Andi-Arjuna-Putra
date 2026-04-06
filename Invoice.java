package payable;

public class Invoice implements Payable {
    private final int quantity;
    private final double pricePerItem;

    public Invoice(String part, int qty, double price) {
        this.quantity = qty;
        this.pricePerItem = price;
    }

    @Override
    public double getPaymentAmount() {
        return quantity * pricePerItem;
    }
}