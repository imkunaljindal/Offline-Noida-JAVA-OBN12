import java.util.Scanner;

public class ConceptOfDiagonal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[][] = new int[n][n];

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Major diagonal
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i==j) {
                    System.out.print(arr[i][j] + " ");
                }
            }
        }

        // Reverse Major/ Anti Diagoanl
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i+j==n-1) {
                    System.out.print(arr[i][j] + " ");
                }
            }
        }
    }
}
