package Problems;

import java.util.*;
class Accio {

    public void printPermutations(String str) {
        char[] strChar = str.toCharArray(); // "bca" -> ['b','c','a']
        Arrays.sort(strChar); // ['a','b','c']
        String sortedStr = new String(strChar);  //"abc"
        Set<String> ans = new TreeSet<>();
        helper(sortedStr,"",ans);
        for(String s: ans) {
            System.out.println(s);
        }
    }
    static void helper(String str, String perm, Set<String> ans) {
        if(str.length()==0) {
            ans.add(perm);
            return;
        }

        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            String rem = str.substring(0,i) + str.substring(i+1);
            helper(rem,perm+c,ans);
        }
    }
}

public class StringPermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Accio Obj = new Accio();
        Obj.printPermutations(str);
    }
}