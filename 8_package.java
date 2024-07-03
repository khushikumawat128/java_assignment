import pack1.student;
import pack2.Batch;

class Main {
    public static void main(String[] args) {
        student student1 = new student(1, "Khushi");
        Batch batch = new Batch("IT", 80);

        student1.display();
        batch.display();
    }
}