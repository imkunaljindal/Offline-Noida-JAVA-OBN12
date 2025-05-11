package Problems;

import java.io.*;
import java.util.*;

public class StrangeStrings {
    static String strangeString(int n) {
        StringBuilder ans = new StringBuilder();
        int pos = 0;
        char c = 'a';
        for(int i=0;i<n;i++) {
            if(pos%2==0) {
                //shuru mein
                ans.insert(0,c);
            }
            else {
                //end mein
                ans.append(c);
            }
            pos++;
            c++;
            if(c>'z') {
                c = 'a';
            }

        }
        return ans.toString();
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0){
            int n = input.nextInt();
            System.out.println(strangeString(n));
        }
    }
}