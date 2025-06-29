
import java.util.*;
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class QuickSort {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a1 = sc.nextInt();
        Node head = new Node(a1);
        addToTheLast(head);

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            addToTheLast(new Node(a));
        }

        Solution abc=new Solution();
        Node node = abc.quickSort(head);

        printList(node);
        System.out.println();

        sc.close();
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }
}

class Solution {

    public static Node quickSort(Node node)
    {
        int len = 0;
        Node curr = node;

        while(curr!=null) {
            len++;
            curr = curr.next;
        }

        int arr[] = new int[len];
        curr = node;
        int i = 0;
        while(curr!=null) {
            arr[i++] = curr.data;
            curr = curr.next;
        }

        sort(arr);

        // constrcu linked list
        Node dummy = new Node(-1);
    }

}