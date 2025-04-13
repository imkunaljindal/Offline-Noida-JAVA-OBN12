package CharacterPattern;

import java.util.Scanner;

public class Pattern2 {

    public static void main(String[] args) {
        //A
        //BC
        //DEF
        //GHIJ

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int c = 65;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print((char)c);
//                c = (char)(c+1);
                c++;
            }
            System.out.println();
        }
    }
}
