import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = input.nextInt();
        }
        Solution ob =new Solution();
        long ans = ob.maxSubarraySum(a,n);
        System.out.println(ans);
    }
}
class Solution{
    public long maxSubarraySum(int a[],int n){

        // max subarray sum
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        for(int i=0;i<n;i++) {
            sum += a[i];
            ans = Math.min(ans,sum);

            if(sum>0) sum = 0;
        }

        return ans;
    }
}