package Problems;

import java.util.*;

class AllSubstringOfAString {
    static void SubString(String str) {
        //Write code here
        int n = str.length();

        for(int i=0;i<n;i++) {
            String s = "";
            for(int j=i;j<n;j++) {
                s = s+str.charAt(j);
                System.out.println(s);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        SubString(str);
    }
}