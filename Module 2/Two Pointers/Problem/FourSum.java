import java.util.*;
import java.io.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n;j++) {
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while(k<l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum==target) {
                        ArrayList<Integer> validNums = new ArrayList<>();
                        validNums.add(nums[i]);
                        validNums.add(nums[j]);
                        validNums.add(nums[k]);
                        validNums.add(nums[l]);
                        ans.add(validNums);
                        while(k<l && nums[k]==nums[k+1]) k++;
                        while(k<l && nums[l]==nums[l-1]) l--;
                        k++;
                        l--;
                    }
                    else if(sum < target) k++;
                    else l--;
                }
            }
        }
        return ans;
    }
}

public class FourSum
{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        List<List<Integer>> res = Obj.fourSum(nums, k);


        for(int i= 0; i<res.size(); i++){
            Collections.sort(res.get(i));
        }


        Collections.sort(res, new Comparator<List<Integer>>() {
            public int compare(List<Integer> frst, List<Integer> scnd) {
                int i=0;
                while(frst.get(i)==scnd.get(i)) i++;
                return frst.get(i)-scnd.get(i);
            }
        });

        for(int i=0; i<res.size(); i++){
            for(int j=0; j<4; j++){
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println("");
        }
        sc.close();
    }
}