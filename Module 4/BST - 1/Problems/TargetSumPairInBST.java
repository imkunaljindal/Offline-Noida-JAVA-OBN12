import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node constructBST(int[] arr, int start, int end, Node root) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;

        if (root == null)
            root = new Node(arr[mid]);

        root.left = constructBST(arr, start, mid - 1, root.left);
        root.right = constructBST(arr, mid + 1, end, root.right);

        return root;

    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        Arrays.sort(arr);
        Node root = null;
        BinarySearchTree bst = new BinarySearchTree();
        root = bst.constructBST(arr, 0, n - 1, root);

        Accio A = new Accio();
        A.targetSum(root, target);

        sc.close();
    }
}

class Accio {

    static boolean found = false;

    static boolean find(Node root, int val) {
        if(root==null) return false;
        if(root.data == val) return true;

        if(val < root.data) return find(root.left,val);
        return find(root.right,val);
    }

    static void helper(Node root, int target, Node orgRoot) {
        if(root==null) return;

        helper(root.right,target,orgRoot);
        // find target - root.data
        int rem = target - root.data;

        if(find(orgRoot,rem)) {
            if(rem < root.data){
                found = true;
               System.out.println(rem + " " + root.data);
            }
        }

        helper(root.left,target,orgRoot);
    }


    public void targetSum(Node root, int tar)
    {
        if(root==null) {
            System.out.println(-1);
            return;
        }

        helper(root,tar,root);
        if(found==false) {
            System.out.println(-1);
        }
    }

}