import java.util.HashSet;
import java.util.Set;
import java.util.Comparator;
import java.util.*;
class Student implements Comparable<Student>{
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
    public Student(int rollNo, String name, double percentage) {
        this.rollNo = rollNo;
        this.name = name;
        this.percentage = percentage;
    }

    public void addSkill(String skill) {
        skillset.add(skill);
    }
        public double getPercentage() {
        return percentage;
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
        // Comparator for comparing students by percentage
    public static Comparator<Student> PercentageComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            // Sort in descending order of percentage
            if (s1.getPercentage() < s2.getPercentage()) {
                return 1;
            } else if (s1.getPercentage() > s2.getPercentage()) {
                return -1;
            } else {
                return 0;
            }
        }
    };
    //comparable 
    public int compareTo(Student otherstudent){
        if(this.percentage<otherstudent.percentage){
           /* System.out.print(this.percentage+"<"+otherstudent.percentage);*/
            return 1;
        }
        else if(this.percentage>otherstudent.percentage){
           /* System.out.println(this.percentage+">"+otherstudent.percentage);*/
            return -1;
        }
        else{
            return 0;
        }
    }
    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
