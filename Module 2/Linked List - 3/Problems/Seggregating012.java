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
        Node zeros = new Node(-1);
        Node ones = new Node(-1);
        Node twos = new Node(-1);
        Node curr = head;
        Node currZero = zeros;
        Node currOne = ones;
        Node currTwo = twos;

        while(curr!=null) {
            if(curr.data == 0) {
                currZero.next = curr;
                currZero = currZero.next;
            }
            else if(curr.data==1) {
                currOne.next = curr;
                currOne = currOne.next;
            }
            else {
                currTwo.next = curr;
                currTwo = currTwo.next;
            }
            curr = curr.next;
        }

        currOne.next = null;
        currZero.next = null;
        currTwo.next = null;

        if(ones.next==null) {
            currZero.next = twos.next;
        }
        else currZero.next = ones.next;
        currOne.next = twos.next;

        print(zeros.next);
    }

    static void print(Node head) {
        Node curr = head;
        while(curr!=null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
public class Seggregating012 {

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