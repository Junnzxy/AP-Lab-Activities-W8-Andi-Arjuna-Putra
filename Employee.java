package payable;

public abstract class Employee implements Payable {
    private final String name;
    public Employee(String name, String employeeId) {
        this.name = name;
    }

    public String getName() { return name; }

}