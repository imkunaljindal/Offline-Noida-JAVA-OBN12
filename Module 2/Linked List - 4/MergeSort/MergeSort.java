import java.util.*;

class Solution {

    static Node findMid(Node head) {
        if(head==null || head.next==null) return head;

        Node slow = head;
        Node fast = head;

        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static Node merge(Node head1, Node head2) {
        Node curr1 = head1;
        Node curr2 = head2;
        Node dummy = new Node(-1);
        Node currDummy = dummy;

        while(curr1!=null && curr2!=null) {
            if(curr1.data < curr2.data) {
                currDummy.next = curr1;
                curr1 = curr1.next;
            }
            else {
                currDummy.next = curr2;
                curr2 = curr2.next;
            }

            currDummy = currDummy.next;
        }

        if(curr1!=null) {
            currDummy.next = curr1;
        }

        if(curr2!=null) {
            currDummy.next = curr2;
        }

        return dummy.next;
    }

    public static Node mergesort(Node head){
        if(head==null || head.next==null) return head;

        // find mid
        Node mid = findMid(head);
        Node head1 = head;  // head of left list
        Node head2 = mid.next;  // head of right list
        mid.next = null;

        head1 = mergesort(head1);
        head2 = mergesort(head2);

        Node newHead = merge(head1,head2);
        return newHead;
    }
}


class Node{
    int data;
    Node next = null;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class LinkedList{
    Node head;
    void add(int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node curr = head;
        while(curr.next != null)
            curr = curr.next;
        curr.next = new_node;
    }
}
public class MergeSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        LinkedList a = new LinkedList();
        for(int i = 0; i < n; i++){
            a.add(input.nextInt());
        }
        Solution Obj = new Solution();
        a.head = Obj.mergesort(a.head);
        Node h = a.head;
        while(h != null){
            System.out.print(h.data + " ");
            h = h.next;
        }
    }
}
