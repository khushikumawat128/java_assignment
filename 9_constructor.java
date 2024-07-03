class Main{
	public static void main(String[] args) {
		//detail of 1 student
		date dob1 = new date(12,8,2004);
		Student  student1= new Student();
		student1.accept("Khushi",dob1);
		//detail of 2 student
		date dob2 = new date(30,7,2003);
		Student  student2= new Student();
		student2.accept("akshit",dob2);
		//Dislaying them 
		System.out.println("Details of Student : ");
		student1.display();
		System.out.println("Detail of 2 Student : ");
		student2.display();
	}

}
class date{
	private int day;
	private int month;
	private int year;

	//Default constructor
	public date(){
		this.day=1;
		this.month=1;
		this.year=2000;
	}
	//praameterized constructor
	public date(int day, int month,int year){
		this.day=day;
		this.month=month;
		this.year=year;
	}
	//accept constructor
	public void accept(int day,int month,int year){
		this.day=day;
		this.month=month;
		this.year=year;
	}
	//display constructor
	public void display(){
		System.out.println(day+"/"+month+"/"+year);
	}

}
class Student{
	private static int next_roll_no =1;
	private int rollNo;
	private String name;
	private date dob;

	//default constructor
	public Student(){
		this.rollNo=next_roll_no++;
		this.name="";
		this.dob=dob;
	}
	//parameterized constructor
	public Student(String name,date dob){
		this.rollNo=next_roll_no++;
		this.name=name;
		this.dob=dob;
	}

	//accept constructor
	public void accept (String name,date dob){
		this.name=name;
		this.dob=dob;
	}

	//display consructor
	public void display(){
		System.out.println("Roll No : "+rollNo);
		System.out.println("Name : "+name);
		System.out.print("Date of Birth : ");
		dob.display();
	}
}
