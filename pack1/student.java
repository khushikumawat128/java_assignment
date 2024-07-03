package pack1;

public class student {
    private int rollNo;
    private String name;

    public student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public void display() {
        System.out.println("Student Roll No: " + rollNo + ", Name: " + name);
    }
}