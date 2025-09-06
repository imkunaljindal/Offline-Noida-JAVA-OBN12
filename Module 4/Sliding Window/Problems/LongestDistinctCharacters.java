import java.io.*;
import java.util.*;

class Solution {
    public static int longestUniqueSubsttr(String str)
    {
        int ans = 0;
        int left = 0;
        int right = 0;

        boolean []isVisited = new boolean[26];
        int starIdx = -1;

        while(right < str.length()) {
            char c = str.charAt(right);
            //contraction
            while(isVisited[c-'a']) {
                isVisited[str.charAt(left)-'a'] = false;
                left++;
            }
            // expansion
            isVisited[c-'a'] = true;
            ans = Math.max(ans,right-left+1);
            right++;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Solution obj = new Solution();
        int len = obj.longestUniqueSubsttr(str);
        System.out.println(len);
    }
}

