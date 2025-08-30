import com.sun.source.tree.Tree;

import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);
    static int idx;

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder preOrder = new StringBuilder();
        helper(preOrder,root);
        return preOrder.toString();
    }

    static void helper(StringBuilder preOrder, TreeNode root) {
        if(root==null) {
            preOrder.append(-1).append(",");
            return;
        };
        preOrder.append(root.val).append(","); // process root
        helper(preOrder,root.left);
        helper(preOrder,root.right);
    }

    // Decodes your encoded data to tree.


    static TreeNode helperDeserialze(String[] treeValues) {
        if(idx>=treeValues.length) return null;
        int val = Integer.parseInt(treeValues[idx]);
        if(val==-1) {
            idx++;
            return null;
        }

        TreeNode node = new TreeNode(val);
        idx++;
        node.left = helperDeserialze(treeValues);
        node.right = helperDeserialze(treeValues);
        return node;
    }

    public static TreeNode deserialize(String str) {
        if(str==null) return null;
        idx = 0;
        String[] treeValues = str.split(","); // ["100","50","80","70"]
        TreeNode root = helperDeserialze(treeValues);
        return root;
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

        String s = serialize(root);
        display(deserialize(s));
    }

    public static void main(String[] args) {
        solve();
    }
}