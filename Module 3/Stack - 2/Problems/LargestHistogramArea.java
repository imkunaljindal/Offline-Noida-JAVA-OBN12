import java.util.*;
import java.lang.*;
import java.io.*;

class Main {


    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        long[] arr = new long[(int)n];
        for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
        System.out.println(new Solution().maximumArea(arr, n));
    }
}

class Solution {


    static long[] getNextSmallerElementOnLeft(long hist[]) {
        Stack<Integer> st = new Stack<>();
        int n = hist.length;
        long ans[] = new long[n];
        for(int i=n-1;i>=0;i--) {
            while(!st.isEmpty() && hist[i] < hist[st.peek()]) {
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            ans[st.peek()] = -1;
            st.pop();
        }

        return ans;
    }

    static long[] getNextSmallerElementOnRight(long hist[]) {
        Stack<Integer> st = new Stack<>();
        int n = hist.length;
        long ans[] = new long[n];
        for(int i=0;i<n;i++) {
            while(!st.isEmpty() && hist[i] < hist[st.peek()]) {
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            ans[st.peek()] = n;
            st.pop();
        }

        return ans;
    }

    public static long maximumArea(long hist[], long n) {

        long nextSmallerElementOnLeft[] = getNextSmallerElementOnLeft(hist);
        long nextSmallerElementOnRight[] = getNextSmallerElementOnRight(hist);

        long ans = -1;
        for(int i=0;i<n;i++) {
            long height = hist[i];
            long width = nextSmallerElementOnRight[i] - nextSmallerElementOnLeft[i] - 1;
            ans = Math.max(ans,height*width);
        }
        return ans;
    }
}