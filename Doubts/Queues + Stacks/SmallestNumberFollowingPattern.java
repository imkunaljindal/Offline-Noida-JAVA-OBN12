import java.io.*;
import java.util.*;


class Solution{
    public String smallestNumber(String str){
       Stack<Integer> st = new Stack<>();
       StringBuilder s = new StringBuilder();
       int n = str.length();

       for(int i=0;i<=n;i++) {
           st.push(i+1);
           if(i==n || str.charAt(i)=='i') {
               while(!st.isEmpty()) {
                   s.append(st.pop() + "");
               }
           }
       }

       return s.toString();
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Solution Obj = new Solution();
        System.out.print(Obj.smallestNumber(str));
    }
}