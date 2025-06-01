package Problems;

import java.util.*;
import java.io.*;
class AMazePaths {
    public static void aMazePaths(int n, int m, String psf,int i , int j){
        // base 1 - grid ke bahar
        if(i>n || j>m) return;

        // base 2 - destination
        if(i==n && j==m) {
            System.out.println(psf);
            return;
        }

        // option 1 - horizontal
        aMazePaths(n,m,psf+"h",i,j+1);
        //option 2 0 vertical
        aMazePaths(n,m,psf+"v",i+1,j);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine;
        inputLine = br.readLine().trim().split(" ");
        int n = Integer.parseInt(inputLine[0]);
        inputLine = br.readLine().trim().split(" ");
        int m = Integer.parseInt(inputLine[0]);
        aMazePaths(n, m, "",1,1);
    }
}