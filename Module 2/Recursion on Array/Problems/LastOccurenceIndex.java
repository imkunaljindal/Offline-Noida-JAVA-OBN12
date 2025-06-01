package Problems;

import java.util.Scanner;

class LastOccurenceIndex {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = s.nextInt();
        }
        int T = s.nextInt();
        System.out.println(lastIndex(A, T, 0));
    }

    static int lastIndex(int A[],int T,int startIndex)
    {
        return solve(A,T,A.length);
    }

    static int solve(int A[], int T, int n) {
        if(n<=0) return -1;
        if(A[n-1]==T) return n-1;
        return solve(A,T,n-1);
    }
}