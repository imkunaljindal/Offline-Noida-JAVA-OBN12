import java.io.*;
import java.util.*;

class StackQueue
{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    void Push(int x)
    {
        if(s1.isEmpty()) {
            s1.push(x);
        }
        else {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(x);
            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

    }
    //Function to pop an element from queue by using 2 stacks.
    int Pop()
    {
        if(s1.isEmpty()) return -1;
        return s1.pop();
    }
}
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        StackQueue s = new StackQueue();
        int q = sc.nextInt();
        ArrayList<Integer> ans= new ArrayList<>();
        while(q>0)
        {
            int QueryType = sc.nextInt();
            if(QueryType == 1)
            {
                int a = sc.nextInt();
                s.Push(a);
            }
            else if(QueryType == 2)
                ans.add(s.Pop());
            q--;
        }
        for(int x:ans)
            System.out.print(x+" ");
        System.out.println();
    }
}