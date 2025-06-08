import java.util.*;

public class Main {
    public static void printEncodings(String str) {
        Set<String> ans = new TreeSet<>();
        helper(str, 0, "", ans);
        for (String s : ans) {
            System.out.println(s);
        }
    }

    static void helper(String str, int idx, String aux, Set<String> ans) {
        if(idx>=str.length()) {
            ans.add(aux);
            return;
        }

        if(str.charAt(idx)=='0') return;

        char c = (char)((str.charAt(idx) - '1') + 'a');
        helper(str,idx+1,aux+c,ans);

        if(idx+1<=str.length()-1) {
            int num = (str.charAt(idx) - '0')*10 + (str.charAt(idx+1)-'0');
            if(num<=26) {
                char x = (char)(num+'a'-1);
                helper(str,idx+2,aux+x,ans);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printEncodings(str);
    }
}