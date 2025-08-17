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


    public static void main (String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int b=sc.nextInt();
        Node root = buildTree(s);
        Solution tree = new Solution();
        ArrayList<Integer> ans=tree.solve(root,b);
        for(int i=0;i<ans.size();i++)
            System.out.print(ans.get(i)+" ");

        System.out.println();

        sc.close();
    }
}



class Solution{

    public ArrayList<Integer> solve(Node root,int b) {
        ArrayList<Integer> ans = new ArrayList<>();
        helper(root, b, ans);
        Collections.reverse(ans);
        return ans;
    }

    public static Node helper(Node root, int b, ArrayList<Integer> ans) {
        if(root==null) return null;

        if(root.data==b) {
            ans.add(root.data);
            return root;
        }

        Node leftAns = helper(root.left,b,ans);
        if(leftAns!=null) {
            ans.add(root.data);
            return leftAns;
        }

        Node rightAns = helper(root.right,b,ans);
        if(rightAns!=null) {
            ans.add(root.data);
            return rightAns;
        }

        return null;
    }
}
