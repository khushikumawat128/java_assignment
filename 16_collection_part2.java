import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        UtilityList utility = new UtilityList(); // Correct instantiation

        utility.createList(); // Use the instance to call non-static methods
        utility.printList();
    }
}

class UtilityList {
    private List<Student> list;

    public UtilityList() {
        this.list = new ArrayList<>();
    }

    public void createList() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students:");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("Roll No: ");
            int rollNo = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Percentage: ");
            double percentage = sc.nextDouble();
            sc.nextLine();

            Set<String> skillset = new HashSet<>();
            System.out.println("Enter number of skills for student " + (i + 1) + ":");
            int numSkills = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < numSkills; j++) {
                System.out.print("Enter skill " + (j + 1) + ": ");
                String skill = sc.nextLine();
                skillset.add(skill);
            }

            Student student1 = new Student(rollNo, name, percentage, skillset);
            list.add(student1);
        }
    }

    public void printList() {
        System.out.println("List of Students:");
        for (Student student : list) {
            student.displayDetails();
            System.out.println();
        }
    }
}
