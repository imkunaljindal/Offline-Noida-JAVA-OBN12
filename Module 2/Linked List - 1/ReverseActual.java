public static Node reverse(Node head) {

    if(head==null) return null;

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