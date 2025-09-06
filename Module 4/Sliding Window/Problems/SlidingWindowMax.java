import java.util.*;

class Solution{
    static int[] SlidingWindowMaximum(int N, int K, int[] arr){
       Deque<Integer> dq = new ArrayDeque<>();
       int ans[] = new int[N-K+1];
       int r = 0;

       for(int i=0;i<N;i++) {

           // remove the elements out of range
           // remove the indexes less than i-K+1;
           while(!dq.isEmpty() && dq.peekFirst() < i-K+1) {
               dq.pollFirst();
           }

           // knock the elements which are smaller than a[i]
           while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
               dq.pollLast();
           }

           dq.offer(i);
           // max will always be at peak
           if(i>=K-1)
           ans[r++] = arr[dq.peekFirst()];
       }

       return ans;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[]=new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans=obj.SlidingWindowMaximum(n,k,nums);
        for(int i=0;i<ans.length;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
