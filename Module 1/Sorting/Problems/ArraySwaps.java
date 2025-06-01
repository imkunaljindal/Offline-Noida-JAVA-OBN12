import java.io.*;
import java.util.*;
public class Main {
    static String arraySwaps(int arr[],int n,int x)
    {
        int b[] = new int[n];
        for(int i=0;i<n;i++) {
            b[i] = arr[i];
        }

        Arrays.sort(b);
        for(int i=0;i<n;i++) {
            if(arr[i]!=b[i] && i<x && n-1-i<x) {
                return "NO";
            }
        }
        return "YES";

    }
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        String ans = arraySwaps(a,n,x);
        System.out.println(ans);
    }
}