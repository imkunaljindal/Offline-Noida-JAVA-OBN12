import java.io.*;
import java.util.*;

class Solution
{

    public static void helper(int[] nums, int index, List < Integer > ds, HashSet<List<Integer>> res) {
        if (index == nums.length) {
            // Add a copy of ds to result - don't add ds itself because it's mutable
            res.add(new ArrayList<>(ds));
            return;
        }
        // Include nums[index]
        ds.add(nums[index]);
        helper(nums, index + 1, ds, res);

        // Exclude nums[index]
        ds.remove(ds.size() - 1);
        helper(nums, index + 1, ds, res);
    }

    static int[][] solve(int n, int[] nums){
        Arrays.sort(nums);  // Sort first to generate sorted subsets directly
        HashSet<List<Integer>> res = new HashSet<>();
        List<Integer> ds = new ArrayList<>();
        helper(nums, 0, ds, res);

        int[][] ans = new int[res.size()][];
        int i = 0;
        for (List<Integer> x : res) {
            ans[i] = new int[x.size()];
            for (int j = 0; j < x.size(); j++) {
                ans[i][j] = x.get(j);
            }
            i++;
        }
        return ans;

    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        String[] arr_nums = br.readLine().split(" ");
        int[] nums = new int[n];
        for(int i_nums = 0; i_nums < arr_nums.length; i_nums++)
        {
            nums[i_nums] = Integer.parseInt(arr_nums[i_nums]);
        }

        int[][] out_ = Solution.solve(n, nums);
        for(int i_out_ = 0; i_out_ < out_.length; i_out_++)
        {
            System.out.print(out_[i_out_][0]);
            for(int j_out_ = 1; j_out_ < out_[i_out_].length; j_out_++)
            {
                System.out.print(" " + out_[i_out_][j_out_]);
            }
            System.out.println("");
        }

        wr.close();
        br.close();
    }

}