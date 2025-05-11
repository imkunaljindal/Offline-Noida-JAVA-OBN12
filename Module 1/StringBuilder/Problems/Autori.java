package Problems;

import java.io.*;
import java.util.*;

public class Autori {
    static String autori(String str){
        String s[] = str.split("-");
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length;i++) {
            String sr = s[i];
            ans.append(sr.charAt(0));
        }

        return ans.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.next();
        String result = autori(str);
        System.out.print(result);
        System.out.println('\n');
    }
}