package Problems;

import java.io.*;

public class CompressedStrings {
    static void compressedString(String s) {
        int n = s.length();
        String ans = "";
        int count = 1;
        for(int i=0;i<n-1;i++) {
            if(s.charAt(i)==s.charAt(i+1)) {
                count++;
            }
            else {
                ans = ans + s.charAt(i);
                if(count>1) {
                    ans = ans + count;
                }
                count = 1;
            }
        }

        // last character
        ans = ans + s.charAt(n-1);
        if(count>1) {
            ans = ans + count;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-- > 0){
            String s = br.readLine();
            compressedString(s);
            System.out.println();
        }
    }
}

