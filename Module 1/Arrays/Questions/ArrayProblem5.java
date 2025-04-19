package Questions;

import java.util.Scanner;

public class ArrayProblem5 {

    public static int ArrayProblem(int []arr,int k){
        int count = 0;
        int n = arr.length;
        for(int i=0;i<n-1;i++) {
            int sum = arr[i] + arr[i+1];
            if(sum==k) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;++i){
            arr[i]=sc.nextInt();
        }
        System.out.println(ArrayProblem(arr,k));
    }

}
