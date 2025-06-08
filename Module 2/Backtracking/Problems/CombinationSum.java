package Problems;

import java.util.*;
class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        helper(nums,0,sum,ans,target);
        return ans;
    }

    static void helper(int[] nums, int idx, List<Integer> comb, List<List<Integer>> ans, int target) {

        if(target==0) {
            ans.add(new ArrayList<>(comb));
            return;
        }

        if(idx>=nums.length || target<0) {
            return;
        }

        comb.add(nums[idx]);
        helper(nums,idx,comb,ans,target-nums[idx]);
        comb.remove(comb.size()-1); // backtrack
        helper(nums,idx+1,comb,ans,target);
    }
}
public class CombinationSum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int []nums = new int[n];
        for(int i = 0 ; i < n ; ++i){
            nums[i] = sc.nextInt();
        }
        Solution ob = new Solution();
        List<List<Integer>> ans = ob.combinationSum(nums,target);
        for(int i = 0 ; i < ans.size() ; ++i){
            Collections.sort(ans.get(i));
        }
        Collections.sort(ans, (o1, o2) -> {
            int m = Math.min(o1.size(), o2.size());
            for (int i = 0; i < m; i++) {
                if (o1.get(i) == o2.get(i)){
                    continue;
                }else{
                    return o1.get(i) - o2.get(i);
                }
            }
            return 1;
        });
        for (int i = 0; i < ans.size (); i++)
        {
            for (int j = 0; j < ans.get(i).size (); j++)
            {
                System.out.print(ans.get(i).get(j)+" ");
            }
            System.out.println();

        }


    }
}