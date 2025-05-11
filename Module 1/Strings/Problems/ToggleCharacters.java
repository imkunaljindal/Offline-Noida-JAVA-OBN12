package Problems;

import java.util.*;

public class ToggleCharacters {

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        toggleCase(n, str);
    }

    static void toggleCase(int n, String str) {

        String ans = "";
        for(int i=0;i<n;i++) {
            char c = str.charAt(i);
            if(c >= 'a' && c<='z') {
                ans = ans + (char)(c-32);
            }
            else if(c>='A' && c<='Z') {
                // capital
                ans = ans + (char)(c+32);
            }
            else {
                ans = ans + c;
            }
        }

        System.out.println(ans);
    }
}