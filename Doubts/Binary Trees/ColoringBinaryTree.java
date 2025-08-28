
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
        // System.out.print(str);
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
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int n = sc.nextInt();
        int x = sc.nextInt();
        //System.out.print(s);
        Node root = buildTree(s);
        Solution tree = new Solution();
        boolean ans = tree.btreeGameWinningMove(root,n,x);
        System.out.print(ans);

    }
}



class Solution{

    public static boolean btreeGameWinningMove(Node root, int n, int x) {
        if(root==null) return false;

        if (root.data == x) {
            int leftSub = find(root.left);
            int rightSub = find(root.right);
            int parentSub = n - (leftSub + rightSub + 1);

            return (leftSub > (rightSub + parentSub)) || (rightSub > (leftSub + parentSub)) || (parentSub > (leftSub + rightSub));
        }

        return btreeGameWinningMove(root.left,n,x) || btreeGameWinningMove(root.right,n,x);
    }

    static int find(Node root) {
        if(root==null) return 0;
        return 1 + find(root.left)  + find(root.right);
    }

}

