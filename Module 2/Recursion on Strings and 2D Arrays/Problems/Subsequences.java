package Problems;

import java.util.*;
import java.util.Scanner;

public class Subsequences{
    static void helper(String s, int idx, String ans) {
        if(idx>=s.length()) {
            System.out.println(ans);
            return;
        }

        //option 1 - Not take
        helper(s,idx+1,ans);
        //option 2 - take
        helper(s,idx+1,ans+s.charAt(idx));
    }

    static void printSubsequence(String s) {
        helper(s,0,"");
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        printSubsequence(s);
    }
}