package Problems;

import java.util.*;

public class NoX {

    static String helper(String s, int idx) {
        if(idx >= s.length()) {
            return "";
        }
        if(s.charAt(idx)!='x') {
            return s.charAt(idx) + helper(s,idx+1);
        }
        return helper(s,idx+1);
    }

    static String noX(String s) {
        return helper(s,0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        System.out.println(noX(s));
    }
}