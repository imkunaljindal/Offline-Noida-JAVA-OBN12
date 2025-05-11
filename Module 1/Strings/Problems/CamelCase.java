package Problems;

import java.util.*;

class CamelCase {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            camelCase(s);
            System.out.println();

        }
    }

    static void camelCase(String s) {
        int n = s.length();

        for(int i=0;i<n;i++) {
            char c = s.charAt(i);
            if(c=='_') {
                char a = s.charAt(i+1);
                System.out.print((char)(a-32));
                i++;
            }
            else {
                System.out.print(c);
            }
        }
    }
}