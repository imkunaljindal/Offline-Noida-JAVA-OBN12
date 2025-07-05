import java.util.*;

// Java program for flattening a Linked List
public class Main {

    /* Linked list Node*/
    static class Node {

        int data;
        Node right, down;

        Node(int data) {
            this.data = data;
            right = null;
            down = null;
        }
    }

    static Node merge(Node head1, Node head2) {
        if(head1==null) return head2;
        if(head2==null) return head1;

        Node result;
        if(head1.data < head2.data) {
            result = head1;
            result.down = merge(result.down,head2);
        }
        else {
            result = head2;
            result.down = merge(head1,result.down);
        }
        result.right = null;
        return result;
    }

    static Node flatten(Node root) {
        if(root==null || root.right==null) return root;
        root.right = flatten(root.right);
        root = merge(root,root.right);
        return root;
    }

    static void printList(Node head) {
        Node curr = head;
        while(curr!=null) {
            System.out.print(curr.data + " ");
            curr = curr.down;
        }
    }

    public static boolean isCorrect(Node claim) {
        if (claim.right != null) return false;
        Node copy = claim;
        while (copy.down != null) {
            if (copy.down.data < copy.data) return false;
            copy = copy.down;
        }
        return true;
    }

    // Driver's code
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node ll = new Node(-1), prev1 = null, head = ll;
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            Node prev2 = null, copy = ll;
            while (k-- != 0) {
                int val = sc.nextInt();
                copy.data = val;
                copy.down = new Node(-1);
                prev2 = copy;
                copy = copy.down;
            }
            prev2.down = null;
            ll.right = new Node(-1);
            prev1 = ll;
            ll = ll.right;
        }
        sc.close();
        prev1.right = null;
        Node flattenedNode = flatten(head);
        printList(flattenedNode);
        if (isCorrect(flattenedNode)) System.out.println(
                "yes"
        ); else System.out.println("no");
    }
}