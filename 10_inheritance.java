class Main {
    public static void main(String[] args) {
        // Creating Date object
        Date dob1 = new Date(12, 8, 2004);
        Date dob2 = new Date(25, 12, 1983);

        // Creating WageEmployee object
        WageEmployee wageEmployee = new WageEmployee(1, "Khushi", dob1, 40, 100);

        // Creating SalesPerson object
        SalesPerson salesPerson = new SalesPerson(2, "Riya", dob2, 40, 15.50, 100, 2.50);

        // Displaying details and calculating salaries
        System.out.println("Wage Employee Details:");
        wageEmployee.display();
        System.out.println("Salary: " + wageEmployee.calculateSalary());

        System.out.println("\nSales Person Details:");
        salesPerson.display();
        System.out.println("Salary: " + salesPerson.calculateSalary());
    }
}
class Employee {
    private int employeeId;
    private String name;
    private Date dateOfBirth;

    // Constructor
    public Employee(int employeeId, String name, Date dateOfBirth) {
        this.employeeId = employeeId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    // Display method
    public void display() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.print("Date of Birth: ");
        dateOfBirth.display();
    }
}
class WageEmployee extends Employee {
    private int hoursWorked;
    private double ratePerHour;

    // Constructor
    public WageEmployee(int employeeId, String name, Date dateOfBirth, int hoursWorked, double ratePerHour) {
        super(employeeId, name, dateOfBirth);
        this.hoursWorked = hoursWorked;
        this.ratePerHour = ratePerHour;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Rate per Hour: " + ratePerHour);
    }

    // Calculate salary
    public double calculateSalary() {
        return hoursWorked * ratePerHour;
    }
}
class SalesPerson extends WageEmployee {
    private int itemsSold;
    private double commissionPerItem;

    // Constructor
    public SalesPerson(int employeeId, String name, Date dateOfBirth, int hoursWorked, double ratePerHour, int itemsSold, double commissionPerItem) {
        super(employeeId, name, dateOfBirth, hoursWorked, ratePerHour);
        this.itemsSold = itemsSold;
        this.commissionPerItem = commissionPerItem;
    }

    public void display() {
        super.display();
        System.out.println("Items Sold: " + itemsSold);
        System.out.println("Commission per Item: " + commissionPerItem);
    }

    // calculate salary method
    public double calculateSalary() {
        return super.calculateSalary() + (itemsSold * commissionPerItem);
    }
}
class Date {
    private int day;
    private int month;
    private int year;

    // Constructor
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Display method
    public void display() {
        System.out.println(day + "/" + month + "/" + year);
    }
}