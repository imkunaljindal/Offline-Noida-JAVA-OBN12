package Problems;

import java.io.*;
import java.util.*;
class Stack
{
    Queue<Integer> q = new ArrayDeque<>();
    void push(int a)
    {
        q.add(a);
    }

    int pop()
    {
        if(q.size()==0) return -1;

       int n = q.size();
       for(int i=0;i<n-1;i++) {
           int x = q.poll();
           q.add(x);
       }
       return q.poll();
    }
}
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        Stack g = new Stack();
        int q = sc.nextInt();
        while(q>0)
        {
            int QueryType = sc.nextInt();
            if(QueryType == 1){
                int a = sc.nextInt();
                g.push(a);
            }
            else if(QueryType == 2){
                System.out.print(g.pop() + " ");
            }
            q--;
        }
    }
}