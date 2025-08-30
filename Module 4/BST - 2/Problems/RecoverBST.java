import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode firstDefect = null;
    static TreeNode secondDefect = null;
    static TreeNode prevNode = new TreeNode(Integer.MIN_VALUE);

    static void inorder(TreeNode root) {
        if(root==null) return;
        inorder(root.left);
        if(firstDefect==null && prevNode.val > root.val) {
            firstDefect = prevNode;
        }
        if(firstDefect!=null && prevNode.val > root.val) {
            secondDefect = root;
        }
        prevNode = root;
        inorder(root.right);
    }

    public static void recoverTree(TreeNode root) {
        inorder(root);

        // swap
        int a = firstDefect.val;
        int b = secondDefect.val;
        int temp = a;
        a = b;
        b = temp;
        firstDefect.val = a;
        secondDefect.val = b;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }

        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        recoverTree(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}