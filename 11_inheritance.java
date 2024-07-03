class Main {
    public static void main(String[] args) {
        // Creating Manager object
        Manager manager = new Manager(1, "Khushi", 50000);

        // Creating MarketingExecutive object
        MarketingExecutive marketingExecutive = new MarketingExecutive(2, "Ridhima", 40000, 100);

        // Print objects using printObjects method
        printObjects(manager);
        System.out.println();
        printObjects(marketingExecutive);
    }

    public static void printObjects(Employee e) {
        e.display();
    }
}
class Employee {
    private int employeeId;
    private String name;
    private double basicSalary;

    public Employee(int employeeId, String name, double basicSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    // Display method
    public void display() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
    }
     public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }
}

class Manager extends Employee {
    public Manager(int employeeId, String name, double basicSalary) {
        super(employeeId, name, basicSalary);
    }

    // Calculate allowances
    private double calculatePetrolAllowance() {
        return 0.08 * getBasicSalary();
    }

    private double calculateFoodAllowance() {
        return 0.12 * getBasicSalary();
    }

    private double calculateOtherAllowance() {
        return 0.04 * getBasicSalary();
    }

    // Calculate gross salary
    public double calculateGrossSalary() {
        return getBasicSalary() + calculatePetrolAllowance() + calculateFoodAllowance() + calculateOtherAllowance();
    }

    // Calculate net salary
    public double calculateNetSalary() {
        double pf = 0.125 * getBasicSalary();
        return calculateGrossSalary() - pf;
    }

    // display method
    public void display() {
        super.display();
        System.out.println("Petrol Allowance: " + calculatePetrolAllowance());
        System.out.println("Food Allowance: " + calculateFoodAllowance());
        System.out.println("Other Allowance: " + calculateOtherAllowance());
        System.out.println("Gross Salary: " + calculateGrossSalary());
        System.out.println("Net Salary: " + calculateNetSalary());
    }
}

class MarketingExecutive extends Employee {
    private int kilometersTravelled;

    public MarketingExecutive(int employeeId, String name, double basicSalary, int kilometersTravelled) {
        super(employeeId, name, basicSalary);
        this.kilometersTravelled = kilometersTravelled;
    }

    // Calculate allowances
    private double calculateTourAllowance() {
        return 5 * kilometersTravelled;
    }

    private double calculateTelephoneAllowance() {
        return 2000;
    }

    // Calculate gross salary
    public double calculateGrossSalary() {
        return getBasicSalary() + calculateTourAllowance() + calculateTelephoneAllowance();
    }

    // Calculate net salary
    public double calculateNetSalary() {
        double pf = 0.125 * getBasicSalary();
        return calculateGrossSalary() - pf;
    }

    //display method
    public void display() {
        super.display();
        System.out.println("Kilometers Travelled: " + kilometersTravelled);
        System.out.println("Tour Allowance: " + calculateTourAllowance());
        System.out.println("Telephone Allowance: " + calculateTelephoneAllowance());
        System.out.println("Gross Salary: " + calculateGrossSalary());
        System.out.println("Net Salary: " + calculateNetSalary());
    }

    public int getKilometersTravelled() {
        return kilometersTravelled;
    }
}
