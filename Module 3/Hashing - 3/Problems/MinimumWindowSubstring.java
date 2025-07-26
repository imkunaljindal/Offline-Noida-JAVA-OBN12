import java.io.*;
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        //1. freq array of t
        Map<Character,Integer> freqT = new HashMap<>()
        for(int i=0;i<t.length();i++) {
            char c = t.charAt(i);
            freqT.put(c,freqT.getOrDefault(c,0)+1);
        }

        int count = t.length();
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;

        while(end < s.length()) {
            char c = s.charAt(end);
            if(freqT[c-'A']>0) {
                count--;
            }
            freqT[c-'A']--;

            while(count==0) {
                if(end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    startIdx = start;
                }
                char x = s.charAt(start);
                freqT[x-'A']++;
                if(freqT[x-'A']>0) count++;
                start++;
            }
            end++;
        }

        if(startIdx==-1) return "";
        return s.substring(startIdx,startIdx+minLen);

    }
}

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s,t;
        s = sc.next();
        t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s,t));
    }
}