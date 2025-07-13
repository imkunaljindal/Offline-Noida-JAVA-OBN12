import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{

    static boolean isPossible(int A[], long weight, int B) {
        int day = 1;
        long currWeight = 0;

        for(int i=0;i<A.length;i++) {
            if(currWeight + A[i] <= weight) {
                currWeight += A[i];
            }
            else {
                day++;
                if(A[i]>weight) return false;
                currWeight = A[i];
            }
        }

//        if(day <= B) return true;
//        return false;
        return day<=B;
    }

    public static long solve(int[] A, int B) {
        long sum = 0;
        for(int x: A) sum += x;

        long s = 0;
        long e = sum;

        long ans = -1;
        while(s<=e) {
            long mid = s + (e-s)/2;
            if(isPossible(A,mid,B)) {
                ans = mid;
                //System.out.print(mid + " ");
                e = mid-1;
            }
            else s = mid+1;
        }
        return ans;
    }
}

class CapacityToShip {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0;i<n;i++){
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        System.out.println(Solution.solve(A,B));
    }
}