class Node {
    int data;
    Node next;

    public Node(int val) {
        this.data = val;
        next = null;
    }
}

class LinkedList {
    Node head;

    //O(n)
    void addToLast(int val) {
        Node newNode = new Node(val);
        // when list is empty
        if(head==null) {
            head = newNode;
            return;
        }

        Node curr = head;
        while(curr.next!=null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // O(n)
    void printLL() {
        Node curr = head;
        while(curr!=null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }

    //O(n)
    int size() {
        int count = 0;
        Node curr = head;
        while(curr!=null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    void deleteLast() {

        if(head==null) return;
        if(head.next==null) {
            head = null;
            return;
        }

        Node curr = head;
        while(curr.next.next!=null) {
            curr = curr.next;
        }
        curr.next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.addToLast(10);
        l.addToLast(20);
        l.addToLast(30);
        l.addToLast(40);

        l.printLL();
        //System.out.println(l.size());
        l.deleteLast();
        l.printLL();
    }
}
