package LinkedList;

import java.util.*;

class Node {
    int data;
    Node next, random;

    Node(int d) {
        data = d;
        next = random = null;
    }
}

class CopyListWithRandomPointer {

    public static Node addToTheLast(Node head, Node node) {
        if (head == null) {
            head = node;
            return head;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = node;
            return head;
        }
    }

    public static boolean validation(Node head, Node res) {

        Node temp1 = head;
        Node temp2 = res;

        int len1 = 0, len2 = 0;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }



        if (len1 != len2) return false;

        HashMap<Node,Node> a = new HashMap<Node, Node>();

        temp1 = head;
        temp2 = res;
        while (temp1 != null) {

            if(temp1==temp2)
                return false;

            if (temp1.data != temp2.data) return false;



            if (temp1.random != null && temp2.random != null) {
                if (temp1.random.data != temp2.random.data) return false;
            } else if (temp1.random != null && temp2.random == null)
                return false;
            else if(temp1.random== null && temp2.random !=null)
                return false;
            if(!a.containsKey(temp1)){
                a.put(temp1,temp2);
            }

            temp1 = temp1.next;
            temp2 = temp2.next;

        }

        if(a.size()!=len1)
            return false;

        temp1 = head;
        temp2 = res;
        while (temp1 != null) {

            if (temp1.random != null && temp2.random != null) {
                if (a.get(temp1.random) != temp2.random) return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head= null,head2 = null;
        int n = sc.nextInt();
        int q = sc.nextInt();

        int a1 = sc.nextInt();
        head = addToTheLast(head,new Node(a1));
        head2 = addToTheLast(head2,new Node(a1));
        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            head = addToTheLast(head, new Node(a));
            head2 = addToTheLast(head2,new Node(a));
        }

        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            Node tempA = head;
            Node temp2A = head2;
            int count = -1;

            while (tempA != null) {
                count++;
                if (count == a - 1) break;
                tempA = tempA.next;
                temp2A = temp2A.next;
            }
            Node tempB = head;
            Node temp2B = head2;
            count = -1;

            while (tempB != null) {
                count++;
                if (count == b - 1) break;
                tempB = tempB.next;
                temp2B = temp2B.next;
            }

            // when both a is greater than N
            if (a <= n){
                tempA.random = tempB;
                temp2A.random = temp2B;
            }
        }

        Solution g = new Solution();
        Node res = g.copyList(head);

        if (validation(head, res) == true && validation(head2, res))
            System.out.println("1");
        else
            System.out.println("0");
    }
}

class Solution {

    Node copyList(Node head) {
        Node curr = head, temp = null;

        // insert additional node after
        // every node of original list
        while (curr != null) {
            temp = curr.next;

            // Inserting node
            curr.next = new Node(curr.data);
            curr.next.next = temp;
            curr = temp;
        }
        curr = head;

        // adjust the random pointers of the
        // newly added nodes
        while (curr != null) {
            if (curr.next != null)
                curr.next.random = (curr.random != null)
                        ? curr.random.next
                        : curr.random;

            // move to the next newly added node by
            // skipping an original node
            curr = curr.next.next;
        }

        Node original = head, copy = head.next;

        // save the start of copied linked list
        temp = copy;

        // now separate the original list and copied list
        while (original != null) {
            original.next =original.next.next;

            copy.next = (copy.next != null) ? copy.next.next
                    : copy.next;
            original = original.next;
            copy = copy.next;
        }
        return temp;
    }
}