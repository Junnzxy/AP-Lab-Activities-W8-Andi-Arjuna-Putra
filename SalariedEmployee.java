package payable;

    public class SalariedEmployee extends Employee {
        private final double weeklySalary;

        public SalariedEmployee(String name, String id, double salary) {
            super(name, id);
            this.weeklySalary = salary;
        }

        @Override
        public double getPaymentAmount() {
            return weeklySalary;
        }
}