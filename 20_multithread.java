import java.util.Scanner;

// Class for incrementing values
class Incrementer implements Runnable {
    private int number;

    public Incrementer(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Incremented values:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + i);
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Class for multiplication table
class Multiplier implements Runnable {
    private int number;

    public Multiplier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Multiplication table:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        Thread t1 = new Thread(new Incrementer(number));
        Thread t2 = new Thread(new Multiplier(number));

        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Both threads have finished execution.");
    }
}
