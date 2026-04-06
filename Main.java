package payable;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Payable> accountsPayable = new ArrayList<>();

        accountsPayable.add(new SalariedEmployee("Alice Smith", "E001", 1200.00));
        accountsPayable.add(new Invoice("Widget-99", 5, 20.00));
        accountsPayable.add(new SalariedEmployee("Bob Jones", "E002", 1500.00));
        accountsPayable.add(new Invoice("Hammer-01", 2, 15.50));

        System.out.println("Payments due:");
        for (Payable item : accountsPayable) {
            System.out.printf("%.2f%n", item.getPaymentAmount());
        }
    }
}