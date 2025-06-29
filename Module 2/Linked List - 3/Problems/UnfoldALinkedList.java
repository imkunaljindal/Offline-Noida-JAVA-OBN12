import java.io.*;
import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class LinkedList{
    Node head;
    void add(int data ){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node current = head;
        while(current.next !=null){
            current = current.next;
        }
        current.next = new_node;
    }
}

class Solution {
    static void unfold(Node head)
    {
        Node evenIdx = new Node(-1);
        Node oddIdx = new Node(-1);
        Node curr = head;
        Node currEven = evenIdx;
        Node currOdd = oddIdx;

        int idx = 0;

        while(curr!=null) {
            if(idx%2==0) {
                currEven.next = curr;
                currEven = currEven.next;
            }
            else {
                currOdd.next = curr;
                currOdd = currOdd.next;
            }
            curr = curr.next;
            idx++;
        }

        oddIdx = oddIdx.next;
        oddIdx = reverse(oddIdx);
       // print(oddIdx);
        print(currEven.next);
        currEven.next = oddIdx;
        print(evenIdx.next);
    }

    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node nextNode;

        while(curr!=null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    static void print(Node head) {
        Node curr = head;

        while(curr!=null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
public class UnfoldALinkedList {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList l1= new LinkedList();
        for(int i=0;i<n;i++){
            l1.add(sc.nextInt());
        }
        Solution Ob = new Solution();
        Ob.unfold(l1.head);
    }
}