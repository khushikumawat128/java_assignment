import java.util.HashSet;
import java.util.Set;

class Student {
    private int rollNo;
    private String name;
    private double percentage;
    private Set<String> skillset;

    public Student() {
        skillset = new HashSet<>();
    }

    public Student(int rollNo, String name, double percentage, Set<String> skillset) {
        this.rollNo = rollNo;
        this.name = name;
        this.percentage = percentage;
        this.skillset = skillset;
    }

    public void addSkill(String skill) {
        skillset.(skill);
    }

    public void displayDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Percentage: " + percentage);
        System.out.print("Skillset: ");
        for (String skill : skillset) {
            System.out.print(skill + ", ");
        }
        System.out.println();
    }
}
