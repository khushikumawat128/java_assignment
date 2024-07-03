import java.util.Scanner;
class armstrong{
	static boolean yes(int n){
        int originalNumber, remainder, result = 0;
        originalNumber = n;
        while (originalNumber != 0) {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, 3);
            originalNumber /= 10;
        }
        if (result == n)
            return true;
        else
            return false;
    }
public static void main(String[] args) {
		int num;
		Scanner sc= new Scanner(System.in);
		System.out.println("Check weather given no is Armstrong or Not");
		System.out.println("Enter no :-");
		num=sc.nextInt();
		if (yes(num)){
			System.out.println("The number is Armstrong.");
		}
		else{
			System.out.println("The number is not a Armstrong.");
		}
	}
}