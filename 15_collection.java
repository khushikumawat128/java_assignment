import java.util.ArrayList;
import java.util.Scanner;

class employee{
	private int empId;
	private String empName;
	private double basicSalary;
	//default
	public employee(){}
	//parameterized
	public employee(int empId,String empName,double basicSalary){
		this.empId=empId;
		this.empName=empName;
		this.basicSalary=basicSalary;
	}
	//Accept Detail of employee
	public void acceptDetails(){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Employee ID :");
		this.empId=sc.nextInt();
		sc.nextLine(); // Consume newline
		System.out.print("Enter Employee Name :");
		this.empName=sc.nextLine();
		System.out.print("Enter Employee Salary :");
		this.basicSalary=sc.nextDouble();
	}
	//Display Detail of Employee
	public void displayDetails(){
		System.out.println("Employee ID : "+empId);
		System.out.println("Employee Name : "+empName);
		System.out.println("Employee Salary : "+basicSalary);
	}
	//get  empid
	int getEmpID(){
		return empId;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<employee> emp = new ArrayList<>();
		while(true){
			System.out.println("/n Menu");
			System.out.println("1. Insert Record");
			System.out.println("2. Update Record");
			System.out.println("3. Display All Record");
			System.out.println("4. Exit");
			System.out.print("Enter Your Choice :");
			int choice = sc.nextInt();

			switch(choice){
				case 1:
					employee addEmp = new employee();
					addEmp.acceptDetails();
					emp.add(addEmp);
				break;
				case 2:
					System.out.println("Enter Employee ID which is to be Update :");
					int updateEmpId = sc.nextInt();
					boolean found = false;
					for (employee e : emp) {
						if(e.getEmpID() == updateEmpId){
							e.acceptDetails();
							found = true;
							break;
						}
					}
					if(!found){
						System.out.println("Employee with ID" + updateEmpId+" not found.");
					}
				break;
				case 3:
					for(employee e: emp){
						e.displayDetails();
						System.out.println();
					}
				break;
				case 4:
					System.out.println("Exiting the Program..Thank you for visiting! ");
				return;
				default:
					System.out.println("Invalid choice...Please try again!!! ");
			}
		}
	}

}