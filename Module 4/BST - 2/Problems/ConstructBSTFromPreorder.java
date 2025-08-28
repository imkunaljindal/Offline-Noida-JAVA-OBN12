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

    static int idx = 0;
    public static TreeNode helper(int[] preOrder, int min, int max) {
        if(idx>=preOrder.length) return null;
        if(preOrder[idx] < min || preOrder[idx]>max) return null;

        TreeNode newNode = new TreeNode(preOrder[idx]);
        idx++;
        newNode.left = helper(preOrder,min,newNode.val-1);
        newNode.right = helper(preOrder,newNode.val+1,max);
        return newNode;
    }
    public static TreeNode CreateTree(int n,int[] preOrder) {
        TreeNode root = helper(preOrder,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return root;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append("->" + node.val + "<-");
        sb.append((node.right != null ? node.right.val : "."));
        System.out.println(sb.toString());
        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = CreateTree(n,pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}