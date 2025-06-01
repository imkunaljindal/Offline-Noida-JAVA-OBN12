package Problems;

import java.util.*;

public class StairCasePath {
    static void printStairPaths(int n,String pathSoFar) {
        if(n<0) {
            return;
        }
        if(n==0) {
            System.out.println(pathSoFar);
            return;
        }
        //option 1 - 1 step
        printStairPaths(n-1,pathSoFar+"1");
        //option2 - 2 step
        printStairPaths(n-2,pathSoFar+"2");
        //option3 - 3 steps
        printStairPaths(n-3,pathSoFar+"3");
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        printStairPaths(n,"");
    }
}