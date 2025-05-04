package Problems;

import java.util.*;

public class PascalTriangle {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> triangle = pascalTriangle(n);
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                System.out.print(triangle.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> pascalTriangle(int numRows) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int r=0;r<numRows;r++) {
            ArrayList<Integer> currRow = new ArrayList<>();
            for(int c=0;c<=r;c++) {
                if(c==0 || c==r) {
                    currRow.add(1);
                }
                else {
                    int prev1 = ans.get(r-1).get(c-1);
                    int prev2 = ans.get(r-1).get(c);
                    currRow.add(prev2+prev1);
                }
            }
            ans.add(currRow);
        }
        return ans;

    }
}
