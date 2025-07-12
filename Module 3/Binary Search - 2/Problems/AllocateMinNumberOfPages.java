import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    static boolean isPossible(int A[], long maxPages, int B) {
        int students = 1;
        long currPages = 0;

        for(int i=0;i<A.length;i++) {
            if(currPages+A[i]<=maxPages) {
                currPages += A[i];
            }
            else {
                students++;
                if(A[i]>maxPages || students > B) return false;
                currPages = A[i];
            }
        }

        return true;
    }

    public long MinimumPages(int[] A, int B) {

        if(B > A.length) return -1;

        long sum = 0;
        for(int x: A) sum += x;
        long s = 0;
        long e = sum;
        long ans = -1;
        while(s<=e) {
            long mid = s + (e-s)/2;
            if(isPossible(A,mid,B)) {
                ans = mid;
                e = mid-1;
            }
            else s = mid+1;
        }

        return ans;
    }
}

class Main {


    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++)
            A[i] = sc.nextInt();

        Solution Obj = new Solution();
        System.out.println(Obj.MinimumPages(A,B));
    }
}