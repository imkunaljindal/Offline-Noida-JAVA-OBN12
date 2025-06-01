package Problems;

import java.io.*;
import java.util.*;

public class MazeProblem {
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr > dr || sc > dc) return;
        if(sr==dr && sc==dc) {
            System.out.println(psf);
            return;
        }

        for(int steps=1;steps<=dc;steps++) {
            printMazePaths(sr,sc+steps,dr,dc,psf+'h'+steps);
        }

        for(int steps=1;steps<=dr;steps++) {
            printMazePaths(sr+steps,sc,dr,dc,psf+'v'+steps);
        }

        for(int steps=1;steps<=Math.min(dr,dc);steps++) {
            printMazePaths(sr+steps,sc+steps,dr,dc,psf+'d'+steps);
        }




    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        printMazePaths(0, 0, n - 1, m - 1, "");
    }
}