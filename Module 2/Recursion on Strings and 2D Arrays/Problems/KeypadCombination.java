package Problems;

import java.io.*;
import java.util.*;

public class KeypadCombination {

    static void helper(String s, int idx, String ans) {
        if(idx>=s.length()) {
            System.out.println(ans);
            return;
        }

        char currentChar = s.charAt(idx);
        if(currentChar=='0') {
            helper(s,idx+1,ans+'.');
            helper(s,idx+1,ans+';');
        }
        else if(currentChar=='1') {
            helper(s,idx+1,ans+'a');
            helper(s,idx+1,ans+'b');
            helper(s,idx+1,ans+'c');
        }
        else if(currentChar=='2') {
            helper(s,idx+1,ans+'d');
            helper(s,idx+1,ans+'e');
            helper(s,idx+1,ans+'f');
        }
        else if(currentChar=='3') {
            helper(s,idx+1,ans+'g');
            helper(s,idx+1,ans+'h');
            helper(s,idx+1,ans+'i');
        }
        else if(currentChar=='4') {
            helper(s,idx+1,ans+'j');
            helper(s,idx+1,ans+'k');
            helper(s,idx+1,ans+'l');
        }
        else if(currentChar=='5') {
            helper(s,idx+1,ans+'m');
            helper(s,idx+1,ans+'n');
            helper(s,idx+1,ans+'o');
        }
    }

    static void printKPC(String ques) {
        helper(ques,0,"");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.nextLine();
        printKPC(str);
    }
}