import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;
class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int N = S.length();
        Solution ob = new Solution();
        String[] element = br.readLine().trim().split("\\s+");
        int[] f = new int[N];
        for(int i = 0; i < N; i++){
            f[i] = Integer.parseInt(element[i]);
        }
        ArrayList<String> res  = ob.huffmanCodes(S,f,N);
        for(int i = 0; i < res.size(); i++)
        {
            System.out.print(res.get(i)+" ");
        }
        System.out.println();

    }
}

class Node {
    char c;
    int freq;
    Node left;
    Node right;

    public Node(char c, int freq, Node left, Node right) {
        this.c = c;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b)->{
            if(a.freq==b.freq) return 1;
            return a.freq-b.freq;
        });

        for(int i=0;i<S.length();i++) {
            pq.add(new Node(S.charAt(i),f[i],null,null));
        }

        while(pq.size() > 1) {
            Node n1 = pq.poll();
            Node n2 = pq.poll();
            Node newNode = new Node('*',n1.freq+n2.freq,n1,n2);
            pq.add(newNode);
        }

        // encoding
        Node root = pq.poll();
        String s = "";
        ArrayList<String> ans = new ArrayList<>();
        preOrder(root,s,ans);

        return ans;
    }

    static void preOrder(Node root, String s, ArrayList<String> ans) {
        if(root==null) return;

        if(root.left==null && root.right==null) {
            ans.add(s);
            return;
        }

        preOrder(root.left,s+"0",ans);
        preOrder(root.right,s+"1",ans);
    }

}