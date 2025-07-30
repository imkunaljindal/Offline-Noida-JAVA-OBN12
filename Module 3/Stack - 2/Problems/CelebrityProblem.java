import java.io.*;
import java.util.*;

class Main{
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M[][] = new int[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                M[i][j] = sc.nextInt();
        System.out.println(new Solution().findCelebrity(M,N));
    }
}
class Solution
{
    int findCelebrity(int M[][], int n)
    {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++) {
            st.push(i);
        }

        while(st.size() > 1) {
            int i = st.pop();
            int j = st.pop();
            if(M[i][j]==0) {
                st.push(i);
            }
            else st.push(j);
        }

        int potentialCeleb = st.pop();

        // M[pc][j] = 0
        for(int j=0;j<n;j++) {
            if(M[potentialCeleb][j]==1)
                return -1;
        }

        //M[i][pc] = 1 except i==pc
        for(int i=0;i<n;i++) {
            if(M[i][potentialCeleb]==0 && (i!=potentialCeleb))
                return -1;
        }

        return potentialCeleb;
    }

}