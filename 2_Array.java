import java.util.Scanner;
class Array{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int[] arr = new int[5];
	System.out.println("Enter 5 number which is to be added in Array :-");
	for (int i=0;i<=4;i++) {
			arr[i]=sc.nextInt();
		}	
	int max = arr[0];
    int min = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
    System.out.println("1.Finding Max and Min number in Array:-");
    System.out.println("Maximum No :- "+max);
    System.out.println("Minimum No :- "+min);

    int[] multiArray = new int[5];

    for(int i=0;i<=4;i++){
    	multiArray[i]=arr[i]*5;
    }
    System.out.println("2.Print Array multipled by 5 :- ");
    for (int i=0;i<=4;i++) {
			System.out.print("["+multiArray[i]+"]");
		}
	}
}