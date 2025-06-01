package Problems;

import java.util.*;
public class AJNumber {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        input.nextLine();
        StringBuilder str=new StringBuilder(input.nextLine());

        solve(str,n);

        input.close();
    }

    public static boolean isAjNumber(int n) {
        if(n==0 || n==1) return false;

        int primes[] = {2,3,5,7,11,13,17,19,23,29};
        for(int i=0;i<primes.length;i++) {
            if(n==primes[i]) return true;
        }

        for(int prime: primes) {
            if(n%prime==0) return false;
        }
        return true;
    }

    public static boolean isUsed(boolean used[], int i, int j) {
        for(int k=i;k<=j;k++) {
            if(used[k]==true){
                return false;
            }
        }
        return true;
    }

    public static void solve(StringBuilder str,int n){
        boolean used[] = new boolean[n];

        int count = 0;
        for(int len=1;len<=n;len++) {
            for(int j=0;j<=n-len;j++) {
                String s = str.substring(j,j+len);
                int num = Integer.parseInt(s);
                if(isAjNumber(num) && !isUsed(used,j,j+len)) {
                    count++;
                    for(int k=j;k<=j+len;k++) {
                        used[k] = true;
                    }
                }
            }
        }

        System.out.println(count);
    }
}