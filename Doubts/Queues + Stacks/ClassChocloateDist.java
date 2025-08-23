import java.util.*;

class Solution {
    public int distribution(int n, int[] nums,int k) {
        int ans = 0;
        while(true) {
            for(int i=0;i<n;i++) {
                if(nums[i]!=0) {
                    ans++;
                    nums[i]--;
                }
                if(i==k && nums[i]==0) return ans;
            }
        }
    }
}
public class Main{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();
        Solution Obj = new Solution();
        int a=Obj.distribution(n,arr,k);
        System.out.print(a+" ");
    }
}