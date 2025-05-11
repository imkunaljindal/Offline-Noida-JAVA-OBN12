package Problems;

import java.util.*;

public class StringToIntegerArray {

    static ArrayList<Integer> arrayGenerator(String s){
        String[] nums = s.split(",");
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<nums.length;i++) {
            int x = Integer.parseInt(nums[i]);
            ans.add(x);
        }

        return ans;

    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        while (t-- > 0) {
            String s = input.nextLine();
            ArrayList<Integer> ans = arrayGenerator(s);
            System.out.print("[");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i));
                if (i != ans.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }

    }
}
