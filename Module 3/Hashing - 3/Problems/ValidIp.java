package Problems;

import jdk.jshell.EvalException;

import java.util.*;

class Solution1{

    static void helper(String s, ArrayList<String> ans, int idx, String currentIp, int dots) {
        if(dots>3) {
            ans.add(currentIp);
            return;
        }

        for(int i=1;i<=3;i++) {
            if(idx+i>=s.length()) break;
            String currNum = s.substring(idx,idx+i); // "2" , "25", "255"

            if((currNum.startsWith("0") && currNum.length()>1) || (Integer.parseInt(currNum)>255)) continue;
            if(dots==3) {
                if(Integer.parseInt(s.substring(idx))>255) continue;
                helper(s,ans,idx+i,currentIp+s.substring(idx),dots+1);
            }
            else helper(s,ans,idx+i,currentIp+currNum+".",dots+1);
        }
    }

    public static ArrayList<String> ValidIP(String s){
        ArrayList<String> ans = new ArrayList<>();
        helper(s,ans,0,"",0);
        return ans;
    }
}

public class ValidIp {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Solution1 obj = new Solution1();
        ArrayList<String> ans = obj.ValidIP(s);
        for(String i:ans){
            System.out.println(i);
        }
    }
}