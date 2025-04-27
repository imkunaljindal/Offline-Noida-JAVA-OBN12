import java.util.Scanner;

public class Concept {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int a[][] = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                a[i][j] = sc.nextInt();
            }
        }
        // 4 X 3
        int arr[][] = {{1,2,3}
                ,{4,5,6}
                ,{7,8,9},
                {1,2,3}};

        int rows = arr.length;
        int cols = arr[0].length;
        for(int r=0;r<rows;r++) {
            for(int c=0;c<cols;c++) {
                System.out.print(arr[r][c]+ " ");
            }
            System.out.println();
        }

    }
}
