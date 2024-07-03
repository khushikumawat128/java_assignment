import java.util.Scanner;
class matrix{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int[][] mat = new int[3][3];
	System.out.println("Enter number which is to be added in matrix 3x3 :-");
	for (int i=0;i<=2;i++) {
		for (int j=0;j<=2 ;j++) {
			mat[i][j]=sc.nextInt();
			}
		}
	System.out.println("The first 3x3 matrix:");
	for (int[] row : mat) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    int[][] transposeMatrix = new int[3][3];
        
        for (int i = 0; i <=2; i++) {
            for (int j = 0; j <=2; j++) {
                transposeMatrix[j][i] = mat[i][j];
            }
        }
    System.out.println("The transpose of the first matrix:");
    for (int i = 0; i <=2; i++) {
            for (int j = 0; j <=2; j++) {
                System.out.print(transposeMatrix[i][j] + " ");
            }
            System.out.println();
        }
    int[][] mat2 = new int[3][3];
	System.out.println("Enter number which is to be added in 2 matrix 3x3 :-");
	for (int i=0;i<=2;i++) {
		for (int j=0;j<=2 ;j++) {
			mat2[i][j]=sc.nextInt();
			}
		}
	System.out.println("The Second 3x3 matrix:");
	for (int[] row : mat2) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    int[][] sumMatrix= new int[3][3];
    for (int i = 0; i <=2; i++) {
            for (int j = 0; j <=2; j++) {
                sumMatrix[i][j] = mat[i][j] + mat2[i][j];
            }
        }
    System.out.println("The Addition of the first and second matrix:");
    for (int i = 0; i <=2; i++) {
            for (int j = 0; j <=2; j++) {
                System.out.print(sumMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}