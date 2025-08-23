
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Main {
    static Node buildTree(String str){
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-- > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Solution tree = new Solution();
            ArrayList<Integer> ans = tree.bottomView(root);

            for(Integer num:ans)
                System.out.print(num+" ");

            System.out.println();
        }
    }
}


class Pair {
    Node node;
    int y;

    public Pair(Node node, int y) {
        this.node = node;
        this.y = y;
    }
}


class Solution{
    public ArrayList <Integer> bottomView(Node root)
    {
        Queue<Pair> q = new ArrayDeque<>();
        // <y,value>
        Map<Integer,Integer> mp = new TreeMap<>();

        q.add(new Pair(root,0));
        mp.put(0,root.data);

        while(!q.isEmpty()) {
            int sz = q.size();
            for(int i=0;i<sz;i++) {
                Pair p = q.poll();
                Node currNode = p.node;
                int y = p.y;

                mp.put(y,currNode.data);
                if(currNode.left!=null) {
                    q.add(new Pair(currNode.left,y-1));
                }
                if(currNode.right!=null) {
                    q.add(new Pair(currNode.right,y+1));
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int value: mp.values()) {
            ans.add(value);
        }

        return ans;
    }
}
