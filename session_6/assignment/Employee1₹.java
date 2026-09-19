public class Employee1
 {
    private String empName;
    private double salary;

    public static String companyName = "Bright Horizon Technologies";
    public static int employeeCount = 0;

    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new Employee("Amit", 50000);
        new Employee("Neha", 60000);
        new Employee("Rohan", 55000);

        // Calling through the class name, not an instance
        Employee.printCompanyInfo();
    }
}