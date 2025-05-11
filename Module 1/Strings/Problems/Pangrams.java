package Problems;

import java.util.*;

public class Pangrams {
    public  static void isPangram(String s)
    {
        int freq[] = new int[26];
        int n = s.length();
        for(int i=0;i<n;i++) {
            char c = s.charAt(i);
            if((c>='a' && c<='z') || (c>='A' && c<='Z')) {
                int idx = 0;
                if(c>='a' && c<='z') {
                    idx = c-'a';
                }
                else  {
                    idx = c-'A';
                }
                freq[idx]++;
            }
        }

        for(int i=0;i<26;i++) {
            if(freq[i]==0) {
                System.out.println("Not Pangram");
                return;
            }
        }

        System.out.println("Pangram");
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        isPangram(s);

    }
}