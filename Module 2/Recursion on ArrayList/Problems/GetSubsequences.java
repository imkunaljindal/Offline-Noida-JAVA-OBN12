package Problems;

import java.io.*;
import java.util.*;

public class GetSubsequences {
    public static ArrayList<String> generateSubsequences(String str)
    {
        ArrayList<String> ans = new ArrayList<>();
        helper(str,ans,"",0);
        Collections.sort(ans);
        return ans;
    }

    public static void helper(String str, ArrayList<String> ans,
                              String subSeq, int idx) {
        if (idx >= str.length()) {
            if (subSeq != "") {
                ans.add(subSeq);
            }
            return;
        }
        helper(str,ans,subSeq,idx+1);
        helper(str,ans,subSeq+str.charAt(idx),idx+1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        s = sc.nextLine();
        ArrayList<String> res = generateSubsequences(s);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}