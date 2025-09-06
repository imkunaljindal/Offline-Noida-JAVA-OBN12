import java.util.*;

class Solution {
    static int getDistichChars(String s) {
        int unique = 0;
        boolean isVisited[] = new boolean[26];
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(!isVisited[c-'a']) {
                isVisited[c-'a'] = true;
                unique++;
            }
        }
        return unique;
    }

    public int longestSubstring(String s, int k) {
        // Step 1 - calculate total dictinct char
        int distinctChars = getDistichChars(s);
        int ans = 0;
        for (int unique = 1; unique <= distinctChars; unique++) {
            int left = 0, right = 0, currUnique = 0, atleastKTimes = 0;
            int freq[] = new int[26];
            while (right < s.length()) {
                char c = s.charAt(right);
                if (currUnique <= unique) {
                    //expand
                    freq[c-'a']++;
                    if(freq[c-'a']==1) currUnique++;
                    if(freq[c-'a']==k) atleastKTimes++;
                    right++;
                } else {
                    //shrink
                    char x = s.charAt(left);
                    freq[x-'a']--;
                    if(freq[x-'a']==0) currUnique--;
                    if(freq[x-'a']<k && atleastKTimes>0) atleastKTimes--;
                    left++;
                }

                if(currUnique==unique && atleastKTimes==unique) {
                    ans = Math.max(ans,right-left);
                }

            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubstring(str,k));
    }
}
