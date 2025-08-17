import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;



class Main {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length) break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        Node root1 = buildTree(s1);
        Solution g = new Solution();
        System.out.println(g.diameter(root1));
    }
}


class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Pair {
    int height;
    int diameter;

    public Pair(int height, int diameter) {
        this.height = height;
        this.diameter = diameter;
    }
}

class Solution {

    public static int height(Node root) {
        if(root==null) return 0;
        return 1 + height(root.right) + height(root.left);
    }


    // O(N*N)
//    public static int diameter(Node root) {
//        if(root==null) return 0;
//
//        int leftDia = diameter(root.left);
//        int rightDia = diameter(root.right);
//        int diaIncRoot = height(root.left) + 1 + height(root.right);
//
//        return Math.max(Math.max(leftDia,rightDia),diaIncRoot);
//    }

    public static int diameter(Node root) {
        Pair p = helper(root);
        return p.diameter-1;
    }

    public static Pair helper(Node root) {
        if(root==null) return new Pair(0,0);

        Pair leftPair = helper(root.left);
        Pair rightPair = helper(root.right);

        int diaIncRoot = leftPair.height + 1 + rightPair.height;
        int height = Math.max(leftPair.height,rightPair.height) + 1;

        int overMaxDia = Math.max(Math.max(diaIncRoot,leftPair.diameter), rightPair.diameter);

        return new Pair(height,overMaxDia);
    }
}