import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

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

public class Main {

    static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Node ans = Obj.bstFromLevel(arr, n);
        printLevelOrder(ans);
        sc.close();
    }
}

class Pair {
    Node node;
    int min;
    int max;

    public Pair(Node node, int min, int max) {
        this.node = node;
        this.min = min;
        this.max = max;
    }
}

class Solution {
    Node bstFromLevel(int arr[], int n) {
       Queue<Pair> q = new ArrayDeque<>();
       Node root = new Node(arr[0]);
       q.add(new Pair(root, Integer.MIN_VALUE, root.data-1)); //expected left
        q.add(new Pair(root,root.data+1,Integer.MAX_VALUE)); // expected right

       int i = 1;
       while(!q.isEmpty() && i<n) {
           Pair curr = q.poll();
           Node parent = curr.node;
           if(arr[i] < curr.min || arr[i] > curr.max) continue;
           if(arr[i] < parent.data) {
               // left
               Node nNode = new Node(arr[i]);
               parent.left = nNode;
               q.add(new Pair(nNode,curr.min,nNode.data-1));
               q.add(new Pair(nNode,nNode.data+1, parent.data));
           }
           else {
               //right
               Node nNode = new Node(arr[i]);
               parent.right = nNode;
               q.add(new Pair(nNode,parent.data,nNode.data-1));
               q.add(new Pair(nNode,nNode.data+1, curr.max));
           }
           i++;
       }
       return root;
    }
}