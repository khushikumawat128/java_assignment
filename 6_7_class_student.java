class student{
	int rollNo;
	String name;
	double percentage;

	public student(int rollno,String name,double percentage){
		this.rollNo=rollNo;
		this.name=name;
		this.percentage=percentage;
	}

    // rollno
    public int getRollno() {
        return rollno;
    }
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    // name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // percentage
    public double getPercentage() {
        return percentage;
    }
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    //toString
	public String toString() {
        return "Student [rollno=" + rollno + ", name=" + name + ", percentage=" + percentage + "]";
    }
	public void displayDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Percentage: " + percentage);
        System.out.println();
    }
    public static void main(String[] args) {
        student s1 = new student(1, "Khushi", 85.5);
        student s2 = new student(2, "Riyaa", 78.2);
        student s3 = new student(3, "Ansh", 91.0);
        
        System.out.println("Details of Students:");
        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();
    }
}