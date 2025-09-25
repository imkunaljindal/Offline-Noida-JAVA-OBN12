import java.util.*;

class Solution {

    public int filling(int A[],int B[],int n) {

        for(int i=0;i<n;i++) {
            int j = i;
            int totalGas = 0;
            int count = 0;
            while(count!=n) {
                totalGas += A[j%n] - B[j%n];
                if(totalGas < 0) break;
                count++;
                j++;
            }
            if(count==n && totalGas>=0) {
                return i;
            }
        }

        return -1;
    }
}


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        sc.close();
        Solution Obj = new Solution();
        System.out.print(Obj.filling(a,b,n));
    }
}
