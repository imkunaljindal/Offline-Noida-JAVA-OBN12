package Problems;

import java.util.*;

public class GetStairPaths {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<String> paths = getStairPaths(n);
        System.out.println(paths);
    }

    public static void helper(int n, ArrayList<String> ans, String path) {
        if(n<0) return;
        if(n==0) {
            ans.add(path);
            return;
        }

        helper(n-1,ans,path+'1');
        helper(n-2,ans,path+'2');
        helper(n-3,ans,path+'3');
    }

    public static ArrayList<String> getStairPaths(int n) {
        ArrayList<String> ans = new ArrayList<>();
        helper(n,ans,"");
        return ans;
    }
}


                        
                                